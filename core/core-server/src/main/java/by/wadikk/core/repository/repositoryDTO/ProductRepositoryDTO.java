package by.wadikk.core.repository.repositoryDTO;

import by.wadikk.core.repository.repositoryDTO.common.AbstractRepositoryDTO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dto.ProductDto;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryDTO extends AbstractRepositoryDTO<ProductDto> {
    public ProductRepositoryDTO() {
        super(PersistenceConfiguration.PRODUCT_CLASS_NAME);
    }
}
