package swd20.ht.semester.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.ht.semester.domain.Course;
import swd20.ht.semester.domain.CourseRepository;
import swd20.ht.semester.domain.UniversityRepository;

@Controller
public class SemesterController {

	@Autowired
	private CourseRepository crepository;
	
	@Autowired
	private UniversityRepository urepository;
	
	// Login to show all courses
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// Show all courses in course list
	@RequestMapping(value="/courselist")
	public String courseList(Model model) {
		model.addAttribute("courses", crepository.findAll());
		return "index";
	}
	
	// REST service to get all courses from the list
	@RequestMapping(value="/courses", method = RequestMethod.GET)
	public @ResponseBody List<Course> courseListRest() {
		return (List<Course>) crepository.findAll();
	}
	
	// REST service to find course by ID
	@RequestMapping(value="/course/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Course> findCourseRest(@PathVariable("id") Long courseId) {
		return crepository.findById(courseId);
	}
	
	// REST service to create new course
	@RequestMapping(value="/courses", method = RequestMethod.POST)
	public @ResponseBody Course saveCourseRest(@RequestBody Course course) {
		return crepository.save(course);
	}
	
	// Add new course
	@RequestMapping(value="/add")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("universities", urepository.findAll());
		return "addcourse";
	}
	
	// Save our new course to list of courses
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Course course) {
		crepository.save(course);
		return "redirect:courselist";
	}
	
	// Delete course by ID
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteCourse(@PathVariable("id") Long courseId, Model model) {
		crepository.deleteById(courseId);
		return "redirect:../courselist";
	}
	
	// Edit course by ID
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/edit/{id}")
	public String editCourse(@PathVariable("id") Long courseId, Model model) {
		model.addAttribute("course", crepository.findById(courseId));
		model.addAttribute("universities", urepository.findAll());
		return "edit";
	}
}
