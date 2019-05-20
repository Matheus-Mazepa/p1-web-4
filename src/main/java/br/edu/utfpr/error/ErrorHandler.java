package br.edu.utfpr.error;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error-handler")
public class ErrorHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");
        String error = null;

        if (statusCode != null){
            error = " "+ statusCode;
        }else{
            error = "Desconhecido";
        }



        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/view/error-pages/error-page.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
