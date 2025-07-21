package br.com.agendanoclick.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.agendanoclick.model.Login;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Login login) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("agendanoclick")
                .withSubject(login.getEmail())
                .withClaim("id", login.getId())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating authentication token. " + exception);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                .withIssuer("agendanoclick")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    public Long getId(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);

        return jwt.getClaim("id").asLong();
    }

    public Long getIdFromToken(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("id").asLong();
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }
}
