package by.wadikk.core.service.implDAO;

import by.wadikk.core.annotation.ProfileExecution;
import by.wadikk.core.repositoryDTO.ProductRepositoryDAO;
import by.wadikk.core.service.ProductService;
import by.wadikk.persistence.entities.Product;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplDAO implements ProductService {

    private final ProductRepositoryDAO repository;

    @Autowired
    public ProductServiceImplDAO(ProductRepositoryDAO repository) {
        this.repository = repository;
    }


    @Override
    public Optional<Product> save(Product entity) {
        return repository.save(entity);
    }

    @Override
    public List<Product> saveAll(List<Product> entities) {
        for (Product product : entities) {
            save(product);
        }
        return getAll();
    }

    @Override
    public Optional<Product> update(Product entity, Long id) {
        entity.setId(id);
        return repository.update(entity);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return repository.get(id);
    }

    @Override
    @ProfileExecution
    public List<Product> getAll() {
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
