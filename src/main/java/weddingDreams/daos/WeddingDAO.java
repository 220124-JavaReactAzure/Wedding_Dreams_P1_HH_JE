package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import weddingDreams.util.HibernateUtil;

import weddingDreams.models.Wedding;

public class WeddingDAO {

	public boolean addNewWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(wedding);
			transaction.commit();
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Wedding> getAllWeddings() {
		try {
			Session session = HibernateUtil.getSession();
			List<Wedding> allWeddings = session.createQuery("FROM Wedding").list();
			return allWeddings;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public Wedding getWeddingById(int wedding_booking_id) {
		try {
		Session session = HibernateUtil.getSession();
		Wedding wedding = session.get(Wedding.class, wedding_booking_id);
		return wedding;
		}
		
		catch(HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
		HibernateUtil.closeSession();
		}
		
	}
	
	// remember that all update and delete queries start with a transaction and end with a commit
	public void updateWeddingWithSessionMethod(Wedding wedding) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(wedding);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteWedding(Wedding wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(wedding);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}