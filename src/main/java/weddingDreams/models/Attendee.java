package weddingDreams.models;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="attendee")

public class Attendee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// this line below might have to be gone???
	@Column(name="attendee_id")
	private int attendee_id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", unique = true, nullable = false, updatable = true)
	private User user;
	
	
	
	
	
	// must do some many-to-many relationship or join column
	private Wedding wedding;
	
	@Column(name="rsvp_response")
	private boolean rsvp_response;
	
	@Column(name="plus_one_response")
	private boolean plus_one_response;
	
	
	public int getAttendee_id() {
		return attendee_id;
	}
	public void setAttendee_id(int attendee_id) {
		this.attendee_id = attendee_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Wedding getWedding() {
		return wedding;
	}
	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}
	public boolean isRsvp_response() {
		return rsvp_response;
	}
	public void setRsvp_response(boolean rsvp_response) {
		this.rsvp_response = rsvp_response;
	}
	public boolean isPlus_one_response() {
		return plus_one_response;
	}
	public void setPlus_one_response(boolean plus_one_response) {
		this.plus_one_response = plus_one_response;
	}
	
	
	// Overloaded constructors
	public Attendee() {
		
	}
	
	
	public Attendee(int attendee_id, User user, Wedding wedding, boolean rsvp_response, boolean plus_one_response) {
		super();
		this.attendee_id = attendee_id;
		this.user = user;
		this.wedding = wedding;
		this.rsvp_response = rsvp_response;
		this.plus_one_response = plus_one_response;
	}
	
	
	// other methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + attendee_id;
		result = prime * result + (plus_one_response ? 1231 : 1237);
		result = prime * result + (rsvp_response ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((wedding == null) ? 0 : wedding.hashCode());
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
		Attendee other = (Attendee) obj;
		if (attendee_id != other.attendee_id)
			return false;
		if (plus_one_response != other.plus_one_response)
			return false;
		if (rsvp_response != other.rsvp_response)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (wedding == null) {
			if (other.wedding != null)
				return false;
		} else if (!wedding.equals(other.wedding))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Attendee [attendee_id=" + attendee_id + ", user=" + user + ", wedding=" + wedding + ", rsvp_response="
				+ rsvp_response + ", plus_one_response=" + plus_one_response + "]";
	}
	
	
	
	
	
	

}
