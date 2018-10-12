package com.scp.SpringHibernateCRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class UniversityDAOImpl implements UniversityDAO {
	static final Logger logger = LoggerFactory.getLogger(UniversityDAO.class);
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
		logger.info("Ready to save");
		Transaction trns = null;
		Session session = this.sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.persist(p);
			session.flush();
			trns.commit();
			logger.info("Data saved ");
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
		logger.info("Data Ready to save");
		Transaction trns = null;
		Session session = this.sessionFactory.openSession();
		try {
			trns = session.beginTransaction();
			session.update(p);
			
			session.getTransaction().commit();
			logger.debug("Record Updated");
		} catch (RuntimeException e) {
			logger.warn("Record not Updated");
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
		logger.info("Retrieving data by ID "+id);
		University getUni = null;
		try {
			getUni = (University) session.load(University.class, id);
			logger.debug("getting data...");
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
		logger.info("Data Retrieved....");
		return getUni;
	}

	public void removeUniversity(int id) {
		Transaction trns = null;
		session = this.sessionFactory.openSession();
		logger.info("Removed data by id "+id);
		try {
			trns = session.beginTransaction();
			University university = (University) session.load(University.class, new Integer(id));
			session.delete(university);
			session.getTransaction().commit();
			logger.info("Record Removed...");
		} catch (RuntimeException e) {
			logger.warn("Record can't be removed");
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
