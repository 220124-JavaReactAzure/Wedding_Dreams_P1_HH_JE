package weddingDreams.models;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="user_id", unique = true, nullable = false)
	private int user_id;
	
	
	
//	private int user_type;
	
	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="username", unique = true, nullable = false)
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	
	
	
	// overloaded constructors
	public User() {
		
	}
	
	

	public User(int user_id, String email, String username, String password) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.username = username;
		this.password = password;
	}






	// getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	//other methods
	@Override
	public int hashCode() {
		return Objects.hash(email, password, user_id, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& user_id == other.user_id && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", username=" + username + ", password=" + password
				+ "]";
	}

	
	
	
	
	
	

	
	
	
	

}
