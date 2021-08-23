package by.wadikk.web.controller;

import by.wadikk.core.service.ProductService;
import by.wadikk.persistence.entities.Product;
import by.wadikk.web.controller.common.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController{ /*extends AbstractController<Product, ProductService> {

    protected ProductController(ProductService service) {
        super(service);
    }*/
}
