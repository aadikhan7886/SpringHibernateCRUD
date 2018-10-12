package com.scp.SpringHibernateCRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UniversityDAOImpl implements UniversityDAO {
	private SessionFactory sessionFactory;
	public Session session;
	//Transaction transaction;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addUniversity(University p) {
		Transaction trns = null;
		Session session = this.sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.persist(p);
			session.flush();
			trns.commit();
			//session.close();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
		} finally {
			//session.flush();
			// session.close();
		}
	}

	public void updateUniversity(University p) {
		Transaction trns = null;
		Session session = this.sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			// session.flush();
			// session.close();
		}
	}

	public List<University> list() {
		session = this.sessionFactory.openSession();
		List<University> universityList = session.createQuery("from University").list();
		for (University p : universityList) {
			System.out.println(p);
		}
		return universityList;
	}

	public University getUniversityById(int id) {
		Transaction trns = null;
		session = this.sessionFactory.openSession();
		University getUni = null;
		try {
			getUni = (University) session.load(University.class, id);
			System.out.println(getUni);
			return getUni;
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			// session.flush();
			// session.close();
		}
		return getUni;
	}

	public void removeUniversity(int id) {
		Transaction trns = null;
		session = this.sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			University university = (University) session.load(University.class, new Integer(id));
			session.delete(university);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			// session.flush();
			// session.close();
		}

	}

}
