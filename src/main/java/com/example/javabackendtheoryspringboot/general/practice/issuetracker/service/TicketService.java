package com.example.javabackendtheoryspringboot.general.practice.issuetracker.service;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.*;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception.DuplicateTicketLabelAssignmentException;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception.InvalidTicketStatusTransitionException;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception.TicketNotFoundException;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository.TicketCommentRepository;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository.TicketLabelAssignmentRepository;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository.TicketRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.CreateTicketRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.TicketResponse;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.UpdateTicketRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.UpdateTicketStatusRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper.TicketMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final TicketCommentRepository ticketCommentRepository;
    private final LabelService labelService;
    private final TicketLabelAssignmentRepository ticketLabelAssignmentRepository;
    private final TicketMapper ticketMapper;

    public TicketService(TicketRepository ticketRepository,
                         TicketCommentRepository ticketCommentRepository,
                         LabelService labelService,
                         TicketLabelAssignmentRepository ticketLabelAssignmentRepository,
                         TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketCommentRepository = ticketCommentRepository;
        this.labelService = labelService;
        this.ticketLabelAssignmentRepository = ticketLabelAssignmentRepository;
        this.ticketMapper = ticketMapper;
    }

    @Transactional
    public TicketResponse createTicket(CreateTicketRequest request) {
        Ticket ticket = new Ticket(
                request.getTitle(),
                request.getDescription(),
                TicketStatus.OPEN,
                request.getPriority()
        );

        Ticket savedTicket = ticketRepository.save(ticket);

        return ticketMapper.toResponse(savedTicket);
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();

        List<TicketResponse> responses = new ArrayList<>();

        for (Ticket ticket : tickets) {
            responses.add(ticketMapper.toResponse(ticket));
        }

        return responses;
    }

    @Transactional(readOnly = true)
    public List<TicketResponse> getTickets(TicketStatus status, TicketPriority priority) {
        List<Ticket> allTickets = ticketRepository.findAll();
        List<TicketResponse> responses = new ArrayList<>();

        for (Ticket ticket : allTickets) {
            boolean statusMatches = status == null || ticket.getStatus() == status;
            boolean priorityMatches = priority == null || ticket.getPriority() == priority;

            if (statusMatches && priorityMatches) {
                responses.add(ticketMapper.toResponse(ticket));
            }
        }

        return responses;
    }

    @Transactional(readOnly = true)
    public TicketResponse getTicketById(Long id) {
        Ticket ticket = getTicketEntityById(id);

        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public TicketResponse updateTicket(Long id, UpdateTicketRequest request) {
        Ticket ticket = getTicketEntityById(id);

        ticket.updateDetails(
                request.getTitle(),
                request.getDescription(),
                request.getPriority()
        );

        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public TicketResponse changeTicketStatus(Long id, UpdateTicketStatusRequest request) {
        Ticket ticket = getTicketEntityById(id);

        TicketStatus newStatus = request.getStatus();

        if (!isValidStatusTransition(ticket.getStatus(), newStatus)) {
            throw new InvalidTicketStatusTransitionException(ticket.getStatus(), newStatus);
        }

        ticket.changeStatus(newStatus);

        return ticketMapper.toResponse(ticket);
    }

    @Transactional
    public void deleteTicket(Long id) {
        Ticket ticket = getTicketEntityById(id);

        ticketCommentRepository.deleteByTicket_Id(id);
        ticketLabelAssignmentRepository.deleteByTicket_Id(id);

        ticketRepository.delete(ticket);
    }

    private boolean isValidStatusTransition(TicketStatus currentStatus, TicketStatus newStatus) {
        if (currentStatus == newStatus) {
            return true;
        }

        if (currentStatus == TicketStatus.OPEN) {
            return newStatus == TicketStatus.IN_PROGRESS
                    || newStatus == TicketStatus.CLOSED;
        }

        if (currentStatus == TicketStatus.IN_PROGRESS) {
            return newStatus == TicketStatus.RESOLVED
                    || newStatus == TicketStatus.CLOSED;
        }

        if (currentStatus == TicketStatus.RESOLVED) {
            return newStatus == TicketStatus.CLOSED
                    || newStatus == TicketStatus.IN_PROGRESS;
        }

        if (currentStatus == TicketStatus.CLOSED) {
            return false;
        }

        return false;
    }

    @Transactional
    public TicketComment addComment(Long ticketId, String authorName, String content) {
        Ticket ticket = getTicketEntityById(ticketId);

        TicketComment comment = new TicketComment(
                ticket,
                authorName,
                content
        );

        return ticketCommentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<TicketComment> getCommentsByTicketId(Long ticketId) {
        getTicketEntityById(ticketId);

        return ticketCommentRepository.findByTicket_Id(ticketId);
    }

    @Transactional
    public void assignLabelToTicket(Long ticketId, Long labelId) {
        Ticket ticket = getTicketEntityById(ticketId);
        Label label = labelService.getLabelEntityById(labelId);

        if (ticketLabelAssignmentRepository.existsByTicket_IdAndLabel_Id(ticketId, labelId)) {
            throw new DuplicateTicketLabelAssignmentException(ticketId, labelId);
        }

        TicketLabelAssignment assignment = new TicketLabelAssignment(ticket, label);

        ticketLabelAssignmentRepository.save(assignment);
    }

    @Transactional(readOnly = true)
    public List<Label> getLabelsByTicketId(Long ticketId) {
        getTicketEntityById(ticketId);

        List<TicketLabelAssignment> assignments =
                ticketLabelAssignmentRepository.findByTicket_Id(ticketId);

        List<Label> labels = new ArrayList<>();

        for (TicketLabelAssignment assignment : assignments) {
            labels.add(assignment.getLabel());
        }

        return labels;
    }

    @Transactional
    public void removeLabelFromTicket(Long ticketId, Long labelId) {
        getTicketEntityById(ticketId);
        labelService.getLabelEntityById(labelId);

        ticketLabelAssignmentRepository.deleteByTicket_IdAndLabel_Id(ticketId, labelId);
    }

    @Transactional(readOnly = true)
    public Ticket getTicketEntityById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
    }
}
