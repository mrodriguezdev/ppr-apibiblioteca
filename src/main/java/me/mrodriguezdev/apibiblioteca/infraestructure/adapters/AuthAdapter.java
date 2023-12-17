package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.AuthResponseDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.LoginDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.AuthOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.exceptions.BadRequestException;

import java.util.Objects;

@ApplicationScoped
public class AuthAdapter implements AuthOutputPort {

    @Inject
    UserAdapter userAdapter;

    @Inject
    RolAdapter rolAdapter;

    @Override
    public AuthResponseDTO login(LoginDTO loginDTO) {
        UserDTO userDTO = this.userAdapter.findByEmail(loginDTO.getEmail());

        if(Objects.isNull(userDTO)) throw new BadRequestException("User not found");

        this.validatePassword(userDTO, loginDTO.getPassword());

        return this.createResponseLogin("prueba", userDTO);
    }

    private void validatePassword(UserDTO userDTO, String password) {
        if(!BcryptUtil.matches(password, userDTO.getPassword())) throw new BadRequestException("Invalid username or password. Please check your credentials and try again");
    }

    private AuthResponseDTO createResponseLogin(String jwt, UserDTO userDTO) {
        RolDTO rol = this.findRolById(userDTO.getRol());
        AuthResponseDTO.Data data = new AuthResponseDTO.Data(userDTO.getCorreo(), userDTO.getNombre(), rol.getDescripcion());
        return new AuthResponseDTO(jwt, data);
    }

    private RolDTO findRolById(Integer id) {
        return this.rolAdapter.findById(id);
    }
}
