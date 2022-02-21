package com.revature.weddingDreams.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.weddingDreams.models.Asset;
import com.revature.weddingDreams.models.User;
import com.revature.weddingDreams.models.Wedding;
import com.revature.weddingDreams.services.BetrothedService;
import com.revature.weddingDreams.services.EmployeeService;
import com.revature.weddingDreams.services.UserService;

public class BetrothedDash extends HttpServlet{

	private final BetrothedService betrothedService;
	private final UserService userService;
	private final EmployeeService employeeService;
	private final ObjectMapper mapper;	
	
	public BetrothedDash(UserService us, BetrothedService bs, EmployeeService es, ObjectMapper om) {
		this.userService = us;
		this.betrothedService = bs;
		this.employeeService = es;
		this.mapper = om; 
	}
	/*
	private List getVenuesAvailableForDay(int day, int month, int year) {
		List weddingList = betrothedService.getAllWeddings();
		
	}*/
	private String getNumberAssetTypesAvailable(List<Asset> list) {
		int[] counts = new int[5];
		for(int i =0; i < list.size(); i++) {
			counts[list.get(i).getAssetTypeID()-1] += 1;
		}
		
		String returnStr = "<p>"+String.valueOf(counts[0])+" venues available</p>" +
						   "<p>"+String.valueOf(counts[1])+" caterers available</p>" +
						   "<p>"+String.valueOf(counts[2])+" florists available</p>" +
						   "<p>"+String.valueOf(counts[3])+" photographers available</p>" +
						   "<p>"+String.valueOf(counts[4])+" musician available</p>";			
		return returnStr;
	}
	private String createDayLink(int year, int month, int day) {
		return "<a href=\"build-wedding\\?day="+day+"&month="+month+"&year="+year+"\" >Select this day</a>";
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession(true);
		User authUser = (User) httpSession.getAttribute("authUser");
		if( authUser.getWedding() == null) { // user needs to create wedding, load create wedding form
			
			int year = LocalDate.now().getYear();
			int month = LocalDate.now().getMonthValue();
			int day = LocalDate.now().getDayOfWeek().getValue();
			int lengthOfMonth = LocalDate.now().lengthOfMonth();
			
			
			int firstOfMonthDay = LocalDate.now().withDayOfMonth(1).getDayOfWeek().getValue();
			
			PrintWriter writer = resp.getWriter();
			
			String stringHtml ="<html>"+
						"<head>"+
						"<style>"+
						"table {"
						+ "  font-family: arial, sans-serif;"
						+ "  border-collapse: collapse;"
						+ "  width: 100%;}"
						+ "td, th {"
						+ "  border: 1px solid #dddddd;"
						+ "  text-align: left;"
						+ "  width:14%;"
						+ "  padding: 8px;}"+
						"</style>"+
						"</head>"+
						"<body>";
			
			String calendarStr = "<table>"+
								 "<tr>"+
								 "<th>Sun  </th>"+
								 "<th>Mon  </th>"+
								 "<th>Tues </th>"+
								 "<th>Wed  </th>"+
								 "<th>Thurs</th>"+
								 "<th>Fri  </th>"+
								 "<th>Sat  </th>"+
								 "</tr>";
			
			String firstWeekStr = "<tr>";
			List<Asset> list = employeeService.getAllAssets();
			
			int i = 0;
			for(i = 0; i<6;i++) {
				if(i == firstOfMonthDay) {
					// get list of available venues
					// for now get all venues , and list number of each type available
							
					firstWeekStr = firstWeekStr.concat("<th>1"+getNumberAssetTypesAvailable(list)+createDayLink(year,month,1)+"</th>");
					while(i<6) {
						firstWeekStr = firstWeekStr.concat("<th>"+i+" "+getNumberAssetTypesAvailable(list)+createDayLink(year,month,i)+"</th>");
						i++;
					}
				}
				else {
					firstWeekStr = firstWeekStr.concat("<th>     </th>");
				}
			}
			firstWeekStr = firstWeekStr.concat("</tr>");
			String tempStr =  "<tr>";
			i-=1;
			int dayOfWeekCount = 1;
			while(i <= lengthOfMonth) {
				
				if(dayOfWeekCount == 7) { // finish week, start new one
					dayOfWeekCount = 0;
					tempStr = tempStr.concat("<th>"+i+" "+getNumberAssetTypesAvailable(list)+createDayLink(year,month,i)+"</th></tr>");
					if(i < lengthOfMonth ) {
						tempStr = tempStr.concat("</tr>");
					}
				}
				else {
					tempStr = tempStr.concat("<th>"+i+" "+getNumberAssetTypesAvailable(list)+createDayLink(year,month,i)+"</th>");
				}
				i++;
				dayOfWeekCount++;
			}
			tempStr = tempStr.concat("</table>");
						
			String stringHtmlEnd ="</body>"+
								  "</html>";
			
			writer.write(stringHtml+calendarStr+firstWeekStr+tempStr+stringHtmlEnd);
			//LocalDate.now().isLeapYear();
			// show calendar
			//List<Wedding> weddingList = betrothedService.getAllWeddings();
			
/*			
	private String weddingID;
	
	private String weddingDate;
	
	private double weddingBudget;
	
	private String venueID;
	
	private String musicianID;
	
	private String catererID;
	
	private String floristID;
	
	private String photographerID;
*/	
			
			
		}
		else { // find user wedding , load edit form
			
		}
	}

	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	*/
}