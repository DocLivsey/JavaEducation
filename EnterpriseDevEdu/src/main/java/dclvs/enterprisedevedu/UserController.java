package dclvs.enterprisedevedu;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Controller for work with users", description = "API для управления пользователями")
public class UserController {

    private final UserService userService;

    @PostMapping("/user/log")
    @Operation(summary = "Логгирование пользователя", description = "Перед логгированием выполняет конвертацию в сущность User")
    @ApiResponse(responseCode = "200", description = "Логгирование прошло успешно")
    @ApiResponse(responseCode = "422", description = "Возраст пользователя слишком мал")
    public ResponseEntity<Void> convertAndLogUser(@RequestBody UserDto user) {
        userService.convertAndLog(user);
        return ResponseEntity.ok().build();
    }

}
