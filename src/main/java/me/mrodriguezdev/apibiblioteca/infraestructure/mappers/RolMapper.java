package me.mrodriguezdev.apibiblioteca.infraestructure.mappers;

import me.mrodriguezdev.apibiblioteca.domains.models.RolDTO;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface RolMapper {
    RolDTO toDTO(Rol rol);
    List<RolDTO> toLstDTO(List<Rol> lstRol);

    Rol toEntity(RolDTO rolDTO);
    List<Rol> toLstEntity(List<RolDTO> lstRolDTO);
}
