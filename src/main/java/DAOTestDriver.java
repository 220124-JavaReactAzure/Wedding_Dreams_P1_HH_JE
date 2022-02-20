import java.util.List;

import weddingDreams.daos.AssetDAO;
import weddingDreams.daos.MealOptionsDAO;
import weddingDreams.daos.UserDAO;
import weddingDreams.daos.UserTypeDAO;
import weddingDreams.models.Asset;
import weddingDreams.models.MealOptions;
import weddingDreams.models.User;
import weddingDreams.models.UserType;
import weddingDreams.models.Wedding;

public class DAOTestDriver {

	
	public static void main(String[] args) {
		
//		UserTypeDAO userTypeDAO = new UserTypeDAO();
		
//		UserType userType1 = new UserType();
//		userType1.setDescription("attendee");
//		boolean userType1Result = userTypeDAO.addNewUserType(userType1);
//		System.out.println("Result of persistence for User type 1: "+ userType1Result);
//		
//		
//		
//		UserType userType2 = new UserType();
//		userType2.setDescription("employee");
//		boolean userType2Result = userTypeDAO.addNewUserType(userType2);
//		System.out.println("Result of persistence for User type 2: "+ userType2Result);
//		
//		
//		
//		UserType userType3 = new UserType();
//		userType3.setDescription("betrothed");
//		boolean userType3Result = userTypeDAO.addNewUserType(userType3);
//		System.out.println("Result of persistence for User type 3: "+ userType3Result);
		
		
//		UserDAO userDAO = new UserDAO();
		MealOptionsDAO mealOptionsDAO = new MealOptionsDAO();
//		
//		List<MealOptions> mealOptionsList = mealOptionsDAO.getAllMealOptions();
//		for(MealOptions mealOption : mealOptionsList) {
//			mealOptionsDAO.deleteMealOption(mealOption);
//		}
//		
//		
	
		
		MealOptions meal1 = new MealOptions(1, "meat");
		boolean meal1Result = mealOptionsDAO.addNewMealOption(meal1);
		System.out.println("Persistence result for meal 1: " + meal1Result);
		
		
		
		MealOptions meal2 = new MealOptions(2, "fish");
		boolean meal2Result = mealOptionsDAO.addNewMealOption(meal2);
		System.out.println("Persistence result for meal 2: " + meal2Result);
		
		
		MealOptions meal3 = new MealOptions(3, "veggie");
		boolean meal3Result = mealOptionsDAO.addNewMealOption(meal3);
		System.out.println("Persistence result for meal 3: " + meal3Result);
		
		
		
		
			
			
//		User user1 = new User();
//		user1.setEmail("testemail@gmail.com");
//		user1.setIs_betrothed(false);
//		MealOptions mealAttendee = new MealOptions(1, "veggie");
//		boolean mealAttendeeResult = mealOptionsDAO.addNewMealOption(mealAttendee);
//		
//		System.out.println("Persistence result for mealAttendee: " + mealAttendeeResult);
//		user1.setMealOptionsAttendee(mealAttendee);
//		user1.setPlus_one(false);
//		user1.setName("Hannah");
//		user1.setPassword("helloWOrld");
//		UserType userType1 = new UserType(1, "attendee");
//		user1.setUserType(userType1);
//		user1.setWedding(null);
//		
//		boolean user1Persistence = userDAO.addNewUser(user1);
//		System.out.println("Persistence result for user1: " + user1Persistence);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
