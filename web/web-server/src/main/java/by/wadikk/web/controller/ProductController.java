package by.wadikk.web.controller;

import by.wadikk.core.model.Product;
import by.wadikk.core.model.User;
import by.wadikk.core.service.ProductService;
import by.wadikk.core.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "")
    @Operation(summary = "Создание нового продукта",
            description = "Позволяет создать новый продукт")
    public ResponseEntity<?> create(@RequestBody @Valid Product product) {
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    @Operation(summary = "Получение всех продуктов",
            description = "Позволяет получить список всех продуктов")
    public ResponseEntity<List<Product>> read() {
        final List<Product> products = productService.readAll();

        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получение продукта по ID",
            description = "Позволяет получить продукт по его ID")
    public ResponseEntity<Product> read(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор продукта") long id) {
        final Product product = productService.read(id);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Обновление продукта по ID",
            description = "Позволяет обновить продукт по его ID")
    public ResponseEntity<?> update(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор продукта") long id,
            @RequestBody @Valid Product product) {
        final boolean updated = productService.update(product, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление продукта")
    public ResponseEntity<?> delete(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор продукта") long id) {
        final boolean deleted = productService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/attribute/{attributeId}/")
    @Operation(summary = "Получение списков продуктов по ID атрибута",
            description = "Позволяет получить список продуктов по ID атрибута")
    public ResponseEntity<List<Product>> readByAttribute(
            @PathVariable(name = "attributeId") @Parameter(description = "Идентификатор продукта") long attributeId) {
        final List<Product> products = productService.findByAttributes(attributeId);

        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/category/{categoryId}/")
    @Operation(summary = "Получение продукта по ID его категории",
            description = "Позволяет получить продукт по его ID категории")
    public ResponseEntity<List<Product>> readByCategory(
            @PathVariable(name = "categoryId") @Parameter(description = "Идентификатор продукта") long categoryId) {
        final List<Product> products = productService.findByCategory(categoryId);

        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/store/{storeId}/")
    @Operation(summary = "Получение списков продуктов по ID магазина",
            description = "Позволяет получить список продуктов по ID магазина")
    public ResponseEntity<List<Product>> readByStore(
            @PathVariable(name = "storeId") @Parameter(description = "Идентификатор продукта") long storeId) {
        final List<Product> products = productService.getAllByStoreId(storeId);

        return products != null && !products.isEmpty()
                ? new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
