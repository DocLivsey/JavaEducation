package dclvs.enterprisedevedu;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private static final long MIN_AGE_IN_DAYS = 0;

    private final UserMapper userMapper;

    /*@Scheduled(cron = "* * * * * ?")
    public void runTask() {
        var user = new User()
                .setId(UUID.randomUUID())
                .setFullName("Vova")
                .setBirthDate(LocalDate.now().minusDays(-1));

        log.info("User = {}", user);
        log.info("UserDto = {}", userMapper.toDto(user));
    }*/

    public void convertAndLog(UserDto userDto) {
        if (userDto.getBirthDate() == null) {
            throw new UnprocessableEntityException("birthDate is null");
        }
        if (userDto.getBirthDate() < MIN_AGE_IN_DAYS) {
            throw new UnprocessableEntityException("Age must be 5 or greater");
        }

        log.info("UserDto = {}", userMapper.toEntity(userDto));
    }
}
