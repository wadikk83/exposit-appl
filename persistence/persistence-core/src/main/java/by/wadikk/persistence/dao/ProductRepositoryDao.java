package by.wadikk.persistence.dao;

import by.wadikk.persistence.PersistenceConfiguration;
import by.wadikk.persistence.dao.common.AbstractRepositoryDao;
import by.wadikk.persistence.entities.Product;

public class ProductRepositoryDao extends AbstractRepositoryDao<Product> {

    public ProductRepositoryDao() {
        super(PersistenceConfiguration.PRODUCT_CLASS_NAME);
    }
}
