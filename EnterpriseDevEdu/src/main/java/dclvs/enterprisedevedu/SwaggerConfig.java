package dclvs.enterprisedevedu;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(name = "basic", scheme = "basic", type = SecuritySchemeType.HTTP)
public class SwaggerConfig {

    @Bean
    public OpenAPI swaggerDescription() {
        return new OpenAPI()
                .info(new Info()
                        .title("Тестовое приложение")
                        .description("Учимся документировать")
                        .version("0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Этот же сваггер")
                        .url("http://localhost:8080/swagger-ui/index.html"));
    }

}
