package dclvs.enterprisedevedu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home").permitAll() // Разрешает доступ к "/" и "/home" для всех пользователей
                        .anyRequest().authenticated() // Требует аутентификации для любых других запросов
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Указывает страницу входа
                        .permitAll() // Разрешает доступ к форме входа для всех пользователей
                )
                .logout(LogoutConfigurer::permitAll); // Разрешает всем пользователям выходить из системы
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder() // Использует стандартное кодирование пароля (не рекомендуется для продакшена)
                        .username("user") // Задает имя пользователя
                        .password("password") // Задает пароль пользователя
                        .roles("USER") // Назначает пользователю роль
                        .build();
        return new InMemoryUserDetailsManager(user); // Создает и возвращает менеджер пользователей, хранящийся в памяти
    }
}
