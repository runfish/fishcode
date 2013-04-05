/**
 * 
 */
package net.dfrz.supershop01.services;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;

/**
 * @author hhg0012
 *
 */
public interface ShoppingCartService {
	
	/**
	 * 添加商品到购物车
	 * @param goods
	 * @param cart
	 */
	void addGoodsToCart(Goods goods,ShoppingCart cart);
	/**
	 * 从购物车删除商品
	 * @param item
	 * @param cart
	 */
	void removeGoodsFromCart(CartItem item,ShoppingCart cart);
	/**
	 * 更新购物车的总金额
	 * @param item
	 * @param type
	 */
	void updateCartAmount(CartItem item,String type);

}
