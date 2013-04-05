package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.services.AdministratorService;
import net.dfrz.supershop01.servicesimpl.AdministratorServiceImpl;

public class SecurityServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SecurityServlet() {
		super();
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
		String act=request.getParameter("act");
		
		if("gotoLogin".equals(act)){
			String cookieName="userName";
			Cookie[]cookies=request.getCookies();
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					if(c.getName().equals(cookieName))
					{
						request.setAttribute("username", c.getValue());
						break;
					}
				}
			}
			request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
		}
		else if("login".equals(act)){
       
			/**
			 * ��ȡ�û���Ϣ
			 */
			 
			String userName=request.getParameter("username");
			String userPwd=request.getParameter("userpwd");
			String imgCode=request.getParameter("imgcode");
			Integer isAdmin=Integer.parseInt(request.getParameter("isadmin"));
			String checkCode=(String)request.getSession().getAttribute("checkcode");
			/**
			 * �����һ�ܿͻ������һ��������û��ʺű������ͻ���Cookie
			 */
			Cookie[]cookies=request.getCookies();
			Boolean isSaved=false;
			if(cookies!=null)
			{
				for(Cookie c:cookies)
				{
					String user = URLDecoder.decode(c.getName(), "utf-8");
					if(c.getName().equals(userName))
					{
						isSaved=true;
						break;
					}
				}
			}
			if(!isSaved)
			{
				userName = URLEncoder.encode(userName, "utf-8");
				Cookie userNameCookie=new Cookie("userName",userName);
				userNameCookie.setMaxAge(7*24*60*60);
				response.addCookie(userNameCookie);
			}
			/**
			 * ����Ա����
			 */
			Administrator admin=null;  
			try 
			{
				if(imgCode.equalsIgnoreCase(checkCode))
				{
					AdministratorService adminService=new AdministratorServiceImpl();
					userName = URLDecoder.decode(userName, "utf-8");
					admin=adminService.getAdministratorByName(userName);
					if(!admin.getAdministratorPassword().equals(userPwd))
					{
						throw new DataAccessException("�ʺŻ������벻��ȷ����������!");
					}
					
					if(!admin.getIsSuperAdministrator())  
					{
						if(isAdmin==1)
						   throw new DataAccessException("���û����ǳ�������Ա������ѡ����뷽ʽ!");
					}
					else if(admin.getIsSuperAdministrator())
					{
						if(isAdmin==0)
						  throw new DataAccessException("���û�������ͨ����Ա������ѡ����뷽ʽ!");
					} 
				}
				else
				{
					throw new DataAccessException("��֤����Ϣ�������������룡");
				}
				
				
			} catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/jsps/login.jsp").forward(request, response);
				return;
			}
			request.getSession().setAttribute("admin",admin);
			request.getSession().setAttribute("isadmin", isAdmin);
			
			request.getRequestDispatcher("/jsps/main/main_super.jsp").forward(request, response);
		}
		else if("getSystemDate".equals(act))
		{
			Date date=new Date();
			String timeString=(date.getYear()+1900)+":"+(date.getMonth()+1)+":"+date.getDate()+":"+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			//System.out.println(timeString);
			PrintWriter pw=response.getWriter();
			pw.write(timeString);
			pw.flush();
			pw.close();
		}
		else if("logOut".equals(act)){
			request.getSession().removeAttribute("admin");
			request.getSession().removeAttribute("isadmin");
			request.getSession().invalidate();
			response.sendRedirect("/shop02/action/securityMgr?act=gotoLogin");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		

	}

}