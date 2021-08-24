package by.wadikk.core.repositoryDTO;

import by.wadikk.core.repositoryDTO.common.AbstractRepositoryDAO;
import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryDAO extends AbstractRepositoryDAO<Product> {

    public ProductRepositoryDAO() {
        super(PersistenceConfiguration.PRODUCT_CLASS_NAME);
    }
}
