package by.wadikk.core.service.common;

import by.wadikk.persistence.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends BaseEntity> {

    Optional<E> save(E entity);

    List<E> saveAll(List<E> entities);

    Optional<E> update(E entity, Long id);

    Optional<E> getById(Long id);

    List<E> getAll();

    Boolean deleteById(Long id);

    Boolean deleteAll();
}
