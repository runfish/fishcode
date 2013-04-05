package net.gdm.service;

import net.gdm.demo.CartItem;
import net.gdm.demo.Goods;
import net.gdm.demo.ShoppingCart;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Override
	public void addGoodsToCart(Goods goods, ShoppingCart cart) {
		boolean flag = false;
		for (CartItem item : cart.getItems()) {
			if (item.getGoods().getGoods_id() == goods.getGoods_id()) {

				flag = true;
				item.setAmount(item.getAmount() + 1);
				item.setTotalPrice(item.getAmount() * goods.getGoods_price());
				break;
			}
		}

		if (!flag) {
			CartItem cartItem = new CartItem();
			cartItem.setGoods(goods);
			cartItem.setAmount(1);
			cartItem.setTotalPrice(goods.getGoods_price());
			cart.getItems().add(cartItem);
		}

		cart.setCartAmount(cart.getCartAmount() + goods.getGoods_price());
	}

	@Override
	public void removeGoodsFromCart(String goodsId, ShoppingCart cart) {

		for (int i = 0; i < cart.getItems().size(); i++) {
			if (cart.getItems().get(i).getGoods().getGoods_id() == Integer
					.parseInt(goodsId)) {
				
				cart.setCartAmount(cart.getCartAmount()-cart.getItems().get(i).getTotalPrice());
				
				cart.getItems().remove(i);
				break;
			}
		}

	}

	@Override
	public void setNewItemAmount(String goodsId, Integer amount,
			ShoppingCart cart) {

		for (CartItem item : cart.getItems()) {
			if (item.getGoods().getGoods_id() == Integer.parseInt(goodsId)) {
				int i = amount - item.getAmount();
				item.setAmount(amount);
				item.setTotalPrice(amount * item.getGoods().getGoods_price());
				cart.setCartAmount(cart.getCartAmount() + i
						* item.getGoods().getGoods_price());

				break;
			}
		}

	}

}
