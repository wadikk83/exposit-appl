package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.ProductRepositoryDTO;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

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

