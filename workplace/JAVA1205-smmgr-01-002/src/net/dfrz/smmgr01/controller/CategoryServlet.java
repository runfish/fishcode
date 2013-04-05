package net.dfrz.smmgr01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.smmgr01.domain.Category;
import net.dfrz.smmgr01.exception.ApplicationException;
import net.dfrz.smmgr01.services.CategoryService;
import net.dfrz.smmgr01.services.CategoryServiceImpl;
import net.dfrz.smmgr01.services.GoodsService;
import net.dfrz.smmgr01.services.GoodsServiceImpl;
import net.dfrz.smmgr01.utils.Page;

/**
 * 
 * @author YDP
 *
 */
public class CategoryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CategoryServlet() {
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
		//进入输入商品类别界面
		if(act.equals("input")){
			request.getRequestDispatcher("jsps/category/input_ctg.jsp").forward(request, response);
		}
		
		//增加一个新的商品类别进数据库然后转到所有类别列表界面
		else if("create".equals(act)){
			
			String categoryName=request.getParameter("ctgname");
			
			Category ctg = new Category();
			ctg.setCtgName(categoryName);
			CategoryService ctgService = new CategoryServiceImpl();
			try{
				
			ctgService.addCtg(ctg);
			
			}catch(ApplicationException e){
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/jsps/category/input_ctg.jsp").forward(request, response);
			    return;
			}
			response.sendRedirect("categoryMgr?act=loadall");
		}
		//把数据库中的所有类别全部显示到界面上
		else if("loadall".equals(act)){
			//CategoryService ctgService = new CategoryServiceImpl();
			//request.setAttribute("ctgList", ctgService.loadAll());
			//request.getRequestDispatcher("/jsps/category/list_ctg.jsp").forward(request, response);
			Integer pageNo=null;
			
			if(request.getParameter("pageNo")!=null){
			   pageNo=Integer.parseInt(request.getParameter("pageNo"));	
			}
			
			Page page=new Page();
			if(pageNo!=null)  page.setPageNo(pageNo);
			
			CategoryService categoryService=new CategoryServiceImpl();
			page=categoryService.loadPageAll(page);
			
			request.setAttribute("pagedCategory", page);
			
			request.getRequestDispatcher("/jsps/category/list_ctg.jsp").forward(request, response);
		}
		
		//删除指定的商品类别
		else if("delete".equals(act)){
			int ctgId=Integer.parseInt(request.getParameter("ctgid"));
			Category ctg = new Category();
			ctg.setCtgId(ctgId);
			
			CategoryService ctgService = new CategoryServiceImpl();
			ctgService.deleteCtg(ctg);
			
			response.sendRedirect("categoryMgr?act=loadall");
			}
		//要实现类别的更新操作先从数据库中查找出要更新的类别记录显示到更新界面上
		else if("forUpdate".equals(act)){
			int ctgId=Integer.parseInt(request.getParameter("ctgid"));
			CategoryService ctgService = new CategoryServiceImpl();
			request.setAttribute("category", ctgService.getCategoryById(ctgId));
			request.getRequestDispatcher("/jsps/category/update_ctg.jsp").forward(request, response);
		}
		//实现对数据库中类别的更新操作
		else if("update".equals(act)){
			int ctgId=Integer.parseInt(request.getParameter("ctgid"));
			String ctgName=request.getParameter("ctgname");
			
			
			Category ctg = new Category();
			ctg.setCtgId(ctgId);
			ctg.setCtgName(ctgName);
			
			
			CategoryService ctgService = new CategoryServiceImpl();
			ctgService.updateCtg(ctg);
			
			response.sendRedirect("categoryMgr?act=loadall");
			
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
        doGet(request, response);
	}

}
