package net.dfrz.smmgr01.dao;

import java.util.List;
import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.services.GoodsQuryHelper;

public interface GoodsDao {

	void add(Goods goods);
	void delete(Goods goods);
	Goods getGoodsById(int goodsId);
	void update(Goods goods);
	List<Goods>loadAll(int beginIndex,int endIndex,GoodsQuryHelper helper);
	int countGoods(GoodsQuryHelper helper);
}
