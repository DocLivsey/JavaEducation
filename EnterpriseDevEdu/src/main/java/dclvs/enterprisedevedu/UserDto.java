package dclvs.enterprisedevedu;

import lombok.Data;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String fullName;
}
