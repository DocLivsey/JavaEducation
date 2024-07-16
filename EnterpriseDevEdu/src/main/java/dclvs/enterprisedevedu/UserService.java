package dclvs.enterprisedevedu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    @Scheduled(cron = "* * * * * ?")
    public void runTask() {
        var user = new User()
                .setId(UUID.randomUUID())
                .setFullName("Vova")
                .setBirthDate(LocalDate.now().minusDays(-1));

        log.info("User = {}", user);
        log.info("UserDto = {}", userMapper.toDto(user));
    }

    public void convertAndLog(UserDto userDto) {
        log.info("UserDto = {}", userMapper.toEntity(userDto));
    }
}
