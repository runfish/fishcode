package net.dfrz.supershop01.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.s;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;



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
		
		String act = null;
		
		act = request.getParameter("act").trim();
		if(act.equals("input")){
		
			List<Category>bigCtgList=null;
			try 
			{
				CategoryService categoryService=new CategoryServiceImpl();
				bigCtgList=categoryService.loadAll();
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			request.setAttribute("bigctglist", bigCtgList);
			request.getRequestDispatcher("/jsps/category/input_ctg.jsp").forward(request, response);
		}
		else if("getSubCtgs".equals(act)){
			 int ctgId=Integer.parseInt(request.getParameter("ctgId"));
			 CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
			 List<Category> subCtgs=ctgDao.getSubCtgs(ctgId);
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
		 }
		else if("create".equals(act)){
		
			String smallCtgName=request.getParameter("smallctgname");
			String goodsBigCtgId = request.getParameter("goodsbigctgid");
			Category bigCategory = new Category();
			bigCategory.setCtgId(Integer.parseInt(goodsBigCtgId ));
			bigCategory.setCtgStatus("1");
			
			SmallCategory smallCategory = new SmallCategory();
			smallCategory.setBigCategory(bigCategory);
			smallCategory.setSmallCtgName(smallCtgName);
			smallCategory.setSmallCtgStatus("1");
			
			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
			try{
				
			smallCategoryService.addSmallCtg(smallCategory);
			response.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");
			
			}catch(ApplicationException e){
				CategoryService categoryService=new CategoryServiceImpl();
				
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/action/categoryMgr?act=input").forward(request, response);
			}
		}
		else if("loadall".equals(act)){
		
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
		else if(act.equals("loadPageAll")){
			
			Integer pageNo=null;
			
			if(request.getParameter("pageNo")!=null)
			{
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
			}
			
			Page page=new Page();
			if(pageNo!=null) page.setPageNo(pageNo);
			
			try 
			{
				SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
				page=smallCategoryService.loadPage(page);
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			request.setAttribute("pagedCategory",page);
			
			request.getRequestDispatcher("/jsps/category/list_ctg.jsp").forward(request, response);
			
		}
		else if(act.equals("delete")){
			
			int smallCtgId=Integer.parseInt(request.getParameter("smallctgid"));
			SmallCategoryService smallCategoryService = new SmallCategoryServiceImpl();
			try{
				smallCategoryService.deleteSmallCtg(smallCtgId);
			}catch (ApplicationException e) {
				// TODO: handle exception
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("/jsps/ctaegory/list_ctg.jsp").forward(request, response);
				return ;
			}
			response.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");
		}
		else if(act.equals("forUpdate")){
			int smallCtgId=Integer.parseInt(request.getParameter("smallctgid"));
			List<Category>bigCtgList=null;
			SmallCategory smallCategory = null;
		
			try {
				SmallCategoryService ctgService=new SmallCategoryServiceImpl();
				CategoryService categoryService=new CategoryServiceImpl();
				bigCtgList=categoryService.loadAll();
				smallCategory = ctgService.getCtg(smallCtgId);
				request.setAttribute("smallcategory",smallCategory);
				request.setAttribute("bigctglist", bigCtgList);
				request.getRequestDispatcher("/jsps/category/update_ctg.jsp").forward(request, response);
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		else if("update".equals(act)){
			

			int smallCtgId=Integer.parseInt(request.getParameter("goodssmallctgid"));
			int bigCtgId = Integer.parseInt(request.getParameter("goodsbigctgid"));;

			String smallCtgName=request.getParameter("smallctgname");
			
			try {
				SmallCategoryService samllCtgService=new SmallCategoryServiceImpl();
				SmallCategory sctg=samllCtgService.getCtg(smallCtgId);
				sctg.setSmallCtgId(smallCtgId);
				sctg.setSmallCtgName(smallCtgName);
				sctg.getBigCategory().setCtgId(bigCtgId);
				samllCtgService.modifyCtg(sctg);
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			response.sendRedirect("/shop02/action/categoryMgr?act=loadPageAll");
			
	
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
