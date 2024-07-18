package dclvs.enterprisedevedu;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UserControllerTest extends MvcIntegrationTest {

    @SpyBean
    private UserMapper userMapper;

    @Test
    void testConvertUserToUserWithBirthDataReturnCorrectResponse() throws Exception {
        // Given
        Mockito.when(userMapper.toEntity(Mockito.any())).thenReturn(buildTestUser());

        // When
        var actions = mockMvc.perform(MockMvcRequestBuilders.post("/user/convert/with-birth-data")
                .content(objectMapper.writeValueAsBytes(buildTestUserDto()))
                .contentType(MediaType.APPLICATION_JSON));

        // Then
        actions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id")
                        .value("7c27a110-d271-4527-9085-911c982479df"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthData")
                        .value(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)));
    }

    private User buildTestUser() {
        return new User()
                .setId(UUID.fromString("7c27a110-d271-4527-9085-911c982479df"))
                .setFullName("Vova")
                .setBirthDate(LocalDate.now());
    }

    private UserDto buildTestUserDto() {
        return new UserDto()
                .setId(UUID.fromString("7c27a110-d271-4527-9085-911c982479df"))
                .setFullName("Vova")
                .setBirthDate(5L);
    }

}
