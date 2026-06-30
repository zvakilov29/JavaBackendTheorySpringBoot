package com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.TicketResponse;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

    public TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getPriority(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt()
        );
    }
}
