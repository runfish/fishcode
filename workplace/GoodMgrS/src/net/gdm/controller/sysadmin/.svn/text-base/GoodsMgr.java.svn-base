package net.gdm.controller.sysadmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gdm.dao.AdmineDao;
import net.gdm.dao.AdmineDaoImpl;
import net.gdm.dao.BigCategoryDao;
import net.gdm.dao.BigCategoryDaoImpl;
import net.gdm.demo.Admine;
import net.gdm.demo.BigCategory;

public class GoodsMgr extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoodsMgr() {
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

		 String act=request.getParameter("act");
		 System.out.print(act);
		 if("addadmine".equals(act))
		 {
			 request.getRequestDispatcher("jsps/dore/admine/add_admine.jsp").forward(request, response);
		 }
		 
		 if("listadmine".equals(act))
		 {
			 AdmineDao adminedao=new AdmineDaoImpl();
			 List<Admine> listadmine=adminedao.ListAdmine();
			 request.setAttribute("listadmine", listadmine);
			 request.getRequestDispatcher("jsps/dore/admine/list_admine.jsp").forward(request, response);
		 }
		 
		 if("categorymanage".equals(act))
		 {
			 BigCategoryDao bigdao=new BigCategoryDaoImpl();
			 List<BigCategory> biglist=bigdao.listbig();
			 request.setAttribute("biglist", biglist);		 
			 request.getRequestDispatcher("jsps/dore/category/list_.jsp").forward(request, response); 
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
