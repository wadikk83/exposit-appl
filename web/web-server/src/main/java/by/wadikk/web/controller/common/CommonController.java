package by.wadikk.web.controller.common;

import by.wadikk.core.annotation.ProfileExecution;
import by.wadikk.persistence.entities.BaseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;


public interface CommonController<E extends BaseEntity> {

    @PostMapping(value = "")
    @Operation(summary = "Создание новой сущности",
            description = "Позволяет создать новую сущность")
    public ResponseEntity<?> create(@RequestBody @Valid E entity);

    @GetMapping(value = "")

    @Operation(summary = "Получение всех сущностей",
            description = "Позволяет получить список всех сущностей")
    public ResponseEntity<List<E>> getAll();

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получение сущности по ID",
            description = "Позволяет получить сущность по ее ID")
    public ResponseEntity<E> getById(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id);

    @PutMapping(value = "/{id}")
    @Operation(summary = "Обновление сущности по ID",
            description = "Позволяет обновить сущность по ее ID")
    public E update(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id,
            @RequestBody @Parameter(description = "Сущность для обновления") @Valid E entity);

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление сущности")
    public ResponseEntity<?> delete(
            @PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE)
            @Parameter(description = "Идентификатор сущности") long id);

    @DeleteMapping(value = "/all")
    @Operation(summary = "Удаление всех сущностей")
    public ResponseEntity<?> deleteAll();

}
