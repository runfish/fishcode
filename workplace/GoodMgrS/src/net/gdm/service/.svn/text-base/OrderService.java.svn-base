/**
 * 
 */
package net.gdm.service;

import java.util.List;

import net.gdm.demo.Admine;
import net.gdm.demo.Order;
import net.gdm.demo.OrderItem;
import net.gdm.demo.ShoppingCart;
import net.gdm.util.Page;



/**
 * @author Administrator
 *
 */
public interface OrderService {
	
	
	void createOrder(Order order);
	void remove(Order order);
	Order parseShoppingCartToOrder(Order iniOrder,ShoppingCart cart);
//	List<OrderItem> getdetailById(int orderid);	 同下面重复了
	Order getOrder(int orderid);
	void changeStatus(Order order,Admine adm);	
	void Statusover(Order order);	 	 
	Page loadOrdersByMaker(OrderQueryHelper helper,Page page);

}
