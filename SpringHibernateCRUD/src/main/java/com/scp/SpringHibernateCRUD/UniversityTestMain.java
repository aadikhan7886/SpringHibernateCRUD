package com.scp.SpringHibernateCRUD;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.media.jfxmedia.logging.Logger;

public class UniversityTestMain {

	public static void main(String[] args) {
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		UniversityDAO universityDAO = context.getBean(UniversityDAO.class);
		
		University university = new University();
		university.setUniversityId(10);
		university.setUniversityName("SBPU UNIVERSITY");
		university.setCity("PUNE");
		
		University university2 = new University(20, "ICE", "Delhi");
		University university3 = new University(30, "MIT", "Hydrabad");
		University university4 = new University(40, "Oxford", "California");
		
		universityDAO.addUniversity(university);
		universityDAO.addUniversity(university2);
		universityDAO.addUniversity(university3);
		universityDAO.addUniversity(university4);
		//System.out.println("University::"+university);
		
		List<University> list = universityDAO.list();
		for(University p : list)
		{
			System.out.println("\n University List::"+p);
		}
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		 university3 = new University(40, "Chennei", "Chennei");
		universityDAO.updateUniversity(university3);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		universityDAO.getUniversityById(20);
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
		universityDAO.removeUniversity(30);
		context.close();	
	}

}
