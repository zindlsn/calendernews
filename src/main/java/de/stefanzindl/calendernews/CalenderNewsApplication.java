package de.stefanzindl.calendernews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point of this REST-Application
 */
@SpringBootApplication
@ComponentScan(basePackages = "de.stefanzindl.calendernews")
@EnableJpaRepositories(basePackages = {"de.stefanzindl.calendernews.repository"})
@EntityScan(basePackages = "de.stefanzindl.calendernews.model")
public class CalenderNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalenderNewsApplication.class, args);
	}

}
