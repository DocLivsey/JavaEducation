package dclvs.enterprisedevedu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Accessors(chain = true)
@Schema(description = "Данные пользователя с полной датой рождения")
public class UserWithBirthDataDto {

    @Schema(description = "Идентификатор")
    private UUID id;

    @Schema(description = "ФИО пользователя", example = "Ivanov Ivan Ivanovich")
    private String fullName;

    @Schema(description = "Дата рождения")
    private LocalDate birthData;

}
