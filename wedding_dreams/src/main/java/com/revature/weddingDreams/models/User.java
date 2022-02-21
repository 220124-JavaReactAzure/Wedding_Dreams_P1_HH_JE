package com.revature.weddingDreams.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

//Variables
	@Id
	@Column(name="email")
	private String email;
	
	@Column(name="pass_word")
	private String password;
	
	@Column(name="user_type")
	private int userType;
	
	@Column(name="meal_options_attendee")
	private int mealOptionsAttendee;

	@Column(name="plus_one")
	private boolean plusOne;
	
	@Column(name="meal_options_plus_one")
	private int mealOptionsPlusOne;
	
	@Column(name="wedding_id")
	private String wedding; // wedding IDs will always be positive, -1 means haven't fully processes a new user

//Constructors
	public User() { super(); }
	
	public User(String email, String password, int userType, int mealOptionsAttendee, boolean plusOne, int mealOptionsPlusOne, String wedding) {
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.mealOptionsAttendee = mealOptionsAttendee;
		this.plusOne = plusOne;
		this.mealOptionsPlusOne = mealOptionsPlusOne;
		this.wedding= wedding; 
	}
	
//Getters and Setters
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

	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getMealOptionsAttendee() {
		return mealOptionsAttendee;
	}
	public void setMealOptionsAttendee(int mealOptionsAttendee ) {
		this.mealOptionsAttendee = mealOptionsAttendee;
	}
	
	public boolean getPlusOne() {
		return plusOne;
	}
	public void setPlusOne(boolean plusOne) {
		this.plusOne = plusOne;
	}
	
	public int getMealOptionsPlusOne() {
		return mealOptionsPlusOne;
	}
	public void setMealOptionsPlusOne(int mealOptionsPlusOne) {
		this.mealOptionsPlusOne = mealOptionsPlusOne;
	}
	
	public String getWedding() {
		return wedding;
	}
	public void setWedding(String wedding) {
		this.wedding = wedding;
	}	
}