package com.example.javabackendtheoryspringboot.general.practice.issuetracker.controller;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.*;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.*;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper.LabelMapper;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper.TicketCommentMapper;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/practice/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketCommentMapper ticketCommentMapper;
    private final LabelMapper labelMapper;

    public TicketController(TicketService ticketService,
                            TicketCommentMapper ticketCommentMapper,
                            LabelMapper labelMapper) {
        this.ticketService = ticketService;
        this.ticketCommentMapper = ticketCommentMapper;
        this.labelMapper = labelMapper;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request) {
        TicketResponse response = ticketService.createTicket(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getTickets(
            @RequestParam(required = false) TicketStatus status,
            @RequestParam(required = false) TicketPriority priority) {

        List<TicketResponse> responses = ticketService.getTickets(status, priority);

        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long id) {
        TicketResponse response = ticketService.getTicketById(id);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TicketResponse> changeTicketStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTicketStatusRequest request) {

        TicketResponse response = ticketService.changeTicketStatus(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketResponse> updateTicket(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTicketRequest request) {

        TicketResponse response = ticketService.updateTicket(id, request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/{ticketId}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketCommentResponse addComment(@PathVariable Long ticketId,
                                            @Valid @RequestBody CreateTicketCommentRequest request) {
        TicketComment comment = ticketService.addComment(
                ticketId,
                request.getAuthorName(),
                request.getContent()
        );

        return ticketCommentMapper.toResponse(comment);
    }

    @GetMapping("/{ticketId}/comments")
    public List<TicketCommentResponse> getCommentsByTicketId(@PathVariable Long ticketId) {
        List<TicketComment> comments = ticketService.getCommentsByTicketId(ticketId);
        List<TicketCommentResponse> responses = new ArrayList<>();

        for (TicketComment comment : comments) {
            responses.add(ticketCommentMapper.toResponse(comment));
        }

        return responses;
    }

    @PostMapping("/{ticketId}/labels/{labelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void assignLabelToTicket(@PathVariable Long ticketId,
                                    @PathVariable Long labelId) {
        ticketService.assignLabelToTicket(ticketId, labelId);
    }

    @GetMapping("/{ticketId}/labels")
    public List<LabelResponse> getLabelsByTicketId(@PathVariable Long ticketId) {
        List<Label> labels = ticketService.getLabelsByTicketId(ticketId);
        List<LabelResponse> responses = new ArrayList<>();

        for (Label label : labels) {
            responses.add(labelMapper.toResponse(label));
        }

        return responses;
    }

    @DeleteMapping("/{ticketId}/labels/{labelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeLabelFromTicket(@PathVariable Long ticketId,
                                      @PathVariable Long labelId) {
        ticketService.removeLabelFromTicket(ticketId, labelId);
    }
}
