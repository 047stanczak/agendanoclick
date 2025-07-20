package br.com.agendanoclick.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.agendanoclick.dto.RegisterProfessionalDTO;
import br.com.agendanoclick.dto.RegisterUserDTO;
import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.model.LoginRole;
import br.com.agendanoclick.model.Professional;
import br.com.agendanoclick.model.User;
import br.com.agendanoclick.repository.ProfessionalRepository;
import br.com.agendanoclick.repository.UserRepository;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfessionalRepository professionalRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user/register")
    public String registerUser(@RequestBody RegisterUserDTO register) {
        Login newLogin = new Login();
        User newUser = new User();

        newLogin.setEmail(register.email());
        newLogin.setPassword(passwordEncoder.encode(register.password()));
        newLogin.setRole(LoginRole.valueOf(register.role()));
        newLogin.setCreated_at(LocalDate.now());
        newLogin.setIs_active(true);

        newUser.setName(register.name());
        newUser.setPhone(register.phone());
        newUser.setCpf(register.cpf());
        newUser.setBirth_day(register.birth_day());

        newUser.setLogin(newLogin);
        newLogin.setUser(newUser);
        userRepository.save(newUser);
        return "";
    }

    @PostMapping("/professional/register")
    public String registerProfessional(@RequestBody RegisterProfessionalDTO register) {
        Login newLogin = new Login();
        Professional newProfessional = new Professional();

        newLogin.setEmail(register.email());
        newLogin.setPassword(passwordEncoder.encode(register.password()));
        newLogin.setRole(LoginRole.valueOf(register.role()));
        newLogin.setCreated_at(LocalDate.now());
        newLogin.setIs_active(true);

        newProfessional.setName(register.name());
        newProfessional.setPhone(register.phone());
        newProfessional.setCpf_cnpj(register.cpf_cnpj());
        newProfessional.setCategory(register.category());
        newProfessional.setBio(register.bio());

        newProfessional.setLogin(newLogin);
        newLogin.setProfessional(newProfessional);
        professionalRepository.save(newProfessional);
        return "";
    }
    
}
