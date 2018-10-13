package com.scp.SpringHibernateCRUD;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UniversityTestMain {

		public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			UniversityDAO universityDAO = (UniversityDAO) context.getBean("UniversityDAO");

			College college1 = new College("Sinhgad");
			University university1 = new University( "SBPU UNIVERSITY", "PUNE", college1);

			College college2 = new College("COED");
			University university2 = new University("ICE", "Delhi", college2);

			College college3 = new College("mit");
			University university3 = new University( "MIT", "Hydrabad", college3);

			College college4 = new College("IGC");
			University university4 = new University("Oxford", "California", college4);


		universityDAO.addUniversity(university1);
		universityDAO.addUniversity(university2);
		universityDAO.addUniversity(university3);
		universityDAO.addUniversity(university4);
		// System.out.println("University::"+university);
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		System.out.println("****************************************************");
		List<University> list = universityDAO.list();
		for (University universityList : list) {
			System.out.println("University List::" + universityList);
		}
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");
		// update Record
		College college5 = new College("Sinhgad");
		University university5 = universityDAO.getUniversityById(3);
		university5.setCollege(college5);
		universityDAO.updateUniversity(university5);
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");

		// search Record
		universityDAO.getUniversityById(2);
		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------");

		// Delete Record
		universityDAO.removeUniversity(4);

		/*List<University> updatedList = universityDAO.list();
		for (University newList : updatedList) {
			System.out.println("University List::" + newList + "College List" + newList.getCollege());
		}*/
	}

}
