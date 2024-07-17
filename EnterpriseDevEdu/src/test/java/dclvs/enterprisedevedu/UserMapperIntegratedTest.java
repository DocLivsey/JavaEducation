package dclvs.enterprisedevedu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
public class UserMapperIntegratedTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testToDtoMappingReturnCorrectBirthDayInDto() {
        // Given
        var expectedEntity = buildTestUser();

        // When
        var actualDto = userMapper.toDto(expectedEntity);

        // Then
        Assertions.assertEquals(0, actualDto.getBirthDate());
    }

    private User buildTestUser() {
        return new User()
                .setId(UUID.fromString("7c27a110-d271-4527-9085-911c982479df"))
                .setFullName("Vova")
                .setBirthDate(LocalDate.now());
    }

}
