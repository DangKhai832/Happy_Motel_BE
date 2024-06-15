//package com.HappyMotelBE.configuration;
//
//import lombok.experimental.NonFinal;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.crypto.spec.SecretKeySpec;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final String[] PUBLIC_ENDPOINT = { "/users", "/auth/login", "/auth/introspect", "/booking/create" };
//
//    @NonFinal
//    protected static final String signerKey = "MSTDhkccpIwXd9ijLOqDei6jOf9jtiOZoooelenJygN+ZNxRx4OBYmJqwLXESQh2";
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(request -> request
//                        .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINT).permitAll()
//                        .anyRequest().authenticated())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())))
//                .csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults());
//
//        return httpSecurity.build();
//    }
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
//        return NimbusJwtDecoder
//                .withSecretKey(secretKeySpec)
//                .macAlgorithm(MacAlgorithm.HS512)
//                .build();
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry
//                        .addMapping("/**")
//                        .allowedMethods(CorsConfiguration.ALL)
//                        .allowedHeaders(CorsConfiguration.ALL)
//                        .allowedOriginPatterns(CorsConfiguration.ALL);
//            }
//        };
//    }
//}
