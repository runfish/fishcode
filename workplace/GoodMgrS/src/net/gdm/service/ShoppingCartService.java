package net.gdm.service;

import net.gdm.demo.Goods;
import net.gdm.demo.ShoppingCart;



public interface ShoppingCartService {

	void addGoodsToCart(Goods goods, ShoppingCart cart);
	void setNewItemAmount(String goodsId,Integer amount,ShoppingCart cart);
	void removeGoodsFromCart(String goodsId,ShoppingCart cart);
	
}
