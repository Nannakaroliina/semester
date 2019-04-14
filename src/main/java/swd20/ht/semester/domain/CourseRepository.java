package swd20.ht.semester.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findByName(String name);

	List<Course> findById(long id);
}
