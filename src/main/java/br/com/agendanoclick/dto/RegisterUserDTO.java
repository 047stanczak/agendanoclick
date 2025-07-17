package br.com.agendanoclick.dto;

import java.time.LocalDate;

public record RegisterUserDTO(String email, String password, String role, String name, String phone, String cpf, LocalDate birth_day) {
    
}
