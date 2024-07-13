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
    public void scheduledTask() {
        User user = new User()
                .setId(UUID.randomUUID())
                .setFullName("Anton")
                .setBirthDate(LocalDate.now().minusYears(12));
        log.info("User = {}", user);
        log.info("UserDto = {}", userMapper.toDto(user));
    }
}
