package br.com.agendanoclick.dto;

import java.time.LocalTime;

public record RegisterAvailabilityDTO(int week_day, LocalTime start_time, LocalTime break_start, LocalTime break_end, LocalTime end_time, LocalTime slot_interval) {
    
}
