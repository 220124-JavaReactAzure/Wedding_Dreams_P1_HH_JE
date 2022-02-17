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
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id", unique=true, nullable=false)
	private int user_id;
	

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_type", unique = true, nullable = false, updatable = true)
	private UserType userType;

	
	@Column(name="email", unique = true, nullable = false)
	private String email;
	
	@Column(name="username", unique = true, nullable = false)
	private String username;
	
	@Column(name="password")
	private String password;
	
	
	
	// getters and setters

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
	
	// overloaded constructors
	
	public Users() {
		
	}
	

	public Users(int user_id, UserType userType, String email, String username, String password) {
		super();
		this.user_id = user_id;
		this.userType = userType;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	// other methods

	@Override
	public int hashCode() {
		return Objects.hash(email, password, userType, user_id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(userType, other.userType) && user_id == other.user_id
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", userType=" + userType + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
