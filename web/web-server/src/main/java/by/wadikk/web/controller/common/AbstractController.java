package by.wadikk.web.controller.common;

import by.wadikk.core.service.common.CommonService;
import by.wadikk.persistence.dto.AbstractDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public abstract class AbstractController<E extends AbstractDto, S extends CommonService<E>>
        implements CommonController<E> {

    private final S service;

    public AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> create(E entity) {
        service.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<E>> getAll() {
        final List<E> entities = service.getAll();

        return entities != null && !entities.isEmpty()
                ? new ResponseEntity<>(entities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<E> getById(long id) {
        final E entity = service.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found, id=" + id));

        return entity != null
                ? new ResponseEntity<>(entity, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public E update(long id, E entity) {
        final E updated = service.update(entity, id)
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found, id=" + id));

        return updated;
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        final boolean deleted = service.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<?> deleteAll() {
        final boolean deletedAll = service.deleteAll();

        return deletedAll
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
