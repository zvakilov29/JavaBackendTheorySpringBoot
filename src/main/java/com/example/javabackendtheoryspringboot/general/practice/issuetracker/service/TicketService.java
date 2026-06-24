package com.example.javabackendtheoryspringboot.general.practice.issuetracker.service;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketPriority;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketStatus;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.exception.TicketNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final List<Ticket> tickets = new ArrayList<>();
    private Long nextId = 1L;

    public Ticket createTicket(String title, String description, TicketPriority priority) {
        Ticket ticket = new Ticket(
                nextId,
                title,
                description,
                TicketStatus.OPEN,
                priority
        );
        tickets.add(ticket);
        nextId++;

        return ticket;
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets);
    }

    public Ticket getTicketById(Long id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }

        throw new TicketNotFoundException(id);
    }

    public Ticket changeTicketStatus(Long id, TicketStatus newStatus) {
        Ticket ticket = getTicketById(id);
        ticket.changeStatus(newStatus);
        return ticket;
    }
}
