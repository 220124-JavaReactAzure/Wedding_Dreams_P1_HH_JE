package weddingDreams.web.util;

//import java.lang.System.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import weddingDreams.web.servlets.WeddingServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//initialize all DAOS, Services, and Servlets
		// then add the servlets to the context
		
		
		ServletContext context = sce.getServletContext();
		//context.addServlet("NameOfServlet", servletInited).addMapping("/urlPath/*");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
	}
}



	


	
	
	
	
	

