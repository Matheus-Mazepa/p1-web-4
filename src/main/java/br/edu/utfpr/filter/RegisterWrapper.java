package br.edu.utfpr.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class RegisterWrapper extends HttpServletRequestWrapper {

    public RegisterWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (parameter.equals("first-name")) {
            return value + " " + super.getParameter("last-name");
        }
        return value;
    }
}