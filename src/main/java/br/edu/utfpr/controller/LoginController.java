package br.edu.utfpr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.utfpr.model.User;
import br.edu.utfpr.util.CreateDB;

/**
 * Servlet implementation class LoginController
 */
@WebServlet({"/entrar",""})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
		CreateDB.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	request.getRequestDispatcher("/WEB-INF/view/login.jsp")
		.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String pwd = request.getParameter("password");
		try {
			request.login(userName, pwd);

			response.sendRedirect("registrar");
		}
		catch (Exception exception) {
			response.sendRedirect("entrar?error");
		}
	}

}
