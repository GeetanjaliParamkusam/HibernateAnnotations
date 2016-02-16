package com.hibernate.onetoonemappingbidir;

import javax.persistence.*;

@Entity
public class PersonDetail {
	
	@Id
	@GeneratedValue
	private int personDetailId;
	private String zipCode;
	private String job;
	private double income;
	
	private Person person;
	@OneToOne(mappedBy="pDetail", cascade=CascadeType.ALL)
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Column(name="detailId_PK")
	public int getPersonDetailId() {
		return personDetailId;
	}
	public void setPersonDetailId(int personDetailId) {
		this.personDetailId = personDetailId;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
}
