package me.mrodriguezdev.apibiblioteca.infraestructure.mappers;

import me.mrodriguezdev.apibiblioteca.domains.models.LendingDTO;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Lending;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface LendingMapper {
    LendingDTO toDTO(Lending lending);
    List<LendingDTO> toLstDTO(List<Lending> lstlending);

    Lending toEntity(LendingDTO lendingDTO);
    List<Lending> toLstEntity(List<LendingDTO> lstlending);
}
