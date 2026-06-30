package com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketCommentRepository extends JpaRepository<TicketComment, Long> {

    List<TicketComment> findByTicket_Id(Long ticketId);

    void deleteByTicket_Id(Long ticketId);
}