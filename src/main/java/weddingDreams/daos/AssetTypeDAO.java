package weddingDreams.daos;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import weddingDreams.models.Asset;
import weddingDreams.models.AssetType;
import weddingDreams.util.HibernateUtil;

public class AssetTypeDAO {

	public boolean addNewAssetType(AssetType assetType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(assetType);
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

	public List<AssetType> getAllAssetTypes() {
		try {
			Session session = HibernateUtil.getSession();
			List<AssetType> allAssetTypes = session.createQuery("FROM AssetType").list();
			return allAssetTypes;

		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}

	}

	public AssetType getAssetTypeById(int asset_type_id) {
		try {
		Session session = HibernateUtil.getSession();
		AssetType assetType = session.get(AssetType.class, asset_type_id);
		return assetType;
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
	public void updateAssetTypeWithSessionMethod(AssetType assetType) {
		
		try {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.merge(assetType);
		transaction.commit();

		}
		catch(HibernateException | IOException e) {
			e.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession();
		}

	}
	
	public void deleteAssetType(AssetType assetType) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(assetType);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
	


}
