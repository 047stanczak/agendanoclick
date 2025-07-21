package br.com.agendanoclick.model;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "availability")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id")
    private Professional professional;

    private int week_day;

    private LocalTime start_time;

    private LocalTime break_start;

    private LocalTime break_end;

    private LocalTime end_time;

    private LocalTime slot_interval;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public void setWeek_day(int week_day) {
        this.week_day = week_day;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public void setBreak_start(LocalTime break_start) {
        this.break_start = break_start;
    }

    public void setBreak_end(LocalTime break_end) {
        this.break_end = break_end;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public void setSlot_interval(LocalTime slot_interval) {
        this.slot_interval = slot_interval;
    }
}
