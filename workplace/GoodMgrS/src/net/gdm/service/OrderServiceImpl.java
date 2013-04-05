/**
 * 
 */
package net.gdm.service;

import java.util.Date;
import java.util.List;

import net.gdm.dao.OrderDao;
import net.gdm.dao.OrderDaoImpl;
import net.gdm.demo.Admine;
import net.gdm.demo.CartItem;
import net.gdm.demo.Order;
import net.gdm.demo.OrderItem;
import net.gdm.demo.ShoppingCart;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class OrderServiceImpl implements OrderService {
    
	OrderDao oraderdao=new OrderDaoImpl();
	
	@Override	
	public void Statusover(Order order) {
		// TODO Auto-generated method stub
		oraderdao.Statusover(order);
	}

	@Override
	public void changeStatus(Order order, Admine adm) {
		// TODO Auto-generated method stub
	     oraderdao.changeStatus(order, adm);	
	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		oraderdao.addOrder(order);
	}

	@Override
	public Order getOrder(int orderid) {
		// TODO Auto-generated method stub
		return oraderdao.getOne(orderid);
	}



	@Override
	public Page loadOrdersByMaker(OrderQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return oraderdao.loadOrdersByMaker(helper, page);
	}

	@Override
	public Order parseShoppingCartToOrder(Order order, ShoppingCart cart) {
	
		order.setOrder_time(new Date());
		order.setOrder_account(cart.getCartAmount());
		
		for(CartItem item:cart.getItems()){
			OrderItem orderItem=new OrderItem();
			orderItem.setItem_amount(item.getAmount());
			orderItem.setItem_goods_price(item.getTotalPrice());
			orderItem.setGoods(item.getGoods());
			orderItem.setOrder(order);
			
			order.getItems().add(orderItem);
		}
		
		
		return order;
	}

	@Override
	public void remove(Order order) {
		// TODO Auto-generated method stub
		oraderdao.deleteOrder(order.getOrder_id());
	}

}
