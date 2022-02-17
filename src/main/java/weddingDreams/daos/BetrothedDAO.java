package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.weddingDreams.util.HibernateUtil;

import weddingDreams.models.Betrothed;

public class BetrothedDAO {

	// CRUD operations

	public boolean addNewBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(betrothed);
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Betrothed> getAllBetrothed() {
		try {
			Session session = HibernateUtil.getSession();
			List<Betrothed> allBetrothed = session.createQuery("FROM Betrothed").list();
			return allBetrothed;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	// hmmm how do I want to handle this? should I do getBetrothedByEmail
//	public Betrothed getAssetById(int asset_id) {
//		try {
//		Session session = HibernateUtil.getSession();
//		Asset asset = session.get(Asset.class, asset_id);
//		return asset;
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
	public void updateBetrothedWithSessionMethod(Betrothed betrothed) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(betrothed);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteBetrothed(Betrothed betrothed) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(betrothed);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
