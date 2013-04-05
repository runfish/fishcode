package net.gdm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.gdm.demo.Order;
import net.gdm.service.OrderService;
import net.gdm.service.OrderServiceImpl;

public class ForeOrderItemMgr extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act").trim();

		if ("list".equals(act)) {// 用户可在简要信息列表中点“查看订单”
								// 查看某订单的详细信息（包括所购买的商品）；
								//orderid
			Integer orderId=Integer.parseInt(request.getParameter("orderid"));
			
			OrderService orderService=new OrderServiceImpl();
			Order order=orderService.getOrder(orderId);
			
			request.setAttribute("order", order);
			
			request.getRequestDispatcher("jsps/fore/order/list_orderitem.jsp").forward(request,response);
			
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
