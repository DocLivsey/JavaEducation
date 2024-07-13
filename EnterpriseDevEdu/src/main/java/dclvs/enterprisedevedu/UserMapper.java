package dclvs.enterprisedevedu;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);

}
