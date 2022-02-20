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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="assets")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "asset_id")
public class Asset {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "asset_id", unique=true, nullable=false)
	private int asset_id;
	
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name="address")
	private String address;

	
	@Column(name="price")
	private double price;
	
	// will it automatically create a new column?? or do i need an @Column annotation?
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_type_id", referencedColumnName="asset_type_id", unique = true, nullable = false, updatable = true)
	private AssetType assetType;
	
	
	// no arg constructor for instances where we may want to create the object without assigning specific values
	public Asset() {
		
	}


	public Asset(int asset_id, String company_name, String address, double price, AssetType assetType) {
		super();
		this.asset_id = asset_id;
		this.company_name = company_name;
		this.address = address;
		this.price = price;
		this.assetType = assetType;
	}


	
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}





	public int getAsset_id() {
		return asset_id;
	}


	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public AssetType getAssetType() {
		return assetType;
	}


	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}





	@Override
	public int hashCode() {
		return Objects.hash(address, assetType, asset_id, company_name, price);
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		return Objects.equals(address, other.address) && Objects.equals(assetType, other.assetType)
				&& asset_id == other.asset_id && Objects.equals(company_name, other.company_name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}





	@Override
	public String toString() {
		return "Asset [asset_id=" + asset_id + ", company_name=" + company_name + ", address=" + address + ", price="
				+ price + ", assetType=" + assetType + "]";
	}


	

}