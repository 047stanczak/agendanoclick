package br.com.agendanoclick.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.agendanoclick.dto.RegisterDTO;
import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.model.LoginRole;
import br.com.agendanoclick.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegisterController {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/register")
    public String registerUser(@RequestBody RegisterDTO register) {
        Login newLogin = new Login();
        newLogin.setEmail(register.email());
        newLogin.setPassword(passwordEncoder.encode(register.password()));
        newLogin.setRole(LoginRole.valueOf(register.role()));
        loginRepository.save(newLogin);
        return "";
    }
    
}
