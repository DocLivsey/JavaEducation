package dclvs.enterprisedevedu;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Mapper
public interface UserMapper {

    @Mapping(target = "birthDate", ignore = true)
    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    default Long mapToCountDaysFromNow(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.until(LocalDate.now(), ChronoUnit.DAYS);
    }

}
