package br.edu.utfpr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/entrar" })
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String address = ((HttpServletRequest) request).getServletPath();

		HttpServletRequest req = (HttpServletRequest) request;

		if (req.getUserPrincipal() == null) {
			chain.doFilter(request, response);
		} else {
			if (req.isUserInRole("admin")) {
				address = "/a/registrar";
				((HttpServletResponse) response).sendRedirect(address);
			} else if (req.isUserInRole("user")) {
				address = "/u/ordem";
				((HttpServletResponse) response).sendRedirect(address);
			} else {
				address = "/m/manutencao";
				((HttpServletResponse) response).sendRedirect(address);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
