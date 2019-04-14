package swd20.ht.semester;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.ht.semester.domain.User;
import swd20.ht.semester.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepository.findByUsername("user");
		
		assertThat(user.getUsername()).isEqualTo("user");
	}
	
	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$08$kdWk6JiCSGDQ0KnwNAS/NufheMD9YmjkyD0Z0bTR21MUsDIT9MMm.", "user2@bookstore.com", "USER");
		urepository.save(user);
		
		assertThat(user.getId()).isNotNull();
	}

}
