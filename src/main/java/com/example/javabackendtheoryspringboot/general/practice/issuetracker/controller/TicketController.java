package com.example.javabackendtheoryspringboot.general.practice.issuetracker.controller;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketStatus;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.CreateTicketRequest;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("/api/practice/tickets")
    public Ticket createTicket(@Valid @RequestBody CreateTicketRequest request){
        return ticketService.createTicket(
                request.getTitle(),
                request.getDescription(),
                request.getPriority()
        );
    }

    @GetMapping("/api/practice/tickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/api/practice/tickets/{id}")
    public Ticket getTicketById(@PathVariable Long id){
        return ticketService.getTicketById(id);
    }

    @PatchMapping("/api/practice/tickets/{id}/status")
    public Ticket changeTicketStatus(@PathVariable Long id,
                                     @RequestParam TicketStatus status){
        return ticketService.changeTicketStatus(id, status);
    }
}
