package net.dfrz.smmgr01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.dfrz.smmgr01.domain.Category;
import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.services.CategoryService;
import net.dfrz.smmgr01.services.CategoryServiceImpl;
import net.dfrz.smmgr01.services.GoodsQuryHelper;
import net.dfrz.smmgr01.services.GoodsService;
import net.dfrz.smmgr01.services.GoodsServiceImpl;
import net.dfrz.smmgr01.utils.Page;
import net.dfrz.smmgr01.dao.GoodsDaoJDBCImpl;

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
		
		request.setCharacterEncoding("utf-8");
		String act = request.getParameter("act");
		
		if("input".equals(act)){
		
			CategoryService cService = new CategoryServiceImpl();
			request.setAttribute("categoryList", cService.loadAll());
		    request.getRequestDispatcher("/jsps/goods/input_goods.jsp").forward(request, response);			
		}
		else if("create".equals(act)){		 
		 Goods goods = new Goods(); 
		 goods.setGoodsId(0);
		 goods.setGoodsName(request.getParameter("goods_name"));
		 goods.setGoodsPrice(Double.parseDouble(request.getParameter("goods_price")));
		 goods.setCtgId(Integer.parseInt(request.getParameter("goods_ctg_id")));
		 goods.setSrc(request.getParameter("goods_src"));
		 goods.setGoodsStoreCondition(request.getParameterValues("goods_store_condition"));
		 goods.setStatus(request.getParameter("goods_status"));
		 
		 GoodsService service = new GoodsServiceImpl();
		 service.addGoods(goods);
		 
		 response.sendRedirect("goodsMgr?act=loadall");
		}
		else if("loadall".equals(act)){
			
			Integer pageNo=null;
			GoodsQuryHelper helper=new GoodsQuryHelper();
			CategoryService ctgService=new CategoryServiceImpl();
			List<Category>ctgList=ctgService.loadAll();
		
			if(request.getParameter("qurygoodsname")!=null)
			{
				helper.setGoodsName(request.getParameter("qurygoodsname"));
			}
			if(request.getParameter("quryctgid")!=null&&!request.getParameter("quryctgid").equals("gctgempty"))
			{
				helper.setGoodsCtgId(Integer.parseInt(request.getParameter("quryctgid")));
			}
			if(request.getParameter("qurygoodssrc")!=null&&!request.getParameter("qurygoodssrc").equals("gsrcempty"))
			{
				helper.setGoodsSrc(request.getParameter("qurygoodssrc"));
			}
			if(request.getParameter("pageNo")!=null){
			   pageNo=Integer.parseInt(request.getParameter("pageNo"));	
			}
			
			Page page=new Page();
			if(pageNo!=null)  page.setPageNo(pageNo);
			
			GoodsService goodService=new GoodsServiceImpl();
			page=goodService.loadAll(page,helper);
			
			request.setAttribute("ctglist", ctgList);
			request.setAttribute("pagedGoods", page);
			
			request.getRequestDispatcher("/jsps/goods/list_goods.jsp").forward(request, response);
			
		}
		else if("forUpdate".equals(act)){
			int goodsId=Integer.parseInt(request.getParameter("goodsid"));
			GoodsService goodsService = new GoodsServiceImpl();
			CategoryService categoryService=new CategoryServiceImpl();
			request.setAttribute("ctglist", categoryService.loadAll());
			request.setAttribute("goods", goodsService.getGoodsById(goodsId));
			request.getRequestDispatcher("/jsps/goods/update_goods.jsp").forward(request, response);
		}

		
		else if("update".equals(act)){
		
			 Goods goods = new Goods();
			 goods.setGoodsId(Integer.parseInt(request.getParameter("goodsid")));
			 goods.setGoodsName(request.getParameter("goodsname"));
			 goods.setGoodsPrice(Double.parseDouble(request.getParameter("goodsprice")));
			 goods.setCtgId(Integer.parseInt(request.getParameter("goodsctgid")));
			 goods.setSrc(request.getParameter("goodssrc"));
			 goods.setGoodsStoreCondition(request.getParameterValues("goodsstorecondition"));
			 goods.setStatus(request.getParameter("goodsstatus"));
			 
			 GoodsService service = new GoodsServiceImpl();
			 service.updateGoods(goods);
			 response.sendRedirect("goodsMgr?act=loadall");
			 
			 
		}
		else if("del".equals(act))
		{
			Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));
			GoodsService goodsService=new GoodsServiceImpl();
			goodsService.deleteGoods(goodsService.getGoodsById(goodsId));
			response.sendRedirect("goodsMgr?act=loadall");
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
