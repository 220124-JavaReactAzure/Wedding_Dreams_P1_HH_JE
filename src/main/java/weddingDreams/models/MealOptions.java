package weddingDreams.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="meal_options")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "meal_id")
public class MealOptions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "meal_id", unique=true, nullable=false)
	private int meal_id;
	
	@Column(name="meal_description")
	private String meal_description;
	
	
	
	//overloaded constructors
	public MealOptions() {
		
	}
	
	
	public MealOptions(int meal_id, String meal_description) {
		super();
		this.meal_id = meal_id;
		this.meal_description = meal_description;
	}
	
	
	
	
	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public String getMeal_description() {
		return meal_description;
	}
	public void setMeal_description(String meal_description) {
		this.meal_description = meal_description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meal_description == null) ? 0 : meal_description.hashCode());
		result = prime * result + meal_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealOptions other = (MealOptions) obj;
		if (meal_description == null) {
			if (other.meal_description != null)
				return false;
		} else if (!meal_description.equals(other.meal_description))
			return false;
		if (meal_id != other.meal_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MealOptions [meal_id=" + meal_id + ", meal_description=" + meal_description + "]";
	}
	
	

}