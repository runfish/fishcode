/**
 * 
 */
package net.gdm.dao;

import java.util.List;

import net.gdm.demo.OrderItem;

/**
 * @author Administrator
 *
 */
public interface OrderItemDao {
	List<OrderItem> ListOraderItem();
    void addOraderItem(OrderItem item);
    void updateOraderItem(OrderItem item);
    OrderItem getOne(int id);
    void deleteOraderItem(int id);
}
