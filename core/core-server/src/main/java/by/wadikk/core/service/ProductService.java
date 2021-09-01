package by.wadikk.core.service;

import by.wadikk.core.service.common.CommonService;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


public interface ProductService extends CommonService<ProductDto> {

    List<ProductDto> findAll(Specification<Product> productSpecification);


}
