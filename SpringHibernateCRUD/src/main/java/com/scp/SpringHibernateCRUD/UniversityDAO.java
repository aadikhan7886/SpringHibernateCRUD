package com.scp.SpringHibernateCRUD;

import java.util.List;

 interface UniversityDAO
{
	public void addUniversity(University p);
	public void updateUniversity(University p);
	public List<University> list();
	public University getUniversityById(int id);
	public void removeUniversity(int id);
}