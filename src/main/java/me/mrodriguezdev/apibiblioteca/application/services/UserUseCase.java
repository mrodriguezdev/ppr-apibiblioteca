package me.mrodriguezdev.apibiblioteca.application.services;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.UserInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;

@ApplicationScoped
public class UserUseCase implements UserInputPort {
    @Inject
    UserOutputPort userOutputPort;

    @Override
    public void createUser(UserDTO userDTO) {
        String encryptedPassword = BcryptUtil.bcryptHash(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);
        this.userOutputPort.createUser(userDTO);
    }
    @Override
    public UserDTO findById(Long id) {
        return this.userOutputPort.findById(id);
    }
    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return this.userOutputPort.updateUser(userDTO);
    }
    @Override
    public void deleteUser(Long id) {
        this.userOutputPort.deleteUser(id);
    }
}
