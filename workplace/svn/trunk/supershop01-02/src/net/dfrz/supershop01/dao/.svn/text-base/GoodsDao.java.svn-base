/**
 * 
 */
package net.dfrz.supershop01.dao;
import java.util.List;

import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.servicesimpl.GoodsQueryHelper;
/**
 * @author YDP1205
 *
 */
public interface GoodsDao {
	
	void add(Goods goods);
	void update(Goods goods);
    List<Goods> getScopedGoods(GoodsQueryHelper helper,int beginIndex, int endIndex);
    byte[] getGoodsImage(Integer goodsId);
    int countGoods(GoodsQueryHelper helper);
    void deleteGoodsById(Integer goodsId);
    Goods getGoodsById(Integer goodsId);
    List<Goods> loadAll();
    List<Category> getSubCtgs(int ctgPid);
    //我加了一个，实现还没弄哦
    List<Goods> ListGoods(int ctgid);
}
