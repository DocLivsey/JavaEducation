package dclvs.enterprisedevedu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
@Schema(name = "Container for user data", description = "Данные пользователя")
public class UserDto {

    @Schema(name = "ID", description = "Идентификатор")
    private UUID id;

    @Schema(description = "ФИО пользователя", example = "Ivanov Ivan Jovanovich")
    private String fullName;

    @Schema(description = "Кол-во дней, прошедших со дня рождения", minimum = "0")
    private Long birthDate;

}
