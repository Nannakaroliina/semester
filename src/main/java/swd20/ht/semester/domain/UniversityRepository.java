package swd20.ht.semester.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Long> {

	List<University> findByName(String name);
	
}
