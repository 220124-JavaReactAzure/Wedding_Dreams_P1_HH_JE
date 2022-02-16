package weddingDreams.models;

public class Betrothed {
	
	Wedding wedding;
	User user;
	
	
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Betrothed other = (Betrothed) obj;
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
		return "Betrothed [wedding=" + wedding + ", user=" + user + "]";
	}
	
	

}
