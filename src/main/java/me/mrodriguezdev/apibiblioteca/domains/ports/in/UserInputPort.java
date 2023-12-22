package me.mrodriguezdev.apibiblioteca.domains.ports.in;

import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;

import java.util.List;

@ApplicationScoped
public interface UserInputPort {
    void createUser(UserDTO userDTO);

    void createPersonal(UserDTO userDTO);

    void createAdmin(UserDTO userDTO);

    List<UserDTO> listAll();

    UserDTO findById(Long id);

    UserDTO update(UserDTO userDTO);

    void delete(Long id);
}
