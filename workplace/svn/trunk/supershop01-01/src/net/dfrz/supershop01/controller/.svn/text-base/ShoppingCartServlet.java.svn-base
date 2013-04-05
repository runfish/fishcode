package net.dfrz.supershop01.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.ApplicationException;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.services.ShoppingCartService;
import net.dfrz.supershop01.services.SmallCategoryService;
import net.dfrz.supershop01.servicesimpl.GoodsServiceImpl;
import net.dfrz.supershop01.servicesimpl.ShoppingCartServiceImpl;
import net.dfrz.supershop01.servicesimpl.SmallCategoryServiceImpl;

public class ShoppingCartServlet extends HttpServlet {

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
		
		if(act.equals("add"))
		{
			/**
			 * 获得购物车对象，如果session空间不存在购物车对象，新建一个购物车对象并且重新保存到session空间
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			if(cart==null)
			{
				cart=new ShoppingCart();
			}
			/**
			 * 获取商品信息
			 */
			Integer goodsId=Integer.parseInt(request.getParameter("goodsid"));
			Goods goods=null;
			try 
			{
				GoodsService goodsService=new GoodsServiceImpl();
				goods=goodsService.getGoodsById(goodsId);
				if(goods.getGoodsQty()<=0)
				{
					throw new ApplicationException("对不起该商品数量不足!");
				}
				ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
				shoppingCartService.addGoodsToCart(goods, cart);
			} catch (ApplicationException e) 
			{
				e.printStackTrace();
				PrintWriter out=response.getWriter();
				out.println(e.getMessage());
				return;
				// TODO: handle exception
			}
			request.getSession().setAttribute("cart", cart);
			PrintWriter out=response.getWriter();
			out.println("商品已经成功加入购物车!");
		}
		else if(act.equals("del"))
		{
			/**
			 * 获取要删除的购物车条目的编号
			 */
			Integer itemId=Integer.parseInt(request.getParameter("itemid"));
			/**
			 * 获取购物车对象并进行删除操作
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			CartItem cartItem=cart.getCartList().get(itemId);
			
			ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
			shoppingCartService.removeGoodsFromCart(cartItem, cart);
			
			request.getSession().setAttribute("cart", cart);
			response.sendRedirect("/shop01/cartMgr?act=loadall");
		}
		else if(act.equals("increase")) 
		{
			/**
			 * 获取要增加商品数量的购物车条目的编号
			 */
			Integer itemId=Integer.parseInt(request.getParameter("itemid"));
			/**
			 * 获取购物车对象并进行增加操作
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			CartItem cartItem=cart.getCartList().get(itemId);
			
			ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
			shoppingCartService.updateCartAmount(cartItem, "up");
			
			request.getSession().setAttribute("cart", cart);
			PrintWriter out=response.getWriter();
			out.println(cartItem.getGoodsQty());
		}
		else if(act.equals("discrease")) 
		{
			/**
			 * 获取要减少商品数量的购物车条目的编号
			 */
			Integer itemId=Integer.parseInt(request.getParameter("itemid"));
			/**
			 * 获取购物车对象并进行减少操作
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			CartItem cartItem=cart.getCartList().get(itemId);
			
			ShoppingCartService shoppingCartService=new ShoppingCartServiceImpl();
			shoppingCartService.updateCartAmount(cartItem, "down");
			
			request.getSession().setAttribute("cart", cart);
			PrintWriter out=response.getWriter();
			out.println(cartItem.getGoodsQty());
		}
		else if(act.equals("loadall")) 
		{
			/**
			 * 获得购物车对象，如果session空间不存在购物车对象，新建一个购物车对象并且重新保存到session空间
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			if(cart==null)
			{
				cart=new ShoppingCart();
			}
			/**
			 * 获取商品对象以及商品类别列表
			 */
			List<Goods>goodsList=null;
			List<SmallCategory>ctgList=null;
			try 
			{
				GoodsService goodsService=new GoodsServiceImpl();
				goodsList=goodsService.loadAll();
				SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
				ctgList=smallCategoryService.loadall();
			} catch (ApplicationException e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				// TODO: handle exception
			}
			request.setAttribute("mycart",cart);
			request.setAttribute("goodslist", goodsList);
			request.setAttribute("ctgList", ctgList);
			request.getRequestDispatcher("/jsps/deals/cart_list.jsp").forward(request, response);
		}
		else if(act.equals("gotoconfirm"))
		{
			/**
			 * 获得购物车对象，如果session空间不存在购物车对象，新建一个购物车对象并且重新保存到session空间
			 */
			ShoppingCart cart=(ShoppingCart)request.getSession().getAttribute("cart");
			/**
			 * 获取商品对象以及商品类别列表
			 */
			List<Goods>goodsList=null;
			List<SmallCategory>ctgList=null;
			try 
			{
				GoodsService goodsService=new GoodsServiceImpl();
				goodsList=goodsService.loadAll();
				SmallCategoryService smallCategoryService=new SmallCategoryServiceImpl();
				ctgList=smallCategoryService.loadall();
			} catch (ApplicationException e) {
				e.printStackTrace();
				request.setAttribute("error", e.getMessage());
				// TODO: handle exception
			}
			request.setAttribute("mycart",cart);
			request.setAttribute("goodslist", goodsList);
			request.setAttribute("ctgList", ctgList);
			request.getRequestDispatcher("/jsps/deals/consignee_info.jsp").forward(request, response);
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
