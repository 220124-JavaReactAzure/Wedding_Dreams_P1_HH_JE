package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingDreams.util.HibernateUtil;

import weddingDreams.models.Attendee;



public class AttendeeDAO {

	public boolean addNewAttendee(Attendee attendee) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(attendee);
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Attendee> getAllAttendees() {
		try {
			Session session = HibernateUtil.getSession();
			List<Attendee> allAttendees = session.createQuery("FROM Attendee").list();
			return allAttendees;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public Attendee getAttendeeById(int attendee_id) {
		try {
		Session session = HibernateUtil.getSession();
		Attendee attendee = session.get(Attendee.class, attendee_id);
		return attendee;
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
	public void updateAttendeeWithSessionMethod(Attendee attendee) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(attendee);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteAttendee(Attendee attendee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(attendee);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}