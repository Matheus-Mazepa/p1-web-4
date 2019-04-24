package br.edu.utfpr;

import java.io.IOException;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriarBDServlet
 */
@WebServlet("/criar")
public class CriarBDServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CriarBDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        criarBD();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        criarBD();
    }

    private void criarBD() {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("agenda");
        EntityManager em = emf.createEntityManager();
        emf.close();
    }
}
