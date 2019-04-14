package swd20.ht.semester;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.ht.semester.domain.University;
import swd20.ht.semester.domain.UniversityRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UniversityRepositoryTest {

	@Autowired
	private UniversityRepository urepository;
	
	@Test
	public void findByNameShouldReturnUniversity() {
		List<University> universities = urepository.findByName("Haaga-Helia");
		
		assertThat(universities).hasSize(1);
		assertThat(universities.get(0).getName()).isEqualTo("Haaga-Helia");
	}
	
	@Test
	public void addNewUniversity() {
		University university = new University("Oulu UAS");
		urepository.save(university);
		
		assertThat(university.getId()).isNotNull();
	}
}
