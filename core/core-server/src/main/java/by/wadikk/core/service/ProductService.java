package by.wadikk.core.service;

import by.wadikk.core.service.common.CommonService;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.entities.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService extends CommonService<ProductDto> {

}
