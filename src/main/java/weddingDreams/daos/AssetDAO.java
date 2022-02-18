package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import weddingDreams.util.HibernateUtil;

import weddingDreams.models.Asset;

public class AssetDAO {

	// CRUD operations

	public boolean addNewAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(asset);
			return true;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			// or maybe instead later, make the stack trace print to the logger

			return false;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public List<Asset> getAllAssets() {
		try {
			Session session = HibernateUtil.getSession();
			List<Asset> allAssets = session.createQuery("FROM Asset").list();
			return allAssets;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public Asset getAssetById(int asset_id) {
		try {
		Session session = HibernateUtil.getSession();
		Asset asset = session.get(Asset.class, asset_id);
		return asset;
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
	public void updateAssetWithSessionMethod(Asset asset) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(asset);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(asset);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
	


}