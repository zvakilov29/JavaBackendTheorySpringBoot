package com.example.javabackendtheoryspringboot.general.practice.issuetracker.domain;

public class Ticket {

    private Long id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketPriority priority;

    public Ticket(Long id,
                  String title,
                  String description,
                  TicketStatus status,
                  TicketPriority priority){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void changeStatus(TicketStatus newStatus) {
        this.status = newStatus;
    }

    public void changePriority(TicketPriority newPriority) {
        this.priority = newPriority;
    }
}
