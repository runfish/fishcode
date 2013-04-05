/**
 * 
 */
package net.gdm.dao;

import java.util.List;

import net.gdm.demo.Goods;
import net.gdm.service.GoodsQueryHelper;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public interface GoodsDao {
    List<Goods> ListGoods();
    void addGoods(Goods goods);
    Goods getOne(int id);
    void UpdateGoods(Goods goods);
    void deleteGoods(int id);
    byte[] getGoodsPic(Integer id);
    List<Goods> ListGoods(int ctgid);
    Page loadPagedGoods(GoodsQueryHelper helper, Page page);
}
