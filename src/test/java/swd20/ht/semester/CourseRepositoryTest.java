package swd20.ht.semester;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.ht.semester.domain.Course;
import swd20.ht.semester.domain.CourseRepository;
import swd20.ht.semester.domain.UniversityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository crepository;
	
	@Autowired
	private UniversityRepository urepository;
	
	@Test
	public void findByNameShouldReturnCourse() {
		List<Course> courses = crepository.findByName("Server programming");
		
		assertThat(courses).hasSize(1);
		assertThat(courses.get(0).getName()).isEqualTo("Server programming");
	}
	
	@Test
	public void addNewCourse() {
		Course course = new Course("Japanese 2", "05/2019", 5, urepository.findByName("Metropolia").get(0));
		crepository.save(course);
		
		assertThat(course.getId()).isNotNull();
	}
	
	@Test
	public void deleteCourse() {
		Course course = crepository.findById(4).get(0);
		crepository.delete(course);
		
		assertThat(crepository.findById(4)).isNull();
	}
}
