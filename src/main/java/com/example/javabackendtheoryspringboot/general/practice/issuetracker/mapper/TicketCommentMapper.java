package com.example.javabackendtheoryspringboot.general.practice.issuetracker.mapper;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketComment;
import com.example.javabackendtheoryspringboot.general.practice.issuetracker.dto.TicketCommentResponse;
import org.springframework.stereotype.Component;

@Component
public class TicketCommentMapper {

    public TicketCommentResponse toResponse(TicketComment comment) {
        return new TicketCommentResponse(
                comment.getId(),
                comment.getTicketId(),
                comment.getAuthorName(),
                comment.getContent(),
                comment.getCreatedAt()
        );
    }
}
