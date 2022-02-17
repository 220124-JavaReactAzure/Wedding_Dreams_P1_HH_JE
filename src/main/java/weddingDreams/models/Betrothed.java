package weddingDreams.models;
import java.util.Objects;

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
@Table(name="betrothed")
public class Betrothed {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// this column below may have to go??
	@Column(name="betrothed_id", unique=true, nullable=false)
	private int betrothed_id;
	
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", unique = true, nullable = false, updatable = true)
	private User user;
	
	
	// will I need to create a new column name??
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "wedding_booking_id", unique = true, nullable = false, updatable = true)
	Wedding wedding;

	
	
	
	public int getBetrothed_id() {
		return betrothed_id;
	}
	public void setBetrothed_id(int betrothed_id) {
		this.betrothed_id = betrothed_id;
	}
	public Wedding getWedding() {
		return wedding;
	}
	public void setWedding(Wedding wedding) {
		this.wedding = wedding;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

	// overloaded constructors
	public Betrothed() {
		
	}
	

	
	public Betrothed(int betrothed_id, Wedding wedding, User user) {
		super();
		this.betrothed_id = betrothed_id;
		this.wedding = wedding;
		this.user = user;
	}

	
	// other methods
	@Override
	public int hashCode() {
		return Objects.hash(betrothed_id, user, wedding);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Betrothed other = (Betrothed) obj;
		return betrothed_id == other.betrothed_id && Objects.equals(user, other.user)
				&& Objects.equals(wedding, other.wedding);
	}
	@Override
	public String toString() {
		return "Betrothed [betrothed_id=" + betrothed_id + ", wedding=" + wedding + ", user=" + user + "]";
	}
	

	
	

}
