package com.scp.SpringHibernateCRUD;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
class University {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int universityId;
	private String universityName;
	private String city;

	@OneToOne(cascade = CascadeType.ALL)
	private College college;

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
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

	public University(String universityName, String city,College college) {
		super();
		this.universityName = universityName;
		this.city = city;
		this.college = college;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", universityName=" + universityName + ", city=" + city
				+ ", college=" + college +"]";
	}

	public University() {
		super();
	}

}

@Entity
class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	private String collegeName;

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public College(String collegeName) {
		super();
		this.collegeName = collegeName;
	}

	public College() {
		super();
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + "]";
	}

}