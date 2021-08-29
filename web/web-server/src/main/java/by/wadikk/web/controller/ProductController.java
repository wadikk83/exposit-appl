package by.wadikk.web.controller;

import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dto.ProductDto;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "Продукты", description = "Взаимодействие с продуктами")
public class ProductController extends AbstractController<ProductDto, ProductService> {

    protected ProductController(ProductService service) {
        super(service);
    }
}
