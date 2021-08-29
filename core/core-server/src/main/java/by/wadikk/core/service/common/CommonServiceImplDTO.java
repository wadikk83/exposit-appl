package by.wadikk.core.service.common;

import by.wadikk.core.repository.repositoryDTO.common.CommonRepositoryDTO;
import by.wadikk.persistence.dto.AbstractDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class CommonServiceImplDTO<E extends AbstractDto, R extends CommonRepositoryDTO<E>>
        implements CommonService<E> {

    private final R repository;

    @Autowired
    public CommonServiceImplDTO(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> save(E entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<E> update(E entity, Long id) {
        return repository.update(entity);
    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.get(id);
    }

    @Override
    public List<E> getAll() {
        return repository.getAll();
    }

    @Override
    public Boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Boolean deleteAll() {
        return repository.deleteAll();
    }
}
