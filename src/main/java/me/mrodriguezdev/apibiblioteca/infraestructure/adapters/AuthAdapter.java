package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.LoginDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.*;
import me.mrodriguezdev.apibiblioteca.infraestructure.exceptions.BadRequestException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Objects;

@ApplicationScoped
public class AuthAdapter implements AuthOutputPort {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private String issuer;

    @Inject
    UserOutputPort userOutputPort;

    @Inject
    RolOutputPort rolOutputPort;

    @Inject
    JwtUtilOutputPort jwtUtilOutputPort;

    @Inject
    BcryptUtilOutputPort bcryptUtilOutputPort;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        UserDTO userDTO = this.userOutputPort.findByEmail(loginDTO.getEmail());
        if(Objects.isNull(userDTO)) throw new BadRequestException("User not found");

        this.validatePassword(userDTO, loginDTO.getPassword());

        return this.createResponseLogin(userDTO);
    }

    private void validatePassword(UserDTO userDTO, String password) {
        if(!this.bcryptUtilOutputPort.bcryptCheck(password, userDTO.getPassword())) throw new BadRequestException("Invalid username or password. Please check your credentials and try again");
    }

    private AuthResponseDTO createResponseLogin(UserDTO userDTO) {
        RolDTO rol = this.findRolById(userDTO.getRol());
        AuthResponseDTO.Data data = new AuthResponseDTO.Data(userDTO.getCorreo(), userDTO.getNombre(), rol.getDescripcion());
        String jwt = this.generateToken(data);
        return new AuthResponseDTO(jwt, data);
    }

    private String generateToken(AuthResponseDTO.Data data) {
        return this.jwtUtilOutputPort.generateToken(data);
    }

    private RolDTO findRolById(Integer id) {
        return this.rolOutputPort.findById(id);
    }
}
