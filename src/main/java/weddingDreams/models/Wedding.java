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
	
	@Column(name="wedding_date")
	private Date wedding_date;
	
	@Column(name="wedding_price")
	private double wedding_price;
	
	
	// how do I represent venue_id, musician_id, caterer_id, florist_id, and photographer_id. 
	//DO i create columns for each one? and do i need to 
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = true, nullable = false, updatable = true)
	private Asset venue;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = true, nullable = false, updatable = true)
	private Asset musician;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = true, nullable = false, updatable = true)
	private Asset caterer;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = true, nullable = false, updatable = true)
	private Asset florist;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_id", unique = true, nullable = false, updatable = true)
	private Asset photographer;
	
	
	
	
	
	// ORRRRR somehow, 
//	private Asset asset;
	
	
	

}
