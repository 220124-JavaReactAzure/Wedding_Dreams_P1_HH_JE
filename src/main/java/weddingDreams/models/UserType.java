package weddingDreams.models;

import java.util.Objects;

public class UserType {
	
	private int user_type;
	// if a user has type 1, they are an employee
	// if a user has type 2, they are an attendee
	// if a user has type 3, they are betrothed
	
	private String description;
	
	
	
	
// getters and setters
	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	//overloaded constructors
	
	public UserType() {
		
	}
	
	
	public UserType(int user_type, String description) {
		super();
		this.user_type = user_type;
		this.description = description;
	}

	
	// other methods
	@Override
	public int hashCode() {
		return Objects.hash(description, user_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserType other = (UserType) obj;
		return Objects.equals(description, other.description) && user_type == other.user_type;
	}

	@Override
	public String toString() {
		return "UserType [user_type=" + user_type + ", description=" + description + "]";
	}
	
	


}
