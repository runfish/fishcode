package net.dfrz.smmgr01.services;

import java.util.List;

import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.utils.Page;

public interface GoodsService {

	void addGoods(Goods goods);
	void deleteGoods(Goods goods);
	Goods getGoodsById(int goodsId);
	void updateGoods(Goods goods);
	Page loadAll(Page page,GoodsQuryHelper helper);
}
