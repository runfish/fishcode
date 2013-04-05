package net.gdm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.gdm.demo.CartItem;
import net.gdm.demo.Goods;
import net.gdm.demo.Order;
import net.gdm.demo.ShoppingCart;
import net.gdm.service.GoodsService;
import net.gdm.service.GoodsServiceImpl;
import net.gdm.service.ShoppingCartService;
import net.gdm.service.ShoppingCartServiceImpl;
import net.gdm.util.SysUtils;

public class ForeShoppingCartMgr extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String act = request.getParameter("act").trim();

		if ("buy".equals(act)) { // getGoods(goodsId)
			// 以shoppingcart存入session
			// 去 listcart
			
			
			
			
			
			HttpSession session = request.getSession();

			ShoppingCart shoppingCart = (ShoppingCart) session
					.getAttribute("shoppingcart");
			
			if (shoppingCart == null) {
				shoppingCart = new ShoppingCart();
				session.setAttribute("shoppingcart", shoppingCart);
			}

			
			Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));
			GoodsService goodsService = new GoodsServiceImpl();
			Goods goods=goodsService.getGoods(goodsId);
			
			
			ShoppingCartService scs = new ShoppingCartServiceImpl();
			scs.addGoodsToCart(goods, shoppingCart);
			
			response.sendRedirect("/fshoppingcartmgr?act=listcart");
			

		} else if ("cartitemnum".equals(act)) {// ajax 自动更新以goodsid为唯一标示；
			String goodsId=request.getParameter("goodsid");
			Integer cartItemnum=Integer.parseInt(request.getParameter("cartitemnum"));
			
			
			HttpSession session = request.getSession();
			ShoppingCart shoppingCart = (ShoppingCart) session
					.getAttribute("shoppingcart");
			
			ShoppingCartService scs = new ShoppingCartServiceImpl();
			scs.setNewItemAmount(goodsId, cartItemnum, shoppingCart);
			
			
			
			//ajax 实现
			String id=goodsId;
			String price=null;
			String allprice=shoppingCart.getCartAmount()+"";
			for(CartItem item:shoppingCart.getItems()){
				if(item.getGoods().getGoods_id()== (Integer.parseInt(goodsId))){
					price=item.getTotalPrice()+"";
				}
			}
			
			
			PrintWriter out=response.getWriter();
	        out.print("updateCartItem('"+id+"',"+price+");");
	        out.print("updateCart("+allprice+");");
	      
	        out.flush();
	        out.close();
			
			
			
		} else if ("del".equals(act)) {// 删除购物车中的一种商品
			// 去 listcart
			String goodsId=request.getParameter("goodsid");
			
			HttpSession session = request.getSession();
			ShoppingCart shoppingCart = (ShoppingCart) session
					.getAttribute("shoppingcart");
			
			ShoppingCartService scs=new ShoppingCartServiceImpl();
			scs.removeGoodsFromCart(goodsId, shoppingCart);
			
			
			response.sendRedirect("/fshoppingcartmgr?act=listcart");
		} else if ("payoff".equals(act)) {// 先验证是否登入（session范围是否有用户 filter验证）
											// 去 payoff/input_order.jsp页面
												//js验证是否有值 若无则不去;
//			response.sendRedirect(SysUtils.getSrvPath(request)+"/jsps/fore/shoppingcart/input_order.jsp");
			
			request.getRequestDispatcher("/jsps/fore/payoff/input_order.jsp").forward(request,response);
			
		} else if ("listcart".equals(act)) {// 去 list_shoppingcart.jsp 页面

			response.sendRedirect(SysUtils.getSrvPath(request)+"/jsps/fore/shoppingcart/list_shoppingcart.jsp");
		}else if("clear".equals(act)){
			HttpSession session = request.getSession();
			session.removeAttribute("shoppingcart");
			
			request.getRequestDispatcher("fshoppingcartmgr?act=listcart").forward(request,response);
		}
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
