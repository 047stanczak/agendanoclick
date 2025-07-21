package br.com.agendanoclick.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendanoclick.dto.RegisterAvailabilityDTO;
import br.com.agendanoclick.model.Availability;
import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.model.Professional;
import br.com.agendanoclick.repository.AvailabilityRepository;
import br.com.agendanoclick.repository.LoginRepository;
import br.com.agendanoclick.repository.ProfessionalRepository;
import br.com.agendanoclick.security.TokenService;

@RestController
public class AvailabilityController {

    @Autowired
    TokenService tokenService;

    @Autowired
    ProfessionalRepository professionalRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    AvailabilityRepository avaibilityRepository;

    @PostMapping("/register/availability")
    public ResponseEntity<?> registerAvailability(@RequestHeader("Authorization") String authHeader, @RequestBody RegisterAvailabilityDTO register){
        String token = authHeader.replace("Bearer ", "");
        Long loginId = tokenService.getId(token);

        Login login = loginRepository.findById(loginId).orElseThrow();
        Professional professional = professionalRepository.findByLogin(login);
        Availability newAvailability = new Availability();

        newAvailability.setWeek_day(register.week_day());
        newAvailability.setStart_time(register.start_time());
        newAvailability.setBreak_start(register.break_start());
        newAvailability.setBreak_end(register.break_end());
        newAvailability.setEnd_time(register.end_time());
        newAvailability.setSlot_interval(register.slot_interval());
        newAvailability.setProfessional(professional);

        avaibilityRepository.save(newAvailability);

        return ResponseEntity.ok(null);
    }
}
