package br.edu.utfpr.util;

import br.edu.utfpr.model.Department;
import br.edu.utfpr.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateDB {

    private static CreateDB instance;

    public CreateDB() {
        createDB();
    }

    public void createDB(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();

        Department dpManutencao = new Department("Manutenção");
        Department dpFinanceiro = new Department("Financeiro");
        Department dpTi = new Department("TI");
        em.getTransaction().begin();
        em.persist(dpManutencao);
        em.persist(dpFinanceiro);
        em.persist(dpTi);
        em.persist(new User("admin","admin","admin", "admin"));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static synchronized CreateDB getInstance(){
        if (instance == null){
            instance = new CreateDB();
        }
        return instance;
    }
}
