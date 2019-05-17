package br.edu.utfpr.controller;

import br.edu.utfpr.model.Department;
import br.edu.utfpr.model.Employee;
import br.edu.utfpr.model.User;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registrar")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Department> departaments = (ArrayList<Department>) Department.getAllDepartments();

        request.setAttribute("departments", departaments);

    	request.getRequestDispatcher("/WEB-INF/view/register.jsp")
		.forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String departamento = request.getParameter("departament");
        String userName = request.getParameter("user_name");
		String pwd = request.getParameter("password");

		if(pwd.equals(request.getParameter("password-confirmation"))){
            Employee newEmployee = new Employee(name,
                    cpf,
                    new User(userName, pwd, "user", pwd),
                    Department.find(Integer.parseInt(departamento)));
            newEmployee.save();
            response.sendRedirect("entrar");
        }
	}

}
