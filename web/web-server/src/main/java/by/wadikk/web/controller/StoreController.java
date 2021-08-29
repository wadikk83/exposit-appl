package by.wadikk.web.controller;

import by.wadikk.core.service.StoreService;
import by.wadikk.persistence.dto.StoreDto;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@Tag(name = "Магазины", description = "Взаимодействие с магазинами")
public class StoreController extends AbstractController<StoreDto, StoreService> {

    public StoreController(StoreService service) {
        super(service);
    }
}
