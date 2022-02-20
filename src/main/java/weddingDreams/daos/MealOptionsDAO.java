package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import weddingDreams.util.HibernateUtil;

import weddingDreams.models.MealOptions;

public class MealOptionsDAO {

	public boolean addNewMealOption(MealOptions mealOption) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(mealOption);
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

	public List<MealOptions> getAllMealOptions() {
		try {
			Session session = HibernateUtil.getSession();
			List<MealOptions> allMealOptions = session.createQuery("FROM MealOptions").list();
			return allMealOptions;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public MealOptions getMealOptionById(int meal_id) {
		try {
		Session session = HibernateUtil.getSession();
		MealOptions mealOption = session.get(MealOptions.class, meal_id);
		return mealOption;
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
	public void updateMealOptionWithSessionMethod(MealOptions mealOption) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(mealOption);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteMealOption(MealOptions mealOption) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(mealOption);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}