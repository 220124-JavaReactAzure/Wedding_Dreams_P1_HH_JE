package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingDreams.util.HibernateUtil;

import weddingDreams.models.Employee;

public class EmployeeDAO {

	public boolean addNewAttendee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(employee);
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Employee> getAllEmployees() {
		try {
			Session session = HibernateUtil.getSession();
			List<Employee> allEmployees = session.createQuery("FROM Employee").list();
			return allEmployees;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	
	// maybe I should generate each user an id instead of email??
//	public Employee getAttendeeById(int attendee_id) {
//		try {
//		Session session = HibernateUtil.getSession();
//		Attendee attendee = session.get(Attendee.class, attendee_id);
//		return attendee;
//		}
//		
//		catch(HibernateException | IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		finally {
//		HibernateUtil.closeSession();
//		}
//		
//	}
	
	// remember that all update and delete queries start with a transaction and end with a commit
	public void updateEmployeeWithSessionMethod(Employee employee) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(employee);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteEmployee(Employee employee) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(employee);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
}
