/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.domain.CartItem;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.domain.ShoppingCart;
import net.dfrz.supershop01.services.ShoppingCartService;

/**
 * @author hhg0012
 *
 */
public class ShoppingCartServiceImpl implements ShoppingCartService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#addGoodsToCart(net.dfrz.supershop01.domain.Goods, net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void addGoodsToCart(Goods goods, ShoppingCart cart) {
		// TODO Auto-generated method stub
		/**
		 * 创建订单条目对象并加入购物车对象
		 */
		CartItem cartItem=new CartItem();
		cartItem.setGoodsId(goods.getGoodsId());
		cartItem.setGoodsCtgId(goods.getGoodsCtgId());
		cartItem.setGoodsPrice(goods.getGoodsPrice());
		cartItem.setGoodsQty(goods.getGoodsQty());
		cartItem.setAdminId(goods.getGoodsAdminId());
		cart.getCartList().add(cartItem);
		cart.setCartItemAmount(cart.getCartItemAmount()+1);
		/**
		 * 统计订单总金额
		 */
		Double totalAmount=0.0;
		for(CartItem item:cart.getCartList())
		{
			totalAmount+=(item.getGoodsPrice()*item.getGoodsQty());
		}
		cart.setTotalAmount(totalAmount);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#removeGoodsFromCart(net.dfrz.supershop01.domain.CartItem, net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void removeGoodsFromCart(CartItem item, ShoppingCart cart) {
		// TODO Auto-generated method stub
		Double totalAmount=cart.getTotalAmount();
		cart.setTotalAmount(totalAmount-item.getGoodsPrice()*item.getGoodsQty());
		cart.setCartItemAmount(cart.getCartItemAmount()-1);
		cart.getCartList().remove(item);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.ShoppingCartService#updateCartAmount(net.dfrz.supershop01.domain.CartItem, java.lang.Integer, net.dfrz.supershop01.domain.ShoppingCart)
	 */
	public void updateCartAmount(CartItem item, String type) {
		// TODO Auto-generated method stub

		if(type.equals("up"))
		{
			item.setGoodsQty(item.getGoodsQty()+1);
		}
		else if(type.equals("down"))
		{
			item.setGoodsQty(item.getGoodsQty()-1);
		}

	}

}
