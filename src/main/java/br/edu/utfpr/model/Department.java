package br.edu.utfpr.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
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

    public static List<Department> getAllDepartments(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT d FROM Department d");
        List<Department> departments = query.getResultList();

        return departments;
    }

    public static Department findDep(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Department department = em.find(Department.class, id);
        return department;
    }
}
