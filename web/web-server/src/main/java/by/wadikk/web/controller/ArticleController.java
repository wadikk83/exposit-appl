package by.wadikk.web.controller;


import by.wadikk.core.service.ArticleService;
import by.wadikk.persistence.dto.ArticleDto;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
@Tag(name = "Продукты в магазине", description = "Взаимодействие с продуктами в магазине")
public class ArticleController extends AbstractController<ArticleDto, ArticleService> {

    protected ArticleController(ArticleService service) {
        super(service);
    }
}
