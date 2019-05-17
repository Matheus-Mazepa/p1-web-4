package br.edu.utfpr.model;

import br.edu.utfpr.util.BCrypt;
import br.edu.utfpr.util.Sha256Generator;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "electronic_signature")
    private String electronicSignature;

    @OneToOne(mappedBy="user")
    private Employee employee;

    public User() {
    }

    public User(String userName, String password, String roleName, String electronicSignature) {
        this.userName = userName;
        this.setPassword(password);
        this.roleName = roleName;
        this.setElectronicSignature(electronicSignature);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        this.password = Sha256Generator.generate(password);
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getElectronicSignature() {
        return electronicSignature;
    }

    public void setElectronicSignature(String electronicSignature) {
        this.electronicSignature = BCrypt.hashpw(electronicSignature, BCrypt.gensalt(12));
    }

    public boolean verifyElectronicSignature(String electronicSignature) {
        return BCrypt.checkpw(electronicSignature, this.getElectronicSignature());
    }

    //	public  void save() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		em.persist(this);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
//	}
//

    public void update(int id, User newData) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, id);
        if (user != null) {
            em.getTransaction().begin();
            user.setPassword(newData.getPassword());
            em.getTransaction().commit();
        }

        em.close();
        emf.close();
    }

    public static User find(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, id);
        return user;
    }

    public static User findByUserName(String userName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT DISTINCT u FROM User u "
                + " WHERE u.userName = :userN");
        q.setParameter("userN", userName);
        List<User> users = q.getResultList();

        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
