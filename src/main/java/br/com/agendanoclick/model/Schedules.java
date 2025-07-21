package br.com.agendanoclick.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id")
    private Professional professional;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String status;

    private String service;

    private String notes;

    private LocalDateTime created_at;

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
