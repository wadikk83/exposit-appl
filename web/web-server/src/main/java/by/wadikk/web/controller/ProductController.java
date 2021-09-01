package by.wadikk.web.controller;

import by.wadikk.core.rsql.ProductSpecificationsBuilder;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.util.SearchOperation;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.entities.Product;
import by.wadikk.persistence.entities.User;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@Tag(name = "Продукты", description = "Взаимодействие с продуктами")
public class ProductController extends AbstractController<ProductDto, ProductService> {

    protected ProductController(ProductService service) {
        super(service);
    }

    @GetMapping(value = "/filter")
    @Operation(summary = "Получение всех сущностей по фильтру",
            description = "Позволяет получить список всех сущностей используя фильтр")
    public ResponseEntity<List<ProductDto>> search(@RequestParam Map<String, String> allParams) {
        Specification<Product> spec = resolveSpecification(allParams);
        List<ProductDto> resultList = service.findAll(spec);
        return resultList != null && !resultList.isEmpty()
                ? new ResponseEntity<>(resultList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //http://localhost:8080/users/filter?fullName=user1full&email=user1@qqq.by
    protected Specification<Product> resolveSpecification(Map<String, String> searchParameters) {
        ProductSpecificationsBuilder builder = new ProductSpecificationsBuilder();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            builder.with(entry.getKey(), SearchOperation.EQUALITY, entry.getValue());
        }
        return builder.build();
    }
}
