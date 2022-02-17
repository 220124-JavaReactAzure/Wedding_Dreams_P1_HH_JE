package weddingDreams.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="wedding")

public class Wedding {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wedding_booking_id", unique=true, nullable=false)
	private int wedding_booking_id;
	

	@Column(name="price")
	private double price;
	
	@Column(name="wedding_date", unique=true)
	private Date wedding_date;
	
	@Column(name="rsvp_date")
	private Date rsvp_date;
	
	
	public int getWedding_booking_id() {
		return wedding_booking_id;
	}
	public void setWedding_booking_id(int wedding_booking_id) {
		this.wedding_booking_id = wedding_booking_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getWedding_date() {
		return wedding_date;
	}
	public void setWedding_date(Date wedding_date) {
		this.wedding_date = wedding_date;
	}
	public Date getRsvp_date() {
		return rsvp_date;
	}
	public void setRsvp_date(Date rsvp_date) {
		this.rsvp_date = rsvp_date;
	}
	
	
	// overloaded constructors
	public Wedding() {
		
	}
	

	public Wedding(int wedding_booking_id, double price, Date wedding_date, Date rsvp_date) {
		super();
		this.wedding_booking_id = wedding_booking_id;
		this.price = price;
		this.wedding_date = wedding_date;
		this.rsvp_date = rsvp_date;
	}
	
	
	// other methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rsvp_date == null) ? 0 : rsvp_date.hashCode());
		result = prime * result + wedding_booking_id;
		result = prime * result + ((wedding_date == null) ? 0 : wedding_date.hashCode());
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
		Wedding other = (Wedding) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rsvp_date == null) {
			if (other.rsvp_date != null)
				return false;
		} else if (!rsvp_date.equals(other.rsvp_date))
			return false;
		if (wedding_booking_id != other.wedding_booking_id)
			return false;
		if (wedding_date == null) {
			if (other.wedding_date != null)
				return false;
		} else if (!wedding_date.equals(other.wedding_date))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Wedding [wedding_booking_id=" + wedding_booking_id + ", price=" + price + ", wedding_date="
				+ wedding_date + ", rsvp_date=" + rsvp_date + "]";
	}
	
	

}
