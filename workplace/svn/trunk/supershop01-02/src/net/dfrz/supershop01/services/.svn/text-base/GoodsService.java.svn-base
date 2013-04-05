package net.dfrz.supershop01.services;

import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
import net.dfrz.supershop01.utils.Page;

/**
 * 
 * @author YDP1205
 *
 */
public interface GoodsService {
	void addGoods(Goods goods);
	Goods getGoodsById(int goodsId);
	void updateGoods(Goods goods);
	Page loadPagedGoods(Page page, GoodsQueryHelper helper);
	byte[] loadGoodsImageById(Integer goodsId);
	void delete(Integer goodsId);
	List<Goods> loadAll();
	List<Category> getSubCtg(int ctgPid);

}
