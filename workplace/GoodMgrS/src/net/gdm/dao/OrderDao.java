/**
 * 
 */
package net.gdm.dao;

import java.util.List;

import net.gdm.demo.Admine;
import net.gdm.demo.Order;
import net.gdm.demo.OrderItem;
import net.gdm.demo.ShoppingCart;
import net.gdm.service.OrderQueryHelper;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public interface OrderDao {
    List<Order> ListOrder();
    void addOrder(Order order);
    Order getOne(int id);
    void UpateOrder(Order order);
    void deleteOrder(int id);
    void Statusover(Order order);
    void changeStatus(Order order, Admine adm);
    List<OrderItem> getdetailById(int orderid);
    Page loadOrdersByMaker(OrderQueryHelper helper, Page page);
//  Order parseShoppingCartToOrder(Order iniOrder, ShoppingCart cart); 不用数据库 service就可以了; 
}
