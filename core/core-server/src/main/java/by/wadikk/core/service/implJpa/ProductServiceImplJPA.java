package by.wadikk.core.service.implJpa;

import by.wadikk.core.mapper.Mapper;
import by.wadikk.core.repository.repositoryJPA.ProductRepositoryJpa;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.common.CommonServiceImplJPA;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "true")
@Service
public class ProductServiceImplJPA extends CommonServiceImplJPA<ProductDto, Product, ProductRepositoryJpa>
        implements ProductService {


    public ProductServiceImplJPA(ProductRepositoryJpa repository, Mapper<Product, ProductDto> mapper) {
        super(repository, mapper);
    }

    @Override
    public List<ProductDto> findAll(Specification<Product> productSpecification) {
        return repository.findAll(productSpecification).stream()
                .map(entity -> mapper.toDto(entity))
                .collect(Collectors.toList());
    }
}
