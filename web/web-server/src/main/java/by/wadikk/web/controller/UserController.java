package by.wadikk.web.controller;

import by.wadikk.core.model.User;
import by.wadikk.core.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Взаимодействие с пользователями")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "")
    @Operation(summary = "Создание нового пользователя",
            description = "Позволяет создать нового пользователя")
    public ResponseEntity<?> create(@RequestBody @Valid User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "")
    @Operation(summary = "Получение всех пользователей",
            description = "Позволяет получить список всех пользователей")
    public ResponseEntity<List<User>> read() {
        final List<User> clients = userService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Получение пользователя по ID",
            description = "Позволяет получить пользователя по его ID")
    public ResponseEntity<User> read(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор пользователя") long id) {
        final User user = userService.read(id);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Обновление пользователя по ID",
            description = "Позволяет обновить пользователя по его ID")
    public ResponseEntity<?> update(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор пользователя") long id,
            @RequestBody @Valid User user) {
        final boolean updated = userService.update(user, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Удаление пользователя")
    public ResponseEntity<?> delete(
            @PathVariable(name = "id") @Parameter(description = "Идентификатор пользователя") long id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //// TODO: 07.08.2021 Created for test, can be deleted after 
    @GetMapping(value = "/test")
    @Operation(summary = "Тестовый метод")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Test is ok", HttpStatus.OK);
    }
}
