package com.rtt.tools;

import com.rtt.user.Role;
import com.rtt.user.User;
import com.rtt.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SuperAdminBootstrap {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Environment environment;

    /**
     * Enabled only in non-prod profiles via application-dev.properties / application-sit.properties
     */
    @Value("${security.super-admin.bootstrap-enabled:false}")
    private boolean bootstrapEnabled;
    @Value("${security.super-admin.username}")
    private String superAdminUsername;

    @PostConstruct
    public void initSuperAdmin() {

        String activeProfiles = String.join(",", environment.getActiveProfiles());
        log.info("SuperAdmin bootstrap check started | env={}", activeProfiles);

        // PROD
        if (environment.acceptsProfiles(Profiles.of("prod"))) {

            String password = System.getenv("SUPER_ADMIN_PASSWORD");

            if (password == null || password.isBlank()) {
                log.warn("SUPER_ADMIN_PASSWORD env variable not found");
                return;
            }

            Optional<User> existingUser =
                    userRepository.findByEmail(superAdminUsername);

            if (existingUser.isPresent()) {

                User user = existingUser.get();

                user.setPassword(passwordEncoder.encode(password));

                userRepository.save(user);

                log.info("SUPER_ADMIN password reset successfully | env={}", activeProfiles);

            } else {

                User admin = new User();
                admin.setEmail(superAdminUsername);
                admin.setPassword(passwordEncoder.encode(password));
                admin.setRole(Role.SUPERADMIN);

                userRepository.save(admin);

                log.info("SUPER_ADMIN created successfully in PROD | env={}", activeProfiles);
            }

            return;
        }

       // LOCAL / DEV / SIT logic starts here

        if (userRepository.existsByRole(Role.SUPERADMIN)) {
            log.info("SuperAdmin already exists | env={}", activeProfiles);
            return;
        }

        User admin = new User();
        admin.setEmail("rk.study");
        admin.setPassword(passwordEncoder.encode("rk.study@2026"));
        admin.setRole(Role.SUPERADMIN);

        userRepository.save(admin);

        log.info("SuperAdmin created successfully | env={}", activeProfiles);
    }
    }
