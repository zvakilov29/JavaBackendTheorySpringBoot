package com.example.javabackendtheoryspringboot.general.practice.issuetracker.repository;

import com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}