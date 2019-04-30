package br.edu.utfpr.model;

import br.edu.utfpr.util.BCrypt;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
		
	public User() {
		
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
	
	
	public  void save() {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(this);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	
	public void update(int id, User newData) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, id);
		if(user != null) {
			em.getTransaction().begin();
			user.setName(newData.getName());
			user.setPassword(newData.getPassword());
			em.getTransaction().commit();
		}

		em.close();
		emf.close();
	}
	
	public static boolean verifyPassword(String userName, String password) {
		User user = User.findByUserName(userName);
	
		if (user != null) {
			return BCrypt.checkpw(password, user.getPassword());
		}
		return false;
	}
	
	public static User findByUserName(String userName) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT DISTINCT u FROM User u "
				+ " WHERE u.userName = :userN" );
		q.setParameter("userN", userName);
		List<User> users = q.getResultList();
		
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
}
