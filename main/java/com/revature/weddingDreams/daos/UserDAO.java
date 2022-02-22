package com.revature.weddingDreams.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.weddingDreams.models.User;
import com.revature.weddingDreams.util.HibernateUtil;

public class UserDAO {

	public boolean addUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// session method
	public boolean updateUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			// Updates and Deletes always start with a transaction and end with a commit
			session.beginTransaction();
			session.merge(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteUser(User user) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public List<User> getAllUsers() {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			List<User> users = session.createQuery("From users").list();
			session.getTransaction().commit();
			session.close();
			return users;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public User getUserByEmailandPassword(String email, String password) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			User user = session.get(User.class, email);
			session.getTransaction().commit();
			session.close();

			if(user.getPassword().equals(password)) {
				return user;
			}
			else {
				return null;
			}
		} 
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
