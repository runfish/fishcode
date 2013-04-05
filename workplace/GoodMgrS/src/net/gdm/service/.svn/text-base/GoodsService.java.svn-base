/**
 * 
 */
package net.gdm.service;


import net.gdm.demo.Goods;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public interface GoodsService {

	
	void regGoods(Goods goods);
	void modifyGoods(Goods goods);
	void delGoods(Goods goods);
	
	Goods getGoods(Integer gooodsId);	
	byte[] loadPic(Integer gooodsId);
	
	Page loadPagedGoods(GoodsQueryHelper helper,Page page);
	
}
