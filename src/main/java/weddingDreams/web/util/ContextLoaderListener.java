package weddingDreams.web.util;

import java.lang.System.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import weddingDreams.web.servlets.WeddingServlet;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
//	private final Logger logger = LogManager.getLogger();
	

	
	public void contextInitalized(ServletContextEvent sce) {
		ObjectMapper mapper = new ObjectMapper();
		
		
		ServletContext context = sce.getServletContext();
		// instantiate the servlets then add them here 
		WeddingServlet ws = new WeddingServlet(mapper);
		context .addServlet("Wedding Servlet", ws).addMapping("/wedding");
//		context.addServlet("MonsterServlet", monsterServlet).addMapping("/monsters/*");
//		context.addServlet("AuthServlet", authServlet).addMapping("/auth");
		
	}
	
	
	
	
	
	
	

}
