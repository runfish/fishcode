package net.gdm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gdm.demo.Order;
import net.gdm.demo.ShoppingCart;
import net.gdm.demo.User;
import net.gdm.service.OrderQueryHelper;
import net.gdm.service.OrderService;
import net.gdm.service.OrderServiceImpl;
import net.gdm.util.Page;
import net.gdm.util.SysUtils;

public class ForeOrderMgr extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act=request.getParameter("act").trim();
		
		if("add".equals(act)){//将session中shoppingcart保存到order；
			                  //
			                  //去end.jsp
			
			Order order=new Order();
			order.setPay_mode(request.getParameter("paymode"));
			order.setReceive_mode(request.getParameter("receivemode"));
			order.setReceiver_add(request.getParameter("receiveraddr"));
			order.setReceiver_email(request.getParameter("receiveremail"));
			order.setReceiver_name(request.getParameter("receivername"));
			order.setReceiver_phone(request.getParameter("receiverphone"));
			order.setReceiver_postcode(request.getParameter("receivepostcode"));
			
			
			HttpSession session= request.getSession();
			
			
			User user=(User) session.getAttribute("logineduser");
			order.setUser(user);
					
			
			
			ShoppingCart shoppingCart = (ShoppingCart) session
			.getAttribute("shoppingcart");
			
			
			OrderService orderService=new OrderServiceImpl();
			orderService.parseShoppingCartToOrder(order, shoppingCart);
			
			orderService.createOrder(order);
			
			session.removeAttribute("shoppingcart");
			
			response.sendRedirect(SysUtils.getSrvPath(request)+"/jsps/fore/payoff/end.jsp");
			
			
		}else if("list".equals(act)){//“我的订单”链接   列出订单 及查询  	用户可根据下单日期,审核状态查询订单；
			
			OrderQueryHelper helper=new OrderQueryHelper();
			
			if(request.getParameter("qrydate")!=null && request.getParameter("qrydate").trim().length()>0){
				
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					helper.setDate(sdf.parse(request.getParameter("qrydate")));
				} catch (ParseException e) {
					                                  //js验证
					e.printStackTrace();
				}
			}
			if(request.getParameter("qrystatus")!=null && request.getParameter("qrystatus").trim().length()>0){
				helper.setStatue(request.getParameter("qrystatus"));
			}
			
			
			Page page=new Page();
			page.setPageSize(100000);
			
			
			OrderService orderService=new OrderServiceImpl();
			page=orderService.loadOrdersByMaker(helper, page);
			request.setAttribute("page",page);
			
			
			request.getRequestDispatcher("/jsps/fore/order/list_order.jsp").forward(request,response);
			
			
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}
}
