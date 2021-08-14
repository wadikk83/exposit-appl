package by.wadikk.core.service;

import by.wadikk.core.model.ProductAttribute;

import java.util.List;

public interface ProductAttributeService {

    boolean create(ProductAttribute productAttribute);

    List<ProductAttribute> readAll();

    ProductAttribute read(long id);

    boolean update(ProductAttribute productAttribute, long id);

    boolean delete(long id);
}
