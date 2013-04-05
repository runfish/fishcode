/**
 * 
 */
package net.dfrz.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ctd
 * 系统编码过滤器
 */
public class CharacterEncodingFilter implements Filter {
	
	private String locale=null;

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			             FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest)request;
		
		//System.out.println(req.getRequestURI());  //URI=URL Universal Resource Identifier
		                                          //URL Universal Resource Location
		if(req.getRequestURI().endsWith("Mgr"))
		         request.setCharacterEncoding(locale);		
		
		chain.doFilter(request, response);
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 * cfg是一个引用变量指向了一个包含filter定义和配置信息的对象，
	 * 应用程序启动的时候，会自动去读取过滤器定义的XML文件，然后把其包装成一个实现了FilterConfig接口的对象。
	 */
	public void init(FilterConfig cfg) throws ServletException {

		 locale=cfg.getInitParameter("locale");
		 
		 System.out.println("Encoding Filter: get locale ->"+locale);
		
	}

}
