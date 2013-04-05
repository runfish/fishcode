package com.action.servletobj;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ActionServlet_1 extends ActionSupport{

	public String execute()throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		ServletContext servletContext=ServletActionContext.getServletContext();
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		System.out.println(request);
		System.out.println(session);
		
		return null;
	}
}
