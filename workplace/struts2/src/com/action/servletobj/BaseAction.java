package com.action.servletobj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements ServletRequestAware
,ServletResponseAware,ServletContextAware {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected PrintWriter out;
	protected ServletContext servletContext;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		this.request = request;
		if(this.request.getSession()!=null){
			this.session = request.getSession();
		}
		
		
	}

	@Override
	public void setServletResponse(HttpServletResponse httpservletresponse) {
		// TODO Auto-generated method stub
		this.response = httpservletresponse;
		this.response.setCharacterEncoding("utf-8");
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
	
	public abstract String execute()throws Exception;

}