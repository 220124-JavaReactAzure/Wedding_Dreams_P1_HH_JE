package weddingDreams.models;

public class AssetType {
	
	private int asset_id;
	
	private String asset_type;

	public int getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + asset_id;
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
		if (asset_id != other.asset_id)
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
		return "AssetType [asset_id=" + asset_id + ", asset_type=" + asset_type + "]";
	}
	
	
	
	

}
