package weddingDreams.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="asset_type")
public class AssetType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="asset_type_id", unique=true, nullable=false)
	private int asset_type_id;
	
	
	@Column(name="asset_type")
	private String asset_type;
	
	

	public int getAssetTypeId() {
		return asset_type_id;
	}

	public void setAsset_id(int asset_id) {
		this.asset_type_id = asset_id;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}
	
	// Overloaded constructors	
	
	public AssetType() {
		
	}
	
	
	
	public AssetType(int asset_type_id, String asset_type) {
		super();
		this.asset_type_id = asset_type_id;
		this.asset_type = asset_type;
	}

	// other methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + asset_type_id;
		result = prime * result + ((asset_type == null) ? 0 : asset_type.hashCode());
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
		AssetType other = (AssetType) obj;
		if (asset_type_id != other.asset_type_id)
			return false;
		if (asset_type == null) {
			if (other.asset_type != null)
				return false;
		} else if (!asset_type.equals(other.asset_type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetType [asset_id=" + asset_type_id + ", asset_type=" + asset_type + "]";
	}
	
	
	
	

}
