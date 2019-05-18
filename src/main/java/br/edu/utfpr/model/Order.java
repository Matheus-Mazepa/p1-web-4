package br.edu.utfpr.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private boolean done;

    @ManyToOne
    private Employee employee;

    public Order() {
    }

    public Order(String description, Employee employee) {
        this.description = description;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
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

    public void update(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Order order = Order.find(this.id);
        if(order != null){
            em.getTransaction().begin();
            order.setDone(true);
            em.getTransaction().commit();
        }

        em.close();
        emf.close();

    }

    public static List<Order> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT DISTINCT o FROM Order o ");
        List<Order> orders = q.getResultList();

        return orders;
    }


    public static Order find(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();
        Order order = em.find(Order.class, id);

        return order;
    }

}
