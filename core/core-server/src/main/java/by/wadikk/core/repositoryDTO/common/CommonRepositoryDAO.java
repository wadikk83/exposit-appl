package by.wadikk.core.repositoryDTO.common;


import by.wadikk.persistence.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CommonRepositoryDAO<E extends BaseEntity> {

    Optional<E> save(E entity);

    Optional<E> update(E entity);

    Optional<E> get(Long id);

    List<E> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();
}
