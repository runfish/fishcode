package net.dfrz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.dao.CategoryDao;
import net.dfrz.dao.DaoFactory;
import net.dfrz.domain.Category;

public class CtgServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CtgServlet() {
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
        
		 String act=request.getParameter("act").trim();
		 
		 if("getSubCtgs".equals(act)){
			 
			 int ctgPid=Integer.parseInt(request.getParameter("ctgPid"));
			 CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("ctgDao");
			 
			 List<Category> subCtgs=ctgDao.getSubCtgs(ctgPid);
			 // ctg1-id:ctg1-name|ctg2-id:ctg2-name|......
			 
			 StringBuffer sb=new StringBuffer();
			 for(Category ctg:subCtgs){
				 sb.append(ctg.getCtgId()).append(":").append(ctg.getCtgName()).append("|");
			 }
			 if(sb.toString().length()>0) sb.deleteCharAt(sb.length()-1);
			 
			 System.out.println(sb.toString());
			 
			 response.setCharacterEncoding("utf-8");
			 PrintWriter out=response.getWriter();
			 out.write(sb.toString());
			 out.flush();
			 out.close();
			 
		 }else if("createCtg".equals(act)){
			 
			 int ctgPid=Integer.parseInt(request.getParameter("ctgpid"));
			 String ctgName=request.getParameter("ctgname");
			 String ctgLinkUrl=request.getParameter("ctglinkurl");
			 
			 Category ctg=new Category();
			 ctg.setCtgName(ctgName);
			 ctg.setLinkUrl(ctgLinkUrl);
			 ctg.setParentCtg(new Category(ctgPid));
			 
			 CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("ctgDao");
			 ctgDao.add(ctg);
			 
			 response.sendRedirect("add_ctg.jsp");			 
			 
		 }else if("loadall".equals(act)){
			 
			 CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("ctgDao");
			 List<Category> ctgs=ctgDao.loadall();
			 
			 request.setAttribute("ctgs", ctgs);
			 
			 request.getRequestDispatcher("show_tree.jsp").forward(request, response);
			 
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
