package br.edu.utfpr.controller;

import br.edu.utfpr.model.Order;
import br.edu.utfpr.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/u/ordem")
public class UserOrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("currentUser");
        ArrayList<Order> orders = (ArrayList<Order>) Order.findAllByUserId(user.getId());

        request.setAttribute("user_orders", orders);

        request.getRequestDispatcher("/WEB-INF/view/user-orders.jsp")
                .forward(request,response);
    }
}
