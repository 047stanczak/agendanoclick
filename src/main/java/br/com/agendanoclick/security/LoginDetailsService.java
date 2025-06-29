package br.com.agendanoclick.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agendanoclick.model.Login;
import br.com.agendanoclick.repository.LoginRepository;

@Service
public class LoginDetailsService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Login login = loginRepository.findByEmail(email);
        if (login == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new LoginDetails(login);
    }

}

