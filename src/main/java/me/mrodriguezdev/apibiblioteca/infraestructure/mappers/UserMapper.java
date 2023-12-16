package me.mrodriguezdev.apibiblioteca.infraestructure.mappers;

import me.mrodriguezdev.apibiblioteca.domains.models.UserDTO;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    @Mapping(target = "password", source = "contrasena")
    @Mapping(target = "rol", source = "id_rol")
    UserDTO toDTO(User user);
    List<UserDTO> toLstDTO(List<User> lstUser);

    @Mapping(target = "contrasena", source = "password")
    @Mapping(target = "id_rol", source = "rol")
    User toEntity(UserDTO userDTO);
    List<User> toLstEntity(List<UserDTO> lstUserDTO);
}
