/**
 * 
 */
package net.gdm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 
 */
public class ShoppingCart extends ValueObject {

	private List<CartItem> items = new ArrayList<CartItem>();
	private Double cartAmount = 0.0;

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Double getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}

}
