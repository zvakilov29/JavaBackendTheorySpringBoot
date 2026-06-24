package com.example.javabackendtheoryspringboot.general.practice.issuetracker.controller;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketPriority;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @PostMapping("api/practice/tickets")
    public Ticket createTicket(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam TicketPriority priority){
        return ticketService.createTicket(title, description, priority);
    }

    @GetMapping("api/practice/tickets")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }
}
