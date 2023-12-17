package me.mrodriguezdev.apibiblioteca.infraestructure.adapters;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.RolOutputPort;
import me.mrodriguezdev.apibiblioteca.domains.ports.out.UserOutputPort;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.User;
import me.mrodriguezdev.apibiblioteca.infraestructure.exceptions.NotFoundException;
import me.mrodriguezdev.apibiblioteca.infraestructure.mappers.UserMapper;
import me.mrodriguezdev.apibiblioteca.infraestructure.repositories.UserRepository;

import java.util.List;

@ApplicationScoped
public class UserAdapter implements UserOutputPort {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = this.userMapper.toEntity(userDTO);
        this.userRepository.persist(user);
    }

    @Override
    public UserDTO findById(Long id){
        User user = this.userRepository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setNombre(user.getNombre());
        userDTO.setCorreo(user.getCorreo());

        return userDTO;
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        User user = this.userRepository.findByIdOptional(userDTO.getId())
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + userDTO.getId()));

        if(userDTO.getNombre() != null) user.setNombre(userDTO.getNombre());
        if(userDTO.getCorreo() != null) user.setCorreo(userDTO.getCorreo());
        if(userDTO.getPassword() != null) user.setContrasena(BcryptUtil.bcryptHash(userDTO.getPassword()));

        UserDTO responseDto  = new UserDTO();
        responseDto .setId(user.getId());
        responseDto .setNombre(user.getNombre());
        responseDto .setCorreo(user.getCorreo());

        return responseDto;
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.userRepository.findByIdOptional(id)
                .map(user -> this.userRepository.deleteById(id))
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
    }

    @Override
    public List<UserDTO> listAll() {
        List<UserDTO> listUsers = this.userMapper
                .toLstDTO(this.userRepository.listAll(Sort.ascending("id")));

        if(listUsers.isEmpty()) throw new NotFoundException("No users found");

        return listUsers;
    }
}
