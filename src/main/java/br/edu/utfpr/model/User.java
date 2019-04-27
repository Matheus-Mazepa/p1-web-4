package br.edu.utfpr.model;

import br.edu.utfpr.util.BCrypt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name= "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	public User() {}
	
	public User(int id, String name, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.setPassword(password);
	}

	public User(String name, String userName, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		this.password = passwordHash;
	}
	
	

}
