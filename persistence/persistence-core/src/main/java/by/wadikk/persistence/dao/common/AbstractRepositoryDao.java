package by.wadikk.persistence.dao.common;


import by.wadikk.persistence.entities.BaseEntity;
import by.wadikk.persistence.mapper.JsonParser;
import by.wadikk.persistence.mapper.Parser;
import by.wadikk.persistence.mapper.ParserFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AbstractRepositoryDao<E extends BaseEntity> implements CommonRepositoryDao<E> {


    private Parser<E> parser;

    private String entityFilename;

    public AbstractRepositoryDao(String entityFilename) {

        this.entityFilename = entityFilename;

        parser = new JsonParser<>();

        // TODO: 23.08.2021 Заглушка
        //parser = new ParserFactory().getParser();
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
