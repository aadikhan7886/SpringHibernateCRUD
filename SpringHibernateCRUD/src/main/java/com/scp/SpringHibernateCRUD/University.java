package com.scp.SpringHibernateCRUD;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

@Entity
class University {
	@Id
	private int universityId;
	private String universityName;
	private String city;

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public University(int universityId, String universityName, String city) {
		super();
		this.universityId = universityId;
		this.universityName = universityName;
		this.city = city;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + ", city=" + city
				+ "]";
	}

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

}
