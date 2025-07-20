package br.com.agendanoclick.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.agendanoclick.dto.LoginDTO;
import br.com.agendanoclick.dto.LoginResponse;
import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.security.LoginDetails;
import br.com.agendanoclick.security.TokenService;
import br.com.agendanoclick.service.LastLoginUpdater;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LastLoginUpdater lastLoginUpdater;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDto) {
        var EmailPassword = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
        var auth = this.authenticationManager.authenticate(EmailPassword);

        LoginDetails loginDetails = (LoginDetails) auth.getPrincipal();
        Login login = loginDetails.getLogin();
        var token = tokenService.generateToken(login);

        lastLoginUpdater.updateLastLogin(loginDto.email());

        return ResponseEntity.ok(new LoginResponse(token));
    }    
}
