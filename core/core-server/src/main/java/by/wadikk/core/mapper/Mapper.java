package by.wadikk.core.mapper;


import by.wadikk.persistence.dto.AbstractDto;
import by.wadikk.persistence.entities.BaseEntity;

public interface Mapper<E extends BaseEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
