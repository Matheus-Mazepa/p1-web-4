package br.edu.utfpr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.utfpr.model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/entrar")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
		.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String pwd = request.getParameter("password");
		if (User.verifyPassword(userName, pwd)) {
			User user = User.findByUserName(userName);
			request.getSession().setAttribute("currentUser", user);
			
			request.getRequestDispatcher("/WEB-INF/view/login.jsp")
			.forward(request, response);
		}
		request.getRequestDispatcher("/WEB-INF/view/login.jsp")
		.forward(request, response);	
	}

}
