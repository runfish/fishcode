package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.services.DealService;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.CategoryServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealItemServiceImpl;
import net.dfrz.supershop01.servicesimpl.DealQuryHelper;
import net.dfrz.supershop01.servicesimpl.DealServiceImpl;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;
import net.dfrz.supershop01.utils.Page;
/**
 * 
 * @author J1205-HongHG
 *
 */
public class DealServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DealServlet() {
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
		
		if("loadPageDeal".equals(act))
		{
			/**
			 * 获取订单条目列表
			 */
			DealService dealService=new DealServiceImpl();
			Integer pageNo=null;
			DealQuryHelper helper=new DealQuryHelper(); 
			
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
		else if(act.equals("del")) 
		{
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			DealService dealService=new DealServiceImpl();
			try 
			{
				dealService.deleteDeal(dealService.getDealById(dealId));
				request.setAttribute("error","订单编号为："+dealId+"的订单信息已经成功删除！");
			
			} catch (ApplicationException e)
			{
				// TODO: handle exception
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
			}
			response.sendRedirect("/shop02/action/dealMgr?act=loadPageDeal");
		}
		else if(act.equals("update"))
		{
			request.setCharacterEncoding("utf-8");
			/**
			 * 获取订单修改的属性的类型
			 */
			String type=request.getParameter("type");
			/**
			 * 下拉列表选中的值以及订单条目编号
			 */
			String Value=request.getParameter("selectedvalue");
			String selectedValue=new String(Value.getBytes("iso-8859-1"),"utf-8");
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			DealService dealService=new DealServiceImpl();
			response.setCharacterEncoding("utf-8");
			try 
			{
				Deal deal=dealService.getDealById(dealId);
				
			    if(type.equals("payPattern"))
			    {
			    	deal.setPayPattern(selectedValue);
			    }
			    else if(type.equals("receivePattern"))
			    {
			    	deal.setReceivePattern(selectedValue);
			    }
			    else if(type.equals("consigneeInfo"))
			    {
			    	deal.setConsigneeInfo(selectedValue);
			    }
			    else if(type.equals("dealExam"))
			    {
			    	String date=request.getParameter("date");
			    	Date sqlDate=java.sql.Date.valueOf(date);
			    	deal.setDealExamDate(sqlDate);
					deal.setDealStatus(selectedValue);
				}
			    dealService.updateDeal(deal);
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter pw=response.getWriter();
				pw.write("error|"+e.getMessage());
				pw.flush();
				pw.close();
			} 
			
			PrintWriter pw=response.getWriter();
			pw.write("input|"+selectedValue.toString());
			pw.flush();
			pw.close();
		}
		else if(act.equals("getDealInfo"))
		{
			response.setCharacterEncoding("utf-8");
			/**
			 * 获取要展示的信息类型（收货人信息、订单信息）
			 */
			String type=request.getParameter("type");
			/**
			 * 获得需要显示详细信息的订单编号
			 */
			Integer dealId=Integer.parseInt(request.getParameter("dealid"));
			
			Deal deal=null;
			String[]dealInfo=null;
			DealService dealService=new DealServiceImpl();
			StringBuffer buffer=new StringBuffer();//存放信息的数据缓冲区
			
			try 
			{
				deal=dealService.getDealById(dealId);
				dealInfo=deal.toString().split(":");
				
				if(type.equals("part"))
				{
					buffer.append("input|");
					buffer.append(dealInfo[0]+":");
					buffer.append(dealInfo[1]+":");
					buffer.append(dealInfo[2]+":");
					buffer.append(dealInfo[3]+":");
					buffer.append(dealInfo[4]);
				}
				
			} catch (ApplicationException e) {
				// TODO: handle exception
				e.printStackTrace();
				PrintWriter pw=response.getWriter();
				pw.write("error|"+e.getMessage());
				pw.flush();
				pw.close();
			}
			
			PrintWriter pw=response.getWriter();
			pw.write(buffer.toString());
			pw.flush();
			pw.close();
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
