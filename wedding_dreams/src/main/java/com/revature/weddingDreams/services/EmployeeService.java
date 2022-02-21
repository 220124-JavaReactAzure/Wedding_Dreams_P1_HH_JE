package com.revature.weddingDreams.services;

import java.util.List;

import com.revature.weddingDreams.daos.EmployeeDAO;
import com.revature.weddingDreams.models.Asset;


public class EmployeeService {

	private final EmployeeDAO employeeDAO;
		
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public boolean addAsset(Asset asset) {
		return employeeDAO.addAsset(asset);
	}
	
	public List getAllAssets() {
		return employeeDAO.getAllAssets();
	}
	
	/*
	public Asset getAssetByID(String id) {
		return employeeDAO.getAssetByID(id);
	}
	
	public List<Asset> getAssetsByType(int type) {
		return employeeDAO.getAssetsByType(type);
	}
	
	public boolean deleteAsset(Asset asset) {
		return employeeDAO.deleteAsset(asset);
	}
	*/
}