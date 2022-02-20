package weddingDreams.util;


import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import weddingDreams.models.Asset;
import weddingDreams.models.AssetType;
import weddingDreams.models.MealOptions;
import weddingDreams.models.User;
import weddingDreams.models.UserType;
import weddingDreams.models.Wedding;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static Session session;
	
	
	
	public static Session getSession() throws IOException {
		if(sessionFactory==null) {
			Configuration configuration = new Configuration();
			Properties properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			properties.load(loader.getResourceAsStream("hibernate.properties"));
			
			// then we add such properties to the configuration
			configuration.setProperties(properties);
			// now it should contain everything that we need from the properties file
			
			// one more step.
			// what can our xml do that our properties can't
			// we need to add our annotated classes
			configuration.addAnnotatedClass(Asset.class);
			configuration.addAnnotatedClass(AssetType.class);
			configuration.addAnnotatedClass(MealOptions.class);
			configuration.addAnnotatedClass(UserType.class);
			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Wedding.class);
			
			
			
			
			// do this for all classes that should serve as a table
//			configuration.addAnnotatedClass(Asset.class);
			
			// Service Registry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			

		}
		
		if(session == null) {
			session = sessionFactory.openSession();
			// sessions are not autocloseable
			// we will need to open and close sessions in our service layer
			
		}
		return session;
		
	}
	
	public static void closeSession() {
		session.close();
		session = null;
	}
	
	
	

}