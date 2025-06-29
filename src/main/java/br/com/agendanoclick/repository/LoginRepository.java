package br.com.agendanoclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.agendanoclick.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
    Login findByEmail(String email);
}
