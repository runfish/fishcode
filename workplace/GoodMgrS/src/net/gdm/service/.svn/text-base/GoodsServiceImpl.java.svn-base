/**
 * 
 */
package net.gdm.service;

import net.gdm.dao.GoodsDao;
import net.gdm.dao.GoodsDaoImpl;
import net.gdm.demo.Goods;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsdao=new GoodsDaoImpl();
	@Override
	public void delGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsdao.deleteGoods(goods.getGoods_id());
	}

	@Override
	public Goods getGoods(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsdao.getOne(goodsId);
	}

	@Override
	public Page loadPagedGoods(GoodsQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return goodsdao.loadPagedGoods(helper, page);
	}

	@Override
	public byte[] loadPic(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsdao.getGoodsPic(goodsId);
	}

	@Override
	public void modifyGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsdao.UpdateGoods(goods);
	}

	@Override
	public void regGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsdao.addGoods(goods);
	}

}
