package me.mrodriguezdev.apibiblioteca.application.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.in.UserInputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.exceptions.NotFoundException;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class UserUseCase implements UserInputPort {
    @Inject
    UserOutputPort userOutputPort;

    @Override
    public void createUser(UserDTO userDTO) {
        this.userOutputPort.createUser(userDTO);
    }
    @Override
    public UserDTO findById(Long id) {
        UserDTO userDTO = this.userOutputPort.findById(id);

        if(Objects.isNull(userDTO)) throw new NotFoundException("User not found");

        return userDTO;
    }
    @Override
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return this.userOutputPort.updateUser(userDTO);
    }
    @Override
    public void deleteUser(Long id) {
        this.userOutputPort.deleteUser(id);
    }
}
