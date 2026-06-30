package com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.TicketLabelAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketLabelAssignmentRepository extends JpaRepository<TicketLabelAssignment, Long> {

    List<TicketLabelAssignment> findByTicket_Id(Long ticketId);

    boolean existsByTicket_IdAndLabel_Id(Long ticketId, Long labelId);

    void deleteByTicket_IdAndLabel_Id(Long ticketId, Long labelId);

    void deleteByTicket_Id(Long ticketId);
}