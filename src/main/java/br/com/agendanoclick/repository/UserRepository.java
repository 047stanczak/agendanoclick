package br.com.agendanoclick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.agendanoclick.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByName(String name);
}
