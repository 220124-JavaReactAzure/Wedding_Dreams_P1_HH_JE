package weddingDreams.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




public class MealOrderPlusOne {
	
	
	private Attendee attendee;
	private MealOptions lunchChoice;
	private MealOptions dinnerChoice;
	public Attendee getAttendee() {
		return attendee;
	}
	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}
	public MealOptions getLunchChoice() {
		return lunchChoice;
	}
	public void setLunchChoice(MealOptions lunchChoice) {
		this.lunchChoice = lunchChoice;
	}
	public MealOptions getDinnerChoice() {
		return dinnerChoice;
	}
	public void setDinnerChoice(MealOptions dinnerChoice) {
		this.dinnerChoice = dinnerChoice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendee == null) ? 0 : attendee.hashCode());
		result = prime * result + ((dinnerChoice == null) ? 0 : dinnerChoice.hashCode());
		result = prime * result + ((lunchChoice == null) ? 0 : lunchChoice.hashCode());
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
		MealOrderPlusOne other = (MealOrderPlusOne) obj;
		if (attendee == null) {
			if (other.attendee != null)
				return false;
		} else if (!attendee.equals(other.attendee))
			return false;
		if (dinnerChoice == null) {
			if (other.dinnerChoice != null)
				return false;
		} else if (!dinnerChoice.equals(other.dinnerChoice))
			return false;
		if (lunchChoice == null) {
			if (other.lunchChoice != null)
				return false;
		} else if (!lunchChoice.equals(other.lunchChoice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MealOrderPlusOne [attendee=" + attendee + ", lunchChoice=" + lunchChoice + ", dinnerChoice="
				+ dinnerChoice + "]";
	}
	
	
	
	
	

}
