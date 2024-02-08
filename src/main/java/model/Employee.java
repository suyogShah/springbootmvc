package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id 
	@GeneratedValue
	private  long id;
	
	private String name;
	private String role;
	
	
	public long getId() {
		return id;
	}
	public Employee(long id, String name, String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
