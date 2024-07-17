package dclvs.enterprisedevedu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.UUID;


/*
    Юнит-тесты тестируют функциональность конкретных методов ограниченно от всего остального приложения.
    Для их выполнения не требуется развертывание какой-либо дополнительной инфраструктуры.
 */
public class UserMapperUnitTest {

    private final UserMapper userMapper = new UserMapperImpl();

    @Test
    void testToDtoMappingReturnCorrectBirthDayInDto() {
        // Given
        var expectedEntity = buildTestUser();

        // When
        var actualDto = userMapper.toDto(expectedEntity);

        // Then
        Assertions.assertEquals(366, actualDto.getBirthDate());
    }

    private User buildTestUser() {
        return new User()
                .setId(UUID.fromString("7c27a110-d271-4527-9085-911c982479df"))
                .setFullName("Vova")
                .setBirthDate(LocalDate.now().minusDays(366));
    }

}
