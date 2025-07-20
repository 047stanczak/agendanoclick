package br.com.agendanoclick.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.repository.LoginRepository;

@Service
public class LastLoginUpdater {

    @Autowired
    LoginRepository loginRepository;

    public void updateLastLogin(String email){
        LocalDateTime accessMoment = LocalDateTime.now();

        Login login = loginRepository.findByEmail(email);
        login.setLast_login(accessMoment);
        loginRepository.save(login);
    }
}
