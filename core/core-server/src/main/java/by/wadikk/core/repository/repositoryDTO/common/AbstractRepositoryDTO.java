package by.wadikk.core.repository.repositoryDTO.common;


import by.wadikk.core.parser.ParserFactory;
import by.wadikk.persistence.dto.AbstractDto;
import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.core.parser.Parser;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AbstractRepositoryDTO<E extends AbstractDto> implements CommonRepositoryDTO<E> {


    private Parser<E> parser;

    private String entityFilename;

    public AbstractRepositoryDTO(String entityFilename) {

        this.entityFilename = entityFilename;
        parser = new ParserFactory().getParser();
        //parser = new JsonParser<>();
    }

    @Override
    public Optional<E> save(E entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        }
        List<E> entityList = getAll();
        entityList.add(entity);
        parser.write(entityFilename, entityList);
        return Optional.of(entity);
    }

    @Override
    public Optional<E> update(E entity) {
        return save(entity);
    }

    @Override
    public Optional<E> get(Long id) {
        return getAll()
                .stream()
                .filter(s -> s.getId().equals(id))
                .findAny();
    }

    @Override
    public List<E> getAll() {
        return parser.read(entityFilename);
    }

    @Override
    public Boolean deleteById(Long id) {
        List<E> entityList = getAll();
        Optional<E> toBeDeleted = get(id);
        if (toBeDeleted != null) {
            entityList.remove(toBeDeleted);
            parser.write(entityFilename, entityList);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteAll() {
        List<E> entityList = getAll();
        entityList.clear();
        parser.write(entityFilename, entityList);
        return true;
    }
}
