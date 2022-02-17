package weddingDreams.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// this line right below may have to be deleted??
	@Column(name = "employee_id", unique = true, nullable = false)
	private int employee_id;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "user_id", unique = true, nullable = false, updatable = true)
	private User user;

	
	
	
	// overloaded constructors
	public Employee() {

	}

	public Employee(int employee_id, User user) {
		super();
		this.employee_id = employee_id;
		this.user = user;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee_id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employee_id == other.employee_id && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", user=" + user + "]";
	}

}
