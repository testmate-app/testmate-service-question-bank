package id.or.mate.test.service_question_bank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Inject the issuer URI, typically set in application properties
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuerUri;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/questions/**").permitAll()
                        .requestMatchers("/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                );
//                .oauth2ResourceServer(oauth2 -> oauth2
//                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
//                );

        return http.build();
    }

//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
//        authenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
//            Collection<String> roles = extractRolesFromResourceAccess(jwt);
//            return roles.stream()
//                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                    .collect(Collectors.toSet());
//        });
//        return authenticationConverter;
//    }
//
//    private Collection<String> extractRolesFromResourceAccess(Jwt jwt) {
//        Object resourceAccess = jwt.getClaim("resource_access");
//
//        // Check if resource_access is a Map
//        if (resourceAccess instanceof Map<?, ?> resourceAccessMap) {
//            Object clientRoles = resourceAccessMap.get("usu1");
//
//            // Check if clientRoles is a Map with a "roles" key containing a collection
//            if (clientRoles instanceof Map<?, ?> clientRolesMap) {
//                Object roles = clientRolesMap.get("roles");
//
//                if (roles instanceof Collection) {
//                    return ((Collection<?>) roles).stream()
//                            .filter(role -> role instanceof String)
//                            .map(role -> (String) role)
//                            .collect(Collectors.toSet());
//                }
//            }
//        }
//
//        // Return an empty collection if roles are not found or not properly structured
//        return Collections.emptySet();
//    }
//
//    // JwtDecoder bean for JWT validation
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withIssuerLocation(issuerUri).build();
//    }
}
