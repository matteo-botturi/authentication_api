package fr.mb.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AuthApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AuthApplication.class, args);
		Environment env = context.getEnvironment();
        System.out.println("Database URL: " + env.getProperty("spring.datasource.url"));
	}
}