package by.wadikk.core.service.common;


import by.wadikk.persistence.base.ErrorType;
import by.wadikk.persistence.common.CommonRepositoryRepository;
import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.exception.SampleException;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<E extends BaseEntity>
        {

   /* private final CommonRepositoryRepository repository;


    public AbstractService(CommonRepositoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> save(E entity) {
        return (Optional<E>) repository.save(entity);
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        return Lists.newArrayList(repository.saveAll(entities));
    }

    @Override
    public Optional<E> update(E entity) {
        return (Optional<E>) repository.save(entity);
    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public Boolean deleteById(Long id) {
        E entity = getById(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        repository.delete(entity);
        return !repository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        return Lists.newArrayList(repository.findAll()).isEmpty();
    }*/
}

