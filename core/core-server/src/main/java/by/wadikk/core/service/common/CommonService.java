package by.wadikk.core.service.common;

import by.wadikk.persistence.dto.AbstractDto;
import by.wadikk.persistence.entities.BaseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommonService<E extends AbstractDto> {

    @Transactional
    Optional<E> save(E entity);

    @Transactional
    Optional<E> update(E entity, Long id);

    @Transactional
    Optional<E> getById(Long id);

    @Transactional
    List<E> getAll();

    @Transactional
    Boolean deleteById(Long id);

    @Transactional
    Boolean deleteAll();

}
