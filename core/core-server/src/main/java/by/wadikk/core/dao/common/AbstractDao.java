package by.wadikk.core.dao.common;

import by.wadikk.core.mapper.Parser;
import by.wadikk.core.mapper.ParserFactory;
import by.wadikk.persistence.entities.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AbstractDao<E extends BaseEntity> implements CommonDao<E> {

    Parser<E> parser = new ParserFactory().getParser();

    public AbstractDao(String entityFilename) {
        this.entityFilename = entityFilename;
    }

    private String entityFilename;

    private String className = this.getClass().getSimpleName();

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
