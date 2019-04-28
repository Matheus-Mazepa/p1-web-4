package br.edu.utfpr.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	public Contact() {
		
	}

	public Contact(int id, User user, String contactName, String phoneNumber, String email) {
		super();
		this.id = id;
		this.user = user;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", user=" + user + ", contactName=" + contactName + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}

	public void save() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(this);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	public void update(int id, Contact newData) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Contact contact = em.find(Contact.class, id);
		if(contact != null) {
			em.getTransaction().begin();
			contact.setContactName(newData.getContactName());
			contact.setEmail(newData.getEmail());
			contact.setPhoneNumber(newData.getPhoneNumber());
			em.getTransaction().commit();
		}
		
		em.close();
		emf.close();
	}
	
	public void delete(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Contact contact = em.find(Contact.class, id);
		em.getTransaction().begin();
		em.remove(contact);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

	public void findAll(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery("SELECT DISTINCT c FROM Contact c "
				+ " WHERE c.user.id = :userID" );
		q.setParameter("userID", id);
		List<Contact> contacts = q.getResultList();
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}
	


}
