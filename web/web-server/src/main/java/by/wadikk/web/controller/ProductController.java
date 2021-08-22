package by.wadikk.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    /*@GetMapping(value = "/attribute/{attributeId}/")
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
    */
}
