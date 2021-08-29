package by.wadikk.web.controller;

import by.wadikk.core.service.UserService;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public class UserController extends AbstractController<UserDto, UserService> {
    protected UserController(UserService service) {
        super(service);
    }
}
