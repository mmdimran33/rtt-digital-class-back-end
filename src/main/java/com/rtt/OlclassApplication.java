package com.rtt;

import com.rtt.auth.AuthenticationService;
import com.rtt.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.rtt.user.Role.*;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class OlclassApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlclassApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Imran")
					.lastname("Chaudhary")
					.email("imran1@mail.com")
					.password("imranadmin1@123")
					.role(ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var manager = RegisterRequest.builder()
					.firstname("Adnan")
					.lastname("Chaudhary")
					.email("adnan1@mail.com")
					.password("adnan1@1234")
					.role(TEACHER)
					.build();
			System.out.println("Manager token: " + service.register(manager).getAccessToken());

		};
	}*/
}
