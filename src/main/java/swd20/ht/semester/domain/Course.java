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
	private String name;
	private String deadline;
	private int credits;
	
	@ManyToOne
	@JsonIgnore
	private University university;
	
	public Course( ) {
		super();
		this.name = null;
		this.deadline = null;
		this.credits = 0;
	}

	public Course(String name, String deadline, int credits, University university) {
		super();
		this.name = name;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
			return "Course [id=" + id + ", name=" + name + ", deadline=" + deadline + ", credits=" + credits
				+ ", university=" + university + "]";
		} else {
			return "Course [id=" + id + ", name=" + name + ", deadline=" + deadline + ", credits=" + credits + "]";
		}
	}
	
	
	
}
