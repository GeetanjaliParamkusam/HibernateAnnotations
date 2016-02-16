package com.hibernate.onetomanymapping;

import javax.persistence.*;

import java.util.List;

@Entity
public class College {

	private int collegeId;
	private String collegeName;
	private List<Student> students;
	
	@Id
	@GeneratedValue
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	@OneToMany(targetEntity=Student.class, mappedBy="college", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
