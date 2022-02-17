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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="asset")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "asset_id")
public class Asset {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private int asset_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="price")
	private double price;
	
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "asset_type_id", unique = true, nullable = false, updatable = true)
	private AssetType assetType;
	
	
	// no arg constructor for instances where we may want to create the object without assigning specific values
	public Asset() {
		
	}	
	
	
	// this is so that the result of get(String entityName, Serializable id) will return the persistent instance and then store 
	// it in an Asset object
	public Asset(int asset_id, String email, String company_name, String phone, double price, AssetType assetType) {
		super();
		this.asset_id = asset_id;
		this.email = email;
		this.company_name = company_name;
		this.phone = phone;
		this.price = price;
		this.assetType = assetType;
	}




	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetType == null) ? 0 : assetType.hashCode());
		result = prime * result + asset_id;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Asset other = (Asset) obj;
		if (assetType == null) {
			if (other.assetType != null)
				return false;
		} else if (!assetType.equals(other.assetType))
			return false;
		if (asset_id != other.asset_id)
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Asset [asset_id=" + asset_id + ", email=" + email + ", company_name=" + company_name + ", phone="
				+ phone + ", price=" + price + ", assetType=" + assetType + "]";
	}

	
	
	
	
	
	
	

}
