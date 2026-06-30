/*
package com.example.javabackendtheoryspringboot.general.practice.issuetracker.playground;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketPriority;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketStatus;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.service.TicketService;

import java.util.List;

public class IssueTrackerPlayground {

    public static void main(String[] args) {
        TicketService ticketService = new TicketService();

        Ticket firstTicket = ticketService.createTicket(
                "Driver modal is not auto-populated",
                "When clicking edit, the modal opens but previous values are not shown.",
                TicketPriority.HIGH
        );

        Ticket secondTicket = ticketService.createTicket(
                "Skeleton loader is missing",
                "The page should show a loading skeleton before data is loaded.",
                TicketPriority.MEDIUM
        );

        System.out.println("Total tickets: " + ticketService.getAllTickets().size());

        Ticket foundTicket = ticketService.getTicketById(1L);
        System.out.println("Found ticket: " + foundTicket.getTitle());

        Ticket updatedTicket = ticketService.changeTicketStatus(1L, TicketStatus.IN_PROGRESS);
        System.out.println("Updated ticket status: " + updatedTicket.getStatus());

        List<Ticket> allTickets = ticketService.getAllTickets();

        for (Ticket ticket : allTickets) {
            System.out.println(
                    ticket.getId() + " | " +
                            ticket.getTitle() + " | " +
                            ticket.getStatus() + " | " +
                            ticket.getPriority()
            );
        }

        ticketService.getTicketById(999L);
    }
}
*/
