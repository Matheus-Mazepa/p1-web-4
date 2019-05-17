package br.edu.utfpr.controller;

import br.edu.utfpr.model.Department;
import br.edu.utfpr.model.Employee;
import br.edu.utfpr.model.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/a/ordem/criar")
public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public OrderController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/order.jsp")
                .forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("description");

        response.sendRedirect("/a/ordem/criar");
    }

}
