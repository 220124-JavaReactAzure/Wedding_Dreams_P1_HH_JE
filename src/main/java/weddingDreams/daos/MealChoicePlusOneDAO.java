package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingDreams.util.HibernateUtil;

import weddingDreams.models.MealOrder;

public class MealChoicePlusOneDAO {

	public boolean addNewMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(mealOrder);
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<MealOrder> getAllMealOrders() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealOrder> allMealOrders = session.createQuery("FROM MealOrder").list();
			return allMealOrders;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	// id for what??
	public MealOrder getMealOrderById(int id) {
		try {
		Session session = HibernateUtil.getSession();
		MealOrder mealOrder = session.get(MealOrder.class, id);
		return mealOrder;
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
	public void updateMealOrderWithSessionMethod(MealOrder mealOrder) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(mealOrder);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteMealOrder(MealOrder mealOrder) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(mealOrder);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
