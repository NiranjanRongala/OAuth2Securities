//package demo.example.demo.controller;
////
////public class JwtConfig {
////}
//import org.springframework.context.annotation.Bean;
//        import org.springframework.context.annotation.Configuration;
//        import org.springframework.security.oauth2.jwt.Jwt;
//        import org.springframework.security.oauth2.jwt.JwtDecoder;
//        import com.nimbusds.jose.JWSAlgorithm;
//        import com.nimbusds.jose.jwk.RSAKey;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//
//@Configuration
//public class JwtConfig {
//
//    //private RSAKey publicKey;
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        RSAKey rsaKey = new RSAKey.Builder(publicKey).build(); // Replace publicKey with your RSA public key
//        return new NimbusJwtDecoder(rsaKey);
//    }
//}
