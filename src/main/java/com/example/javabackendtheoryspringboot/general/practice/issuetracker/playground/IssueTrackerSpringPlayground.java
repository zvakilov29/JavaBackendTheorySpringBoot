package com.example.javabackendtheoryspringboot.general.practice.issuetracker.playground;

import com.example.javabackendtheoryspringboot.JavaBackendTheorySpringBootApplication;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketPriority;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.TicketService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class IssueTrackerSpringPlayground {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(JavaBackendTheorySpringBootApplication.class, args);

        TicketService ticketService = context.getBean(TicketService.class);

        /*Ticket ticket = ticketService.createTicket(
                "Spring-managed TicketService",
                "This ticket was created using a TicketService bean from the Spring context.",
                TicketPriority.HIGH
        );*/

/*
        System.out.println("Created ticket ID: " + ticket.getId());
        System.out.println("Created ticket title: " + ticket.getTitle());
*/

        context.close();
    }
}
