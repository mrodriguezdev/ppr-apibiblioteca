package me.mrodriguezdev.apibiblioteca.infraestructure.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.mrodriguezdev.apibiblioteca.infraestructure.entities.Lending;

@ApplicationScoped
public class LendingRepository implements PanacheRepositoryBase<Lending, Integer>  {
}
