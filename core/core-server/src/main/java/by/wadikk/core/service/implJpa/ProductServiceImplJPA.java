package by.wadikk.core.service.implJpa;

import by.wadikk.core.annotation.ProfileExecution;
import by.wadikk.core.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.service.ProductService;
import by.wadikk.persistence.base.ErrorType;
import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.exception.SampleException;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductServiceImplJPA implements ProductService {

    private ProductRepositoryJpa productRepository;

    @Autowired
    public ProductServiceImplJPA(ProductRepositoryJpa productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> save(Product entity) {
        return Optional.of(productRepository.save(entity));
    }

    @Override
    public List<Product> saveAll(List<Product> entities) {
        return Lists.newArrayList(productRepository.saveAll(entities));
    }

    @Override
    public Optional<Product> update(Product entity, Long id) {
        entity.setId(id);
        return Optional.of(productRepository.save(entity));
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    @ProfileExecution
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Boolean deleteById(Long id) {

        Product entity = getById(id)
                .orElseThrow(() -> new SampleException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id)));
        productRepository.deleteById(id);
        return !productRepository.findById(entity.getId()).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        productRepository.deleteAll();
        return Lists.newArrayList(productRepository.findAll()).isEmpty();
    }
}
