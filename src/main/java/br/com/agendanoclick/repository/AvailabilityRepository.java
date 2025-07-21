package br.com.agendanoclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendanoclick.model.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long>{
}
