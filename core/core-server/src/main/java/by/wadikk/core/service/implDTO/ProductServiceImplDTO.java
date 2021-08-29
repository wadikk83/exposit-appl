package by.wadikk.core.service.implDTO;

import by.wadikk.core.repository.repositoryDTO.ProductRepositoryDTO;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.common.CommonServiceImplDTO;
import by.wadikk.persistence.dto.ProductDto;

public class ProductServiceImplDTO extends CommonServiceImplDTO<ProductDto, ProductRepositoryDTO>
        implements ProductService {

    public ProductServiceImplDTO(ProductRepositoryDTO repository) {
        super(repository);
    }
}

