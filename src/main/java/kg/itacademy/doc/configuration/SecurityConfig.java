package kg.itacademy.doc.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT t.login, t.password, t.is_active FROM user_doc t WHERE t.login = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.login, r.name_role " +
                                "FROM users_roles ur " +
                                "INNER JOIN users u " +
                                "   on ur.user_id = u.id " +
                                "INNER JOIN roles r " +
                                "   on ur.role_id = r.id " +
                                "WHERE u.login = ? AND u.is_active = 1"
                );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/api/document/*").permitAll() // можно hasRole("Admin") -- тогда
                // доступ к справочнику только у Admin, hasAnyRole("Admin", "User") -- если у нас несколько ролей
                .antMatchers(HttpMethod.POST, "/api/document/*").hasRole("Admin")
                .antMatchers(HttpMethod.PUT, "/api/document/*").hasRole("Admin")
                .antMatchers(HttpMethod.DELETE, "/api/document/*").hasRole("Admin")

                .antMatchers(HttpMethod.GET, "/api/executor/*").permitAll()
                .antMatchers(HttpMethod.POST, "/api/executor/*").hasRole("Admin")
                .antMatchers(HttpMethod.PUT, "/api/executor/*").hasRole("Admin")
                .antMatchers(HttpMethod.DELETE, "/api/executor/*").hasRole("Admin")

                .antMatchers( "/api/executor/*").hasRole("Admin") //это когда для GET, POST, PUT,
                // DELETE был доступ только у "Admin"

                .antMatchers("/api/user/*").permitAll()
                .antMatchers("/api/role/*").permitAll()

                .and()// означает соединение
                .httpBasic(); // означает тип авторизации
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
