package dclvs.enterprisedevedu;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public ResponseEntity<User> convertAndLogUser(@RequestBody UserDto user) {
        userService.convertAndLog(user);
        return ResponseEntity.ok().build();
    }

}
