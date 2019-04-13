package swd20.ht.semester.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String universityName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Course> courselist;
	
	public University() {
		super();
		this.universityName = null;
	}

	public University(String universityName) {
		super();
		this.universityName = universityName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", universityName=" + universityName + "]";
	}

}
