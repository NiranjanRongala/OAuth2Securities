package demo.example.demo.security;
//
//import com.example.facebook3.ServicesImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    JwtAuthConverter jwtAuthConverter;



@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
            .cors().and()
            .authorizeHttpRequests().anyRequest().authenticated()
           // .requestMatchers("/hi","/bye").authenticated()
//            .and()
//            .authorizeHttpRequests().requestMatchers("/swagger-ui/**","/**").authenticated()
//            .and()
//            .authorizeHttpRequests().requestMatchers("/users","/hi").authenticated()
            //.and().oauth2ResourceServer(t->t.opaqueToken(Customizer.withDefaults())).build(); // for opaqye token
//            .and().oauth2ResourceServer(t->t.jwt(Customizer.withDefaults())).build();// with defaults jwtAuthenticateConverter
//
            .and().oauth2ResourceServer(t->t.jwt(Configurer->Configurer.jwtAuthenticationConverter(jwtAuthConverter))).build();//with defined jwtAuthenticateConverter
//            .and().httpBasic()
//            .and().build();

}

//            .authorizeRequests()
//                .antMatchers("/swagger-ui.html", "/v3/api-docs", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**")
//                .permitAll()  // Allow access to Swagger UI and its associated resources
//            .anyRequest()

    @Bean
    public DefaultMethodSecurityExpressionHandler msecurity() {
        DefaultMethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler =
                new DefaultMethodSecurityExpressionHandler();
        defaultMethodSecurityExpressionHandler.setDefaultRolePrefix("");
        return defaultMethodSecurityExpressionHandler;
    }

//    @Bean
//    public JwtAuthenticationConverter con() {
//        JwtAuthenticationConverter c =new JwtAuthenticationConverter();
//        JwtGrantedAuthoritiesConverter cv = new JwtGrantedAuthoritiesConverter();
//        cv.setAuthorityPrefix(""); // Default "SCOPE_"
//        cv.setAuthoritiesClaimName("roles"); // Default "scope" or "scp"
//        c.setJwtGrantedAuthoritiesConverter(cv);
//        return c;
//    }
}
