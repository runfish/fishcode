package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.services.AdministratorService;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;

public class AdministratorServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AdministratorServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String act = request.getParameter("act");
		
        if("input".equals(act)){
				
			request.getRequestDispatcher("/jsps/administrator/add_administrator.jsp").forward(request, response);
        }
		else if("create".equals(act)){
			
			String administratorName=request.getParameter("administratorname");
			String administratorPassword =request.getParameter("administratorpassword");
			String realName=request.getParameter("administratorrealname");
			String birthday=request.getParameter("administratorbirthday");
			String telNum=request.getParameter("administratortelnum");
			String address=request.getParameter("administratoraddress");
			String email=request.getParameter("administratoremail");
			String postCode=request.getParameter("administratorpostcode");
			String isSuperAdmin=request.getParameter("superadminid");
			Boolean isSuperAdministrator=false;
			 if(isSuperAdministrator.equals(true)){
				 isSuperAdministrator=true;
			 }
			
			Administrator administrator =new Administrator();
			
			administrator.setAdministratorName(administratorName);
			administrator.setAdministratorPassword(administratorPassword);
			administrator.setRealName(realName);
			administrator.setBirthday(birthday);
			administrator.setTelNum(telNum);
			administrator.setAddress(address);
			administrator.setEmail(email);
			administrator.setPostCode(postCode);
			administrator.setSuperAdministrator(isSuperAdministrator);
		
			AdministratorService administratorService= new AdministratorServiceImpl();
			administrator.setAdministratorId(administratorService.getMax()+1);
			administratorService.save(administrator);
			
			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}
		
		else if("loadall".equals(act)){                              
				AdministratorService service = new AdministratorServiceImpl();
				request.setAttribute("administratorList",service.loadAll());
				
				request.getRequestDispatcher("/jsps/administrator/list_administrator.jsp").forward(request, response);
		}
        
		else if(act.equals("forUpdate")){                               //分店管理中的更新界面
			int administratorId=Integer.parseInt(request.getParameter("administratorid"));
			
			AdministratorService service = new AdministratorServiceImpl();
			
			request.setAttribute("administrator",service.getAdministratorById(administratorId));
			
			request.getRequestDispatcher("/jsps/administrator/update_administrator.jsp").forward(request, response);
		}
        
		else if("update".equals(act)){
			
			int administratorId=Integer.parseInt(request.getParameter("administratorid"));
			String administratorName=request.getParameter("administratorname");
			String administratorPassword =request.getParameter("administratorpassword");
			String realName=request.getParameter("administratorrealname");
			String birthday=request.getParameter("administratorbirthday");
			String telNum=request.getParameter("administratortelnum");
			String address=request.getParameter("administratoraddress");
			String email=request.getParameter("administratoremail");
			String postCode=request.getParameter("administratorpostcode");
			String isSuperAdmin=request.getParameter("superadminid");
			Boolean isSuperAdministrator=false;
			 if(isSuperAdministrator.equals(true)){
				 isSuperAdministrator=true;
			 }
			
			AdministratorService administratorService= new AdministratorServiceImpl();	
			Administrator administrator=new Administrator();
			    administrator.setAdministratorId(administratorId);
				administrator.setAdministratorName(administratorName);
				administrator.setAdministratorPassword(administratorPassword);
				administrator.setRealName(realName);
				administrator.setBirthday(birthday);
				administrator.setTelNum(telNum);
				administrator.setAddress(address);
				administrator.setEmail(email);
				administrator.setPostCode(postCode);
				administrator.setSuperAdministrator(isSuperAdministrator);
				
				administratorService.update(administrator);		
			response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}

		else if("delete".equals(act)){
			int administratorId=Integer.parseInt(request.getParameter("administratorid"));
			
			  AdministratorService service = new AdministratorServiceImpl();
			  
			    service.delete(administratorId);
			    response.sendRedirect("/shop02/action/adminMgr?act=loadall");
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}



}
