package weddingDreams.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="users")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "user_id")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private int user_id;
	
	
	// will this create a column in my users table??
//	@Column(name="user_type_id")
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_type_id",referencedColumnName="user_type_id", unique = true, nullable = false, updatable = true)
	private UserType userType;
	
	
	@Column(name="name")
	private String name;
	

	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	

	// will this create a column in my users table??
//	@Column(name="meal_id")
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	// is this stating that the column in my users table can be unique or nullable, or in the meal
	@JoinColumn(name = "meal_id_attendee",referencedColumnName="meal_id", unique = false, nullable = true, updatable = true)
	private MealOptions mealOptionsAttendee;
	
	
	@Column(name="plus_one", unique=false, nullable=true)
	private boolean plus_one;
	
	
	// will this create a column in my users table??
//	@Column(name="meal_id_plus_one", unique = false, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "meal_id_plus_one",referencedColumnName="meal_id", unique = false, nullable = true, updatable = true)
	private MealOptions mealOptionsPlusOne;
	
	
	// will this create a column in my users table??
//	@Column(name="wedding_id", unique = true, nullable=false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "wedding_id",referencedColumnName="wedding_id", unique = false, nullable = true, updatable = true)
	private Wedding wedding;
	
	
	@Column(name="is_betrothed", unique=false, nullable=false)
	private boolean is_betrothed;
	
	
	// overloaded constructors
	
	public User() {
		
	}


	public User(int user_id, UserType userType, String name, String email, String password,
			MealOptions mealOptionsAttendee, boolean plus_one, MealOptions mealOptionsPlusOne, Wedding wedding,
			boolean is_betrothed) {
		super();
		this.user_id = user_id;
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mealOptionsAttendee = mealOptionsAttendee;
		this.plus_one = plus_one;
		this.mealOptionsPlusOne = mealOptionsPlusOne;
		this.wedding = wedding;
		this.is_betrothed = is_betrothed;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public MealOptions getMealOptionsAttendee() {
		return mealOptionsAttendee;
	}


	public void setMealOptionsAttendee(MealOptions mealOptionsAttendee) {
		this.mealOptionsAttendee = mealOptionsAttendee;
	}


	public boolean isPlus_one() {
		return plus_one;
	}


	public void setPlus_one(boolean plus_one) {
		this.plus_one = plus_one;
	}


	public MealOptions getMealOptionsPlusOne() {
		return mealOptionsPlusOne;
	}


	public void setMealOptionsPlusOne(MealOptions mealOptionsPlusOne) {
		this.mealOptionsPlusOne = mealOptionsPlusOne;
	}


	public Wedding getWedding() {
		return wedding;
	}


	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}


	public boolean isIs_betrothed() {
		return is_betrothed;
	}


	public void setIs_betrothed(boolean is_betrothed) {
		this.is_betrothed = is_betrothed;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
