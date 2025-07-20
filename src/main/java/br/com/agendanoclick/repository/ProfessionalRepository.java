package br.com.agendanoclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendanoclick.model.Professional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long>{
    Professional findByName(String name);
}
