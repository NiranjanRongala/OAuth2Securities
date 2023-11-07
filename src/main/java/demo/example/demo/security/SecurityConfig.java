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
//    @Autowired
//    JwtAuthConverter jwtAuthConverter;


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(csrf->csrf.disable())
//                .cors().and()
//                .authorizeHttpRequests(auth->auth.requestMatchers("/**").permitAll())
//                .authorizeHttpRequests(auth->auth.requestMatchers("/users","/user","/posts","/user-id/100/password/user_1").authenticated())
//                //.authorizeHttpRequests(auth->auth.requestMatchers("/**").permitAll())
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().httpBasic().and().build();
//    }
@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
            .cors().and()
//            .authorizeHttpRequests().anyRequest().authenticated()
           // .requestMatchers("/hi","/bye").authenticated()
//            .and()
            .authorizeHttpRequests().requestMatchers("/","/**").permitAll()
            .and()
            .authorizeHttpRequests().requestMatchers("/users","/hi").authenticated()
            //.and().oauth2ResourceServer(t->t.opaqueToken(Customizer.withDefaults())).build();
            .and().oauth2ResourceServer(t->t.jwt(Customizer.withDefaults())).build();
//
            //.and().oauth2ResourceServer(t->t.jwt(Configurer->Configurer.jwtAuthenticationConverter(jwtAuthConverter))).build();
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
// using with default jwtauthconvert we add roles in scope at keycloak
    @Bean
    public JwtAuthenticationConverter con() {
        JwtAuthenticationConverter c =new JwtAuthenticationConverter();
        JwtGrantedAuthoritiesConverter cv = new JwtGrantedAuthoritiesConverter();
        cv.setAuthorityPrefix(""); // Default "SCOPE_"
        cv.setAuthoritiesClaimName("roles"); // Default "scope" or "scp"
        c.setJwtGrantedAuthoritiesConverter(cv);
        return c;
    }
}
