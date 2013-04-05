package net.dfrz.supershop01.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.utils.Page;

import org.apache.commons.lang3.StringUtils;

public class GoodsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoodsServlet() {
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
		String act = request.getParameter("act");
		
		if("showgoods".equals(act)){
			Integer pageNo=null;
			GoodsQueryHelper helper=new GoodsQueryHelper();
			CategoryService ctgService=new CategoryServiceImpl();
			List<Category>ctgList=ctgService.loadAll();
			
			if(StringUtils.isNotEmpty(request.getParameter("qurygoodsname")))
			{
				helper.setGoodsName(request.getParameter("qurygoodsname"));
			}
			if(StringUtils.isNotEmpty(request.getParameter("qurygoodsctgid")))
			{
				helper.setGoodsCtgId(Integer.parseInt(request.getParameter("qurygoodsctgid")));
			}
			String minPrice = request.getParameter("qurymingoodsprice");
			String maxPrice = request.getParameter("qurymaxgoodsprice");
			if(StringUtils.isNotEmpty(minPrice)){
				helper.setMinGoodsPrice(Double.parseDouble(minPrice));
			}
			if(StringUtils.isNotEmpty(maxPrice)){
				helper.setMaxGoodsPrice(Double.parseDouble(maxPrice));
			}
			if(StringUtils.isNotEmpty(request.getParameter("qurygoodsempty"))){
				helper.setGoodsIsEmpty(request.getParameter("qurygoodsempty"));
			}
			
			if(request.getParameter("pageNo")!=null){
			   pageNo=Integer.parseInt(request.getParameter("pageNo"));	
			}
			
			Page page=new Page();
			if(pageNo!=null)  page.setPageNo(pageNo);
			
			GoodsService goodService=new GoodsServiceImpl();
			//AdministratorService administratorService = new AdministratorServiceImpl();
			try{
			page=goodService.loadPagedGoods(page,helper);
	//		request.setAttribute("administrators", administratorService.loadAll());
			request.setAttribute("ctglist", ctgList);
			request.setAttribute("pagedGoods", page);
			request.getRequestDispatcher("/jsps/goods/show_goods.jsp").forward(request, response);
			}catch(ApplicationException e){
				String detilStr="��ѯ���벻�Ϸ�,��ѯʧ��";
				request.setAttribute("err", detilStr);
				request.getRequestDispatcher("/jsps/goods/show_goods.jsp").forward(request, response);
			}
			}
		else if("getimage".equals(act)){
			double random = Math.random();
			int goodsId = Integer.parseInt(request.getParameter("goodsid"));
			GoodsService goodsService = new GoodsServiceImpl();
			byte[] goodsImage = goodsService.loadGoodsImageById(goodsId);
			
			response.setContentType("image/jpeg");
			
			ServletOutputStream sos = response.getOutputStream(); 
			
			if(goodsImage!=null && goodsImage.length>0){
				sos.write(goodsImage);
			}
			else{
				String relPath = request.getRealPath("/")+"pics/default.gif";
				FileInputStream fis = new FileInputStream(relPath);
				byte [] defaultImage = new byte[fis.available()];
				fis.read(defaultImage);
				sos.write(defaultImage);
				fis.close();
			}
			sos.flush();
			sos.close();
			try{
			request.setAttribute("randomNum", random);
			request.getRequestDispatcher("/jsps/goods/show_goods.jsp").forward(request, response);
			}catch(Exception e){
				String detalStr= "����쳣��ʱ���ܣ�";
				System.out.println(detalStr);
			}
			
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