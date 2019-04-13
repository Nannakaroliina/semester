package swd20.ht.semester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SemesterApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SemesterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SemesterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner semesterDemo() {
		return null;
	}

}
