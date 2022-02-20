package weddingDreams.models;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="weddings")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "wedding_id")
public class Wedding {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="wedding_id", unique=true, nullable=false)
	private int wedding_id;
	
	// as of right now, only one wedding can be booked for a particular date, for simplicity sake
	@Column(name="wedding_date", unique = true, nullable=false)
	private Date wedding_date;
	
	
	@Column(name="wedding_budget")
	private double wedding_budget;
	
	
	// how do I represent venue_id, musician_id, caterer_id, florist_id, and photographer_id. 
	//DO i create columns for each one? and do i need to 
//	@Column(name="venue_id", unique = true, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "venue_id",referencedColumnName="asset_id", unique = true, nullable = false, updatable = true)
	private Asset venue;
	
	
//	@Column(name="musician_id", unique = true, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "musician_id",referencedColumnName="asset_id", unique = true, nullable = false, updatable = true)
	private Asset musician;
	
//	@Column(name="caterer_id", unique = true, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "caterer_id",referencedColumnName="asset_id", unique = true, nullable = false, updatable = true)
	private Asset caterer;
	
	
//	@Column(name="florist_id", unique = true, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "florist_id",referencedColumnName="asset_id", unique = true, nullable = false, updatable = true)
	private Asset florist;
	
	
//	@Column(name="photographer_id", unique = true, nullable=true)
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "photographer_id",referencedColumnName="asset_id", unique = true, nullable = false, updatable = true)
	private Asset photographer;


	
	
	//Overloaded constructors
	public Wedding() {
		
	}
	
	
	
	public Wedding(int wedding_id, Date wedding_date, double wedding_budget, Asset venue, Asset musician, Asset caterer,
			Asset florist, Asset photographer) {
		super();
		this.wedding_id = wedding_id;
		this.wedding_date = wedding_date;
		this.wedding_budget = wedding_budget;
		this.venue = venue;
		this.musician = musician;
		this.caterer = caterer;
		this.florist = florist;
		this.photographer = photographer;
	}



	// gettters and setters
	public int getWedding_id() {
		return wedding_id;
	}


	public void setWedding_id(int wedding_id) {
		this.wedding_id = wedding_id;
	}


	public Date getWedding_date() {
		return wedding_date;
	}


	public void setWedding_date(Date wedding_date) {
		this.wedding_date = wedding_date;
	}


	public double getWedding_budget() {
		return wedding_budget;
	}


	public void setWedding_budget(double wedding_budget) {
		this.wedding_budget = wedding_budget;
	}


	public Asset getVenue() {
		return venue;
	}


	public void setVenue(Asset venue) {
		this.venue = venue;
	}


	public Asset getMusician() {
		return musician;
	}


	public void setMusician(Asset musician) {
		this.musician = musician;
	}


	public Asset getCaterer() {
		return caterer;
	}


	public void setCaterer(Asset caterer) {
		this.caterer = caterer;
	}


	public Asset getFlorist() {
		return florist;
	}


	public void setFlorist(Asset florist) {
		this.florist = florist;
	}


	public Asset getPhotographer() {
		return photographer;
	}


	public void setPhotographer(Asset photographer) {
		this.photographer = photographer;
	}
	
	
	
	
	
	// ORRRRR somehow, 
//	private Asset asset;
	
	
	
	
	
	
	

}
