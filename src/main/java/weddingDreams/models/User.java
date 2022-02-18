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
	
	@Column(name="name")
	private String name;
	
	
	
	// will this create a column in my users table??
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_type_id", unique = true, nullable = false, updatable = true)
	private UserType userType;
	
	

	// will this create a column in my users table??
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "meal_id", unique = true, nullable = false, updatable = true)
	private MealOptions mealOptionsAttendee;
	
	
	@Column(name="plus_one")
	private boolean plus_one;
	
	
	// will this create a column in my users table??
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "meal_id", unique = true, nullable = false, updatable = true)
	private MealOptions mealOptionsPlusOne;
	
	
	// will this create a column in my users table??
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "wedding_id", unique = true, nullable = false, updatable = true)
	private Wedding wedding;
	
	
	@Column(name="is_betrothed")
	private boolean is_betrothed;
	
	
	
	
	
	
	

}
