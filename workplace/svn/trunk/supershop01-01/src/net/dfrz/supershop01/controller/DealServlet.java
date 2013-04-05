package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.utils.Page;

public class DealServlet extends HttpServlet {

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
		
		if("add".equals(act))
		{
			String consigneeName=request.getParameter("consignee_name");
			String address=request.getParameter("address");
			String postCode=request.getParameter("post_code");
			String tel=request.getParameter("tel");
			String email=request.getParameter("email");
			String payPattern=request.getParameter("pay_pattern");
			String receivePattern=request.getParameter("receive_pattern");
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			Deal deal=new Deal();
			deal.setConsigneeInfo(consigneeName+":"+address+":"+postCode+":"+tel+":"+email);
			deal.setPayPattern(payPattern);
			deal.setReceivePattern(receivePattern);
			try 
			{
				DealService dealService=new DealServiceImpl();
				dealService.addDeal(deal);
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.getRequestDispatcher("/jsps/consignee_info.jsp").forward(request, response);
			}
		}
		else if("loadPageDeal".equals(act))
		{
			/**
			 * 获取用户信息
			 */
			Customer customer=(Customer)request.getSession().getAttribute("customer");
			/**
			 * 获取订单列表
			 */
			DealService dealService=new DealServiceImpl();
			Integer pageNo=null;
			DealQuryHelper helper=new DealQuryHelper(); 
			//helper.setDealCustomerId();
			/**
			 * 根据具体的管理员检索其管理的所有商品订单信息，若该管理员为超级管理员可查询所有的商品订单信息
			 */
			Integer isAdmin=(Integer)request.getSession().getAttribute("isadmin");
			
			if(request.getParameter("qurydealid")!=null&&request.getParameter("qurydealid").length()>0)
			{
				helper.setDealId(Integer.parseInt(request.getParameter("qurydealid")));
			}
			if(request.getParameter("qurydealstatus")!=null)
			{
				helper.setDealStatus(request.getParameter("qurydealstatus"));
			}
			if(request.getParameter("qurydealdate")!=null)
			{
				helper.setDealDate(request.getParameter("qurydealdate"));
			}
			if(request.getParameter("pageno")!=null)
			{
				pageNo=Integer.parseInt(request.getParameter("pageno"));
			}
			
			Page pagedDeal=new Page();
			if(pageNo!=null)pagedDeal.setPageNo(pageNo);
			
			try
			{	
				pagedDeal=dealService.loadPage(pagedDeal, helper);
			}
			catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			
			request.setAttribute("pagedDeal", pagedDeal);
			
			request.getRequestDispatcher("/jsps/deals/deals_list.jsp").forward(request, response);
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
