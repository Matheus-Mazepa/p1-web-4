package br.edu.utfpr.util;

import br.edu.utfpr.model.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateDB {

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

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
