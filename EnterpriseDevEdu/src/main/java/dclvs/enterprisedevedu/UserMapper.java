package dclvs.enterprisedevedu;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Mapper(imports = {
        LocalDate.class
})
public interface UserMapper {

    @Mapping(target = "birthDate", expression = "java(LocalDate.now())")
    User toEntity(UserDto dto);

    UserDto toDto(User entity);

    default Long mapToCountDaysFromNow(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.until(LocalDate.now(), ChronoUnit.DAYS);
    }

    @Mapping(target = "birthData", source = "birthDate")
    UserWithBirthDataDto toWithBirthDataDto(User entity);

}
