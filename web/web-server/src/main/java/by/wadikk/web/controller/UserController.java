package by.wadikk.web.controller;

import by.wadikk.core.rsql.UserSpecificationsBuilder;
import by.wadikk.core.service.UserService;
import by.wadikk.core.util.SearchOperation;
import by.wadikk.persistence.dto.UserDto;
import by.wadikk.persistence.entities.User;
import by.wadikk.web.controller.common.AbstractController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public class UserController extends AbstractController<UserDto, UserService> {
    protected UserController(UserService service) {
        super(service);
    }

    @GetMapping(value = "/filter")
    @Operation(summary = "Получение всех сущностей по фильтру",
            description = "Позволяет получить список всех сущностей используя фильтр")
    public ResponseEntity<List<UserDto>> search(@RequestParam Map<String, String> allParams) {
        Specification<User> spec = resolveSpecification(allParams);
        List<UserDto> resultList = service.findAll(spec);
        return resultList != null && !resultList.isEmpty()
                ? new ResponseEntity<>(resultList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //http://localhost:8080/users/filter?fullName=user1full&email=user1@qqq.by
    protected Specification<User> resolveSpecification(Map<String, String> searchParameters) {
        UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
        for (Map.Entry<String, String> entry : searchParameters.entrySet()) {
            builder.with(entry.getKey(), SearchOperation.EQUALITY, entry.getValue());
        }
        return builder.build();
    }
}
