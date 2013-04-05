package net.dfrz.supershop01.utils;

/**
 * 
 */

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
 * @author J1205-HongHG
 *
 */
public class RightFilter implements Filter {
	
	/**
	 * 登入界面
	 */
	private String security=null;
	/**
	 * 验证码界面
	 */
	private String code=null;
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		
		String reqUri=req.getRequestURI(); //请求访问的WEB资源
		
		String webSource=reqUri.substring(reqUri.lastIndexOf("/")+1);
		
		if(!(webSource.equals(security)||webSource.equals(code))){
			
		   if(req.getSession().getAttribute("admin")==null) //没有登录	
		   {
			   resp.sendRedirect("/shop02/action/securityMgr?act=gotoLogin");
			   return;
		   }
		}
				
		chain.doFilter(request, response);

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		security=filterConfig.getInitParameter("security");
		code=filterConfig.getInitParameter("code");
       
	}
}
