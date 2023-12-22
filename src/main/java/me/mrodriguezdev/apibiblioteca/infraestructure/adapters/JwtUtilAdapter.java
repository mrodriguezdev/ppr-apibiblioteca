package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.JwtUtilOutputPort;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class JwtUtilAdapter implements JwtUtilOutputPort {
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private String issuer;

    @Override
    public String generateToken(AuthResponseDTO.Data data) {
        Long currentTimeInSecs = this.currentTimeInSecs();
        Long duration = this.durationTimeInSecs();

        Set<String> roles = new HashSet<>(
                List.of(data.getRol())
        );

        return Jwt.issuer(this.issuer)
                .subject(data.getNombre())
                .groups(roles)
                .claim(Claims.email.name(), data.getEmail())
                .issuedAt(currentTimeInSecs)
                .expiresAt(currentTimeInSecs + duration)
                .sign();
    }

    private Long currentTimeInSecs() {
        return Instant.now().getEpochSecond();
    }

    private Long durationTimeInSecs() {
        return Duration.ofHours(2).toSeconds();
    }
}
