package by.wadikk.core.service.implJpa;

import by.wadikk.core.base.ErrorType;
import by.wadikk.core.exception.EntityException;
import by.wadikk.core.mapper.ObjectMapper;
import by.wadikk.core.repository.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.service.ProductService;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImplJPA implements ProductService {

    private final ProductRepositoryJpa productRepository;

    @Autowired
    private final ObjectMapper objectMapper;

    @Autowired
    public ProductServiceImplJPA(ProductRepositoryJpa productRepository) {
        this.productRepository = productRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Optional<ProductDto> save(ProductDto productDto) {
        Product entity = objectMapper.map(productDto, Product.class);
        entity = productRepository.save(entity);
        return Optional.of(objectMapper.map(entity, ProductDto.class));
    }

    @Override
    public Optional<ProductDto> update(ProductDto entity, Long id) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public Optional<ProductDto> getById(Long id) {
        ProductDto productDto = objectMapper.map(productRepository.findById(id).get(), ProductDto.class);
        return Optional.of(productDto);
    }

    @Override
    public List<ProductDto> getAll() {
        return objectMapper.mapAll(productRepository.findAll(), ProductDto.class);
    }

    @Override
    public Boolean deleteById(Long id) {
        Product entity = productRepository.findById(id)
                .orElseThrow(() -> new EntityException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        productRepository.deleteById(id);
        return !productRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        productRepository.deleteAll();
        return Lists.newArrayList(productRepository.findAll()).isEmpty();
    }
}
