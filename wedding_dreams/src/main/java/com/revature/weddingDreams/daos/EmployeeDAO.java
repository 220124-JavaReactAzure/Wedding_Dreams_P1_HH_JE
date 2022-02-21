package com.revature.weddingDreams.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.weddingDreams.models.Asset;
import com.revature.weddingDreams.util.HibernateUtil;


public class EmployeeDAO {
	
	public boolean addAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(asset);
			session.getTransaction().commit();
			session.close();
			return true;
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}	
	}	
	
	public List<Asset> getAllAssets() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Asset> criteria = builder.createQuery(Asset.class);
		criteria.from(Asset.class);
		List<Asset> data = session.createQuery(criteria).getResultList();
		return data;
	}

	
/*
	 public Asset getAssetByID(String id) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Asset asset = session.get(Asset.class, id);
			session.getTransaction().commit();
			return asset;
		}
		catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<Asset> getAssetsByType(int type) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Query query = session.createQuery("FROM assets where asset_id = :TYPE");
			
			query.setParameter("TYPE", type);
	
			List<Asset> assetList = query.getResultList();
			session.getTransaction().commit();
			return assetList;
		}
		catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			HibernateUtil.closeSession();
		}
	}

	public boolean deleteAsset(Asset asset) {
		try {
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(asset);
			session.getTransaction().commit();
			return true;
		}
		catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			HibernateUtil.closeSession();
		}
	}
 */
	
	
	
	
	
}
