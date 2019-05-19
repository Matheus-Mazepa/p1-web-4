package br.edu.utfpr.controller;

import br.edu.utfpr.model.Department;
import br.edu.utfpr.model.Employee;
import br.edu.utfpr.model.Order;
import br.edu.utfpr.model.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {
        "/u/ordem/criar",
        "/m/set-as-done"
})
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
        if (request.getServletPath().contains("set-as-done")) {
            int idOrder = Integer.parseInt(request.getParameter("id"));
            Order order = Order.find(idOrder);
            order.setDone(true);
            order.save();
            response.sendRedirect("/m/manutencao");
        } else {
            String description = request.getParameter("description");
            String electronicSignature = request.getParameter("electronic_signature");

            String userName = request.getUserPrincipal().getName();
            User user = User.findByUserName(userName);
            boolean hasElectronicSignatureSession = request.getSession().getAttribute("electronicSignature") != null;
            if (user.verifyElectronicSignature(electronicSignature) || hasElectronicSignatureSession) {
                if (!hasElectronicSignatureSession) {
                    request.getSession().setAttribute("electronicSignature", electronicSignature);
                }
                Order order = new Order(description, user.getEmployee());
                order.save();

                response.sendRedirect("/u/ordem/criar?ceateSuccessful");
            }else
                response.sendRedirect("/u/ordem/criar?errorElectronicSignature");
        }

    }



}
