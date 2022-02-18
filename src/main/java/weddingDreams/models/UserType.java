package weddingDreams.models;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user_types")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "user_type_id")
public class UserType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_type_id", unique=true, nullable=false)
	private int user_type_id;
	// if a user has type 1, they are an employee
	// if a user has type 2, they are an attendee
	// if a user has type 3, they are betrothed
	
	@Column(name="description")
	private String description;
	
	
	// getters and setters

	public int getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(int user_type_id) {
		this.user_type_id = user_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	// overloaded constructors
	public UserType() {
		
	}

	public UserType(int user_type_id, String description) {
		super();
		this.user_type_id = user_type_id;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, user_type_id);
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
		return Objects.equals(description, other.description) && user_type_id == other.user_type_id;
	}

	@Override
	public String toString() {
		return "UserType [user_type_id=" + user_type_id + ", description=" + description + "]";
	}
	
	
	
	
	
	
	


	
	


}