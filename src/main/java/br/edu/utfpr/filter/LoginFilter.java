package br.edu.utfpr.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filtro responsável por apresentar a tela de login quando
 * o usuário não está logado ou a tela inicial do perfil quando
 * o usuário está logado.
 * 
 * As telas são apresentadas ao acessar o path raiz.
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/entrar" })
public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String address = ((HttpServletRequest) request).getServletPath();

		HttpServletRequest req = (HttpServletRequest) request;

		//caso não esteja logado, vai para a tela de login
		if (req.getUserPrincipal() == null) {
			chain.doFilter(request, response);
		} else {
			//redireciona de acordo com o perfil do usuário
			if (req.isUserInRole("admin")) {
				address = "a";
				((HttpServletResponse) response).sendRedirect(address);
			} else if (req.isUserInRole("user")) {
				address = "u";
				((HttpServletResponse) response).sendRedirect(address);
			} else {
				address = "m";
				((HttpServletResponse) response).sendRedirect(address);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
