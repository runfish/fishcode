package com.action.servletobj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class ActionServlet_2 extends ActionSupport implements ServletRequestAware
           ,ServletResponseAware,ServletContextAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private PrintWriter out;
	private ServletContext servletContext;
	
	public String execute()throws Exception{

		System.out.println(this.request);

		System.out.println(this.response);
		
		System.out.println(session.getId());
		
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println(request);
		
		this.request = request;
		if(this.session!=null){
			this.session = request.getSession();
		}
		
		
	}

	@Override
	public void setServletResponse(HttpServletResponse httpservletresponse) {
		// TODO Auto-generated method stub
		this.response = httpservletresponse;
		
		if(this.response!=null){
			
			try {
				this.out = this.response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void setServletContext(ServletContext servletcontext) {
		// TODO Auto-generated method stub
		this.servletContext = servletcontext;
		
	}
}
