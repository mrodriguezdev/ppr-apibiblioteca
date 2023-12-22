package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.constants.TipoUsuario;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.UserInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.BcryptUtilOutputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;

import java.util.List;

@ApplicationScoped
public class UserUseCase implements UserInputPort {
    @Inject
    UserOutputPort userOutputPort;

    @Inject
    BcryptUtilOutputPort bcryptUtilOutputPort;

    @Override
    public void createUser(UserDTO userDTO) {
        String encryptedPassword = this.bcryptUtilOutputPort.bcryptHash(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);
        userDTO.setRol(TipoUsuario.USUARIO.getValor());
        this.userOutputPort.create(userDTO);
    }

    @Override
    public void createPersonal(UserDTO userDTO) {
        String encryptedPassword = this.bcryptUtilOutputPort.bcryptHash(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);
        userDTO.setRol(TipoUsuario.PERSONAL.getValor());
        this.userOutputPort.create(userDTO);
    }

    @Override
    public void createAdmin(UserDTO userDTO) {
        String encryptedPassword = this.bcryptUtilOutputPort.bcryptHash(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);
        userDTO.setRol(TipoUsuario.ADMIN.getValor());
        this.userOutputPort.create(userDTO);
    }

    @Override
    public List<UserDTO> listAll() {
        return this.userOutputPort.listAll();
    }

    @Override
    public UserDTO findById(Long id) {
        return this.userOutputPort.findById(id);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        return this.userOutputPort.update(userDTO);
    }

    @Override
    public void delete(Long id) {
        this.userOutputPort.delete(id);
    }
}
