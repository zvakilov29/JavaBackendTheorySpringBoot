package com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "ticket_label_assignments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_ticket_label_assignment",
                        columnNames = {"ticket_id", "label_id"}
                )
        }
)
public class TicketLabelAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label_id", nullable = false)
    private Label label;

    @Column(name = "assigned_at", nullable = false, updatable = false)
    private LocalDateTime assignedAt;

    public TicketLabelAssignment() {
    }

    public TicketLabelAssignment(Ticket ticket, Label label) {
        this.ticket = ticket;
        this.label = label;
    }

    @PrePersist
    public void prePersist() {
        this.assignedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getTicketId() {
        return ticket.getId();
    }

    public Long getLabelId() {
        return label.getId();
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Label getLabel() {
        return label;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }
}
