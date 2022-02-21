package com.revature.weddingDreams.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingDreams.models.Asset;
import com.revature.weddingDreams.services.EmployeeService;

public class EmployeeDash extends HttpServlet {

	private final EmployeeService employeeService;
	private final ObjectMapper mapper;
	
	
	public EmployeeDash(EmployeeService es, ObjectMapper om) {
	  this.employeeService = es;
	  this.mapper = om; 
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();

		String addAssetStr = 
			"<form action=\"./employee-dash\" method=\"post\">" +
				
			"<label for=\"name\">Company Name</label>"+      // input field for asset name
			"<input type=\"text\" name=\"name\" required>"+
			"<br />"+
			"<label for=\"price\">Price</label>"+            // input field for asset price
			"<input type=\"text\" name=\"price\" required>"+
			"<br />"+		
			"<label for=\"address\">Address</label>"+            // input field for asset price
			"<input type=\"text\" name=\"address\" required>"+
			"<br />"+		
			
			"<input type=\"radio\" name=\"type\" id=\"venue\" value=\"1\">"+ // radio buttons to select asset type
	        "<label for=\"venue\">Venue</label>"+
	        "<input type=\"radio\" name=\"type\" id=\"caterer\" value=\"2\">"+
	        "<label for=\"caterer\">Caterer</label>"+
	        "<input type=\"radio\" name=\"type\" id=\"florist\" value=\"3\">"+
	        "<label for=\"florist\">Florist</label>"+
			"<input type=\"radio\" name=\"type\" id=\"photographer\" value=\"4\">"+
			"<label for=\"photographer\">Photographer</label>"+
			"<input type=\"radio\" name=\"type\" id=\"musician\" value=\"5\">"+
			"<label for=\"musician\">Musician</label>"+
			"<br />"+
	        "<input type=\"submit\" value=\"Create\"><br />";
		
		writer.write(addAssetStr);
		
		// this prints out all of the assets that have been added, want to add links to each one for deleting an individual asset
		List<Asset> list = employeeService.getAllAssets();
		
		for(int i =0; i < list.size(); i++) {
			writer.write("<p>"+list.get(i).getAssetID()+" "+list.get(i).getCompanyName()+" "+list.get(i).getPrice()+" "+list.get(i).getAssetTypeID()+"</p>");
		}
	}

	@Override // Adds asset to data base
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String assetID = UUID.randomUUID().toString();
		Asset newAsset = new Asset(assetID, req.getParameter("name"), req.getParameter("address"), Double.parseDouble(req.getParameter("price")), Integer.parseInt(req.getParameter("type")));
		
		try {
			boolean res = employeeService.addAsset(newAsset);
			if(res) {
				resp.setStatus(201);
				resp.getWriter().write("<p>Asset added to database. </p><a href=\"employee-dash\">Click to add another asset</a>");
				// add link to logout
			}
			else {
				resp.setStatus(500);
				resp.getWriter().write("Unable to persist asset to database");
			}
		}
		catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw an exception");
			e.printStackTrace();
		}
		catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other exception");
			e.printStackTrace();
		}	
	}
}