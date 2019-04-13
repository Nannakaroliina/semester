package swd20.ht.semester.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String courseName;
	private String deadline;
	private int credits;
	
	@ManyToOne
	@JsonIgnore
	private University university;
	
	public Course( ) {
		super();
		this.courseName = null;
		this.deadline = null;
		this.credits = 0;
	}

	public Course(String courseName, String deadline, int credits, University university) {
		super();
		this.courseName = courseName;
		this.deadline = deadline;
		this.credits = credits;
		this.university = university;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDeadline() {
		return deadline;
	}


	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}


	public int getCredits() {
		return credits;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public University getUniversity() {
		return university;
	}


	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		if  (this.university != null) {
			return "Course [id=" + id + ", courseName=" + courseName + ", deadline=" + deadline + ", credits=" + credits
				+ ", university=" + university + "]";
		} else {
			return "Course [id=" + id + ", courseName=" + courseName + ", deadline=" + deadline + ", credits=" + credits + "]";
		}
	}
	
	
	
}
