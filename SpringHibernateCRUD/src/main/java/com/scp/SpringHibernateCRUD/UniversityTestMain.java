package com.scp.SpringHibernateCRUD;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;


class UniversityTestMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		UniversityDAO universityDAO = context.getBean(UniversityDAO.class);
		College college1 = new College(1, "Sinhgad");
		University university1 = new University(10, "SBPU UNIVERSITY", "PUNE", college1);

		College college2 = new College(2, "COED");
		University university2 = new University(20, "ICE", "Delhi", college2);

		College college3 = new College(3, "mit");
		University university3 = new University(30, "MIT", "Hydrabad", college3);

		College college4 = new College(4, "IGC");
		University university4 = new University(40, "Oxford", "California", college4);

		universityDAO.addUniversity(university1);
		universityDAO.addUniversity(university2);
		universityDAO.addUniversity(university3);
		universityDAO.addUniversity(university4);
		// System.out.println("University::"+university);
		
		List<University> list = universityDAO.list();
		for (University universityList : list) {
			System.out.println("University List::" + universityList );
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		// update Record
		College college5 = new College(5, "Sinhgad");
		university3 = new University(40, "Uni_of_cheenai", "Chennai", college5);
		universityDAO.updateUniversity(university3);
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");

		// search Record
		universityDAO.getUniversityById(20);
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");

		// Delete Record
		universityDAO.removeUniversity(30);
		context.close();

		List<University> updatedList = universityDAO.list();
		for (University newList : updatedList) {
			System.out.println("University List::" + newList + "College List" + newList.getCollege());
		}
	}

}
