package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import weddingDreams.models.AssetType;
import weddingDreams.models.UserType;
import weddingDreams.util.HibernateUtil;

public class UserTypeDAO {

	public boolean addNewUserType(UserType userType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(userType);
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

	public List<UserType> getAllUserTypes() {
		try {
			Session session = HibernateUtil.getSession();
			List<UserType> allUserTypes = session.createQuery("FROM UserType").list();
			return allUserTypes;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public UserType getUserTypeById(int user_type_id) {
		try {
		Session session = HibernateUtil.getSession();
		UserType userType = session.get(UserType.class, user_type_id);
		return userType;
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
	public void updateUserTypeWithSessionMethod(UserType userType) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(userType);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteUserType(UserType userType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(userType);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
	


}