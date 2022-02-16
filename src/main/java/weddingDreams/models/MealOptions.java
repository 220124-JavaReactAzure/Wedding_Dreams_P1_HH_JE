package weddingDreams.models;

public class MealOptions {
	
	private int meal_id;
	private String meal_description;
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
