package br.edu.utfpr.controller;

import br.edu.utfpr.model.Order;
import br.edu.utfpr.model.bean.OrderBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/m/ordem/show")
public class ShowOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = Order.find(orderId);

        OrderBean orderBean = new OrderBean();
        orderBean.setId(orderId);
        orderBean.setDescription(order.getDescription());
        orderBean.setEmployeeName(order.getEmployee().getName());
        orderBean.setDepartmentName(order.getEmployee().getDepartment().getName());


        request.setAttribute("order", orderBean);
        if (getServletContext().getAttribute("views_order_" + orderId) != null) {
            int viewsOrder = (Integer) getServletContext().getAttribute("views_order_" + orderId);
            viewsOrder++;
            getServletContext().setAttribute("views_order_" + orderId, viewsOrder);
        } else {
            getServletContext().setAttribute("views_order_" + orderId, 1);
        }
        request.getRequestDispatcher("/WEB-INF/view/order-info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
