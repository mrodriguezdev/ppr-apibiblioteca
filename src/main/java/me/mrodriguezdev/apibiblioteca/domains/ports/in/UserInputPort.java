package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

import java.util.Optional;

@ApplicationScoped
public interface UserInputPort {
    void createUser(UserDTO userDTO);
    UserDTO findById(Long id);
    Optional<UserDTO> updateUser(UserDTO userDTO);
    void deleteUser(Long id);
}
