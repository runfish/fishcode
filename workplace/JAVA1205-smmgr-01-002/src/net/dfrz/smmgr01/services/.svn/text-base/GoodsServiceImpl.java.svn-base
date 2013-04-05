/**
 * 
 */
package net.dfrz.smmgr01.services;

import java.util.List;

import net.dfrz.smmgr01.dao.GoodsDao;
import net.dfrz.smmgr01.dao.GoodsDaoJDBCImpl;
import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.utils.Page;

/**
 * @author Administrator
 *
 */
public class GoodsServiceImpl implements GoodsService {

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.GoodsService#addGoods(net.dfrz.smmgr01.domain.Goods)
	 */
	public void addGoods(Goods goods) {
	   GoodsDao goodsdao = new GoodsDaoJDBCImpl();
       goodsdao.add(goods);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.GoodsService#deleteGoods(net.dfrz.smmgr01.domain.Goods)
	 */
	public void deleteGoods(Goods goods) {
		GoodsDao goodsdao = new GoodsDaoJDBCImpl();
        goodsdao.delete(goods);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.GoodsService#getGoodsById(int)
	 */
	public Goods getGoodsById(int goodsId) {
		GoodsDao goodsdao = new GoodsDaoJDBCImpl();
		return goodsdao.getGoodsById(goodsId);
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.GoodsService#loadAll()
	 */
	public Page loadAll(Page page,GoodsQuryHelper helper) {
		
		GoodsDao goodsdao = new GoodsDaoJDBCImpl();
		int totalRecNum=goodsdao.countGoods(helper);
		page.setTotalRecNum((long)totalRecNum);
		page.setPageContent(goodsdao.loadAll(page.getStartIndex(), page.getEndIndex(),helper));
		return page;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.GoodsService#updateGoods(net.dfrz.smmgr01.domain.Goods)
	 */
	public void updateGoods(Goods goods) {
		GoodsDao goodsdao = new GoodsDaoJDBCImpl();
         goodsdao.update(goods);
	}

}
