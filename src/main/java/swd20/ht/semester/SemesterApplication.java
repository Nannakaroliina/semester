package swd20.ht.semester;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.ht.semester.domain.Course;
import swd20.ht.semester.domain.CourseRepository;
import swd20.ht.semester.domain.University;
import swd20.ht.semester.domain.UniversityRepository;
import swd20.ht.semester.domain.User;
import swd20.ht.semester.domain.UserRepository;

@SpringBootApplication
public class SemesterApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SemesterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SemesterApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner semesterDemo(CourseRepository crepository, UniversityRepository urepository, UserRepository userrepository) {
		return (args) -> {
			log.info("Save couple of universities");
			urepository.save(new University("Haaga-Helia"));
			urepository.save(new University("Metropolia"));
			urepository.save(new University("Jyväskylä UAS"));
			
			log.info("Save couple of courses");
			crepository.save(new Course("Server programming", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Business Mathematics", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Requirement Specification and Requirement-Based Testing", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Communications in Multicultural Enviroments", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Study and working skills 2", "05/2019", 2, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Software project 1", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Front End Development", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("ITC and Business English", "05/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Basic of Supply Chain Management", "08/2019", 5, urepository.findByName("Haaga-Helia").get(0)));
			crepository.save(new Course("Python Programming", "12/2019", 3, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("Microprosessors", "12/2019", 5, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("C++ Programming", "12/2019", 3, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("Game programming with Unity", "12/2019", 5, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("CISSP: Certified Information System Security Professional", "12/2019", 8, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("Security Solutions", "12/2019", 6, urepository.findByName("Metropolia").get(0)));
			crepository.save(new Course("iOS Application Development", "06/2019", 5, urepository.findByName("Jyväskylä UAS").get(0)));
			
			// Creating user and admin
			User user1 = new User("user", "$2a$04$4huA86.ZAl/8Us37tOfDDekrFFIZfkb6ZPRixFYgy702HE9hNHQCC", "user1@semester.com", "USER");
			User user2 = new User("admin", "$2a$06$2lArAqPgSxgIiVIxs4E5su0GWBnHcBxiXaZufO7vLLGroqpzklXeG", "admin@semester.com", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
						
			log.info("Find all courses");
			for (Course course : crepository.findAll()) {
				log.info(course.toString());
			}
		};
	}

}
