package by.wadikk.web.controller;

import by.wadikk.core.service.CategoryService;
import by.wadikk.persistence.dto.CategoryDto;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@Tag(name = "Категории в магазине", description = "Взаимодействие с категориями продукта в магазине")
public class CategoryController extends AbstractController<CategoryDto, CategoryService> {

    public CategoryController(CategoryService service) {
        super(service);
    }
}