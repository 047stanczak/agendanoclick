package br.com.agendanoclick.dto;

public record RegisterProfessionalDTO(String email, String password, String role, String name, String phone, String cpf_cnpj, String category, String bio) {
    
}
