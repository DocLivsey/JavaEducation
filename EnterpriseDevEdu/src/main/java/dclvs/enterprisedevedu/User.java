package dclvs.enterprisedevedu;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@Accessors(chain = true)
public class User {
    private UUID id;
    private String fullName;
}
