/**
 * 
 */
package net.gdm.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * 
 */
public class AuthenticationFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// index.jsp, login.jsp,security

		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hrep = (HttpServletResponse) response;

		String fileName = hreq.getRequestURI().substring(
				hreq.getRequestURI().lastIndexOf("/") + 1);

		if (fileName.indexOf(".gif") != -1 || fileName.indexOf(".jpg") != -1
				|| fileName.indexOf(".css") != -1
				|| fileName.indexOf("index.jsp") != -1
				|| fileName.indexOf("login.jsp") != -1
				|| fileName.indexOf("security") != -1) {
			// System.out.println("pass!");
			chain.doFilter(request, response);
		} else {

			HttpSession session = hreq.getSession();

			if (session.getAttribute("logineduser") == null) {

				if (fileName.indexOf("fusermgr") >= 0
						|| fileName.indexOf("forderitemmgr") >= 0
						|| fileName.indexOf("fordermgr") >= 0) {

					session.setAttribute("preurl", request.getParameter(
							"preurl").replace("!", "&"));
					

					hrep.sendRedirect("fsecuritymgr?act=tologin");
					return;
				}

			} else {
				chain.doFilter(request, response);
			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
