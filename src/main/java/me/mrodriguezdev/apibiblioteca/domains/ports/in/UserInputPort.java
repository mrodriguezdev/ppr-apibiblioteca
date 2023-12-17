package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

import java.util.List;

@ApplicationScoped
public interface UserInputPort {
    void createUser(UserDTO userDTO);

    UserDTO findById(Long id);

    UserDTO updateUser(UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> getAllUsers();
}
