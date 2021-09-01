package by.wadikk.core.service.common;

import by.wadikk.core.base.ErrorType;
import by.wadikk.core.exception.EntityException;
import by.wadikk.core.mapper.Mapper;
import by.wadikk.persistence.dto.AbstractDto;
import by.wadikk.persistence.entities.BaseEntity;
import com.google.common.collect.Lists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CommonServiceImplJPA<D extends AbstractDto,
        E extends BaseEntity, R extends JpaRepository<E, Long>>
        implements CommonService<D> {

    protected final R repository;
    protected final Mapper<E, D> mapper;

    public CommonServiceImplJPA(R repository, Mapper<E, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<D> save(D entity) {
        return Optional.ofNullable(
                mapper.toDto(repository.save(
                        mapper.toEntity(entity))));
    }

    @Override
    public Optional<D> update(D entity, Long id) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public Optional<D> getById(Long id) {
        return Optional.ofNullable(
                mapper.toDto(repository.getById(id)));
    }

    @Override
    public List<D> getAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.toDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteById(Long id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new EntityException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        repository.deleteById(id);
        return !repository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        return Lists.newArrayList(repository.findAll()).isEmpty();
    }
}