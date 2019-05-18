package br.edu.utfpr.controller;

import br.edu.utfpr.model.Department;
import br.edu.utfpr.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/m/manutencao")
public class MaintenanceController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orders = (ArrayList<Order>) Order.findAll();

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("/WEB-INF/view/orders-list.jsp")
                .forward(request,response);
    }

}
