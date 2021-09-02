package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.ProductRepositoryDTO;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(name = "datasource.type.JPA", havingValue = "false")
public class ProductServiceImplDTO extends CommonServiceImplDTO<ProductDto, ProductRepositoryDTO>
        implements ProductService {

    public ProductServiceImplDTO(ProductRepositoryDTO repository) {
        super(repository);
    }

    @Override
    public List<ProductDto> findAll(Specification<Product> productSpecification) {
        return new ArrayList<ProductDto>();
    }
}

