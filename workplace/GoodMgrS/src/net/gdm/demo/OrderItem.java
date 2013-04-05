/**
 * 
 */
package net.gdm.demo;


/**
 * @author Administrator
 *
 */
public class OrderItem {
	private int item_id;
	private int item_amount;
	private double item_goods_price;
	private Goods goods;     //参考老师给的案例， private Goods goods;
	private Order order;    //参考老师给的案例， private Order order;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public double getItem_goods_price() {
		return item_goods_price;
	}
	public void setItem_goods_price(double item_goods_price) {
		this.item_goods_price = item_goods_price;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	

}
