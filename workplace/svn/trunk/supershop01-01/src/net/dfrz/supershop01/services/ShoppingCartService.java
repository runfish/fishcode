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
	 * �����Ʒ�����ﳵ
	 * @param goods
	 * @param cart
	 */
	void addGoodsToCart(Goods goods,ShoppingCart cart);
	/**
	 * �ӹ��ﳵɾ����Ʒ
	 * @param item
	 * @param cart
	 */
	void removeGoodsFromCart(CartItem item,ShoppingCart cart);
	/**
	 * ���¹��ﳵ���ܽ��
	 * @param item
	 * @param type
	 */
	void updateCartAmount(CartItem item,String type);

}
