package by.wadikk.web.controller;

import by.wadikk.core.service.ProductService;
import by.wadikk.persistence.dto.ProductDTO;
import by.wadikk.persistence.entities.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Продукты", description = "Взаимодействие с продуктами")
public class ProductController {

    private final ProductService service;

    private final ModelMapper modelMapper;

    @Autowired
    public ProductController(ProductService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    @PostMapping(value = "")
    @Operation(summary = "Создание новой сущности",
            description = "Позволяет создать новую сущность")
    public ResponseEntity<?> create(@RequestBody @Valid Product entity) {
        service.save(entity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    @Operation(summary = "Получение всех сущностей",
            description = "Позволяет получить список всех сущностей")
    public ResponseEntity<List<ProductDTO>> getAll() {
        final List<Product> entities = service.getAll();
        final List<ProductDTO> entitiesDTO = new ArrayList<>();
        entities.stream().forEach(e -> entitiesDTO.add(convertToDto(e)));

        return entitiesDTO != null && !entitiesDTO.isEmpty()
                ? new ResponseEntity<>(entitiesDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получение сущности по ID",
            description = "Позволяет получить сущность по ее ID")
    public ResponseEntity<ProductDTO> getById(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id) {
        final Product entity = service.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found, id=" + id));

        return convertToDto(entity) != null
                ? new ResponseEntity<>(convertToDto(entity), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Обновление сущности по ID",
            description = "Позволяет обновить сущность по ее ID")
    public ProductDTO update(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id,
            @RequestBody @Parameter(description = "Сущность для обновления") @Valid Product entity) {
        final Product updated = service.update(entity, id)
                .orElseThrow(() -> new EntityNotFoundException("Entity is not found, id=" + id));

        return convertToDto(updated);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление сущности")
    public ResponseEntity<?> delete(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id) {
        final boolean deleted = service.deleteById(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/all")
    @Operation(summary = "Удаление всех сущностей")
    public ResponseEntity<?> deleteAll() {
        final boolean deletedAll = service.deleteAll();

        return deletedAll
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
