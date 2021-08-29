package by.wadikk.core.service.implJpa;

import by.wadikk.core.base.ErrorType;
import by.wadikk.core.exception.EntityException;
import by.wadikk.core.mapper.ObjectMapper;
import by.wadikk.core.repository.repositoryJPA.StoreRepositoryJpa;
import by.wadikk.core.service.StoreService;
import by.wadikk.persistence.dto.ArticleDto;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.dto.StoreDto;
import by.wadikk.persistence.entities.Article;
import by.wadikk.persistence.entities.Store;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StoreServiceImplJPA implements StoreService {

    private final StoreRepositoryJpa storeRepository;

    @Autowired
    private final ObjectMapper objectMapper;

    public StoreServiceImplJPA(StoreRepositoryJpa storeRepository) {
        this.storeRepository = storeRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Optional<StoreDto> save(StoreDto storeDto) {
        Store entity = objectMapper.map(storeDto, Store.class);
        entity = storeRepository.save(entity);
        return Optional.of(objectMapper.map(entity, StoreDto.class));
    }

    @Override
    public Optional<StoreDto> update(StoreDto entity, Long id) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public Optional<StoreDto> getById(Long id) {
        StoreDto storeDto = objectMapper.map(storeRepository.findById(id).get(), StoreDto.class);
        return Optional.of(storeDto);
    }

    @Override
    public List<StoreDto> getAll() {
        return objectMapper.mapAll(storeRepository.findAll(), StoreDto.class);
    }

    @Override
    public Boolean deleteById(Long id) {
        Store entity = storeRepository.findById(id)
                .orElseThrow(() -> new EntityException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        storeRepository.deleteById(id);
        return !storeRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        storeRepository.deleteAll();
        return Lists.newArrayList(storeRepository.findAll()).isEmpty();
    }
}