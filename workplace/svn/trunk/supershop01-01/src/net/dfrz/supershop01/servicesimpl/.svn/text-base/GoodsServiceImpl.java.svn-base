/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;


import java.util.List;

import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.daoimpl.GoodsDaoJDBCImpl;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.Goods;
import net.dfrz.supershop01.services.GoodsService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * @author Administrator
 *
 */
public class GoodsServiceImpl implements GoodsService {


	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
			manager.beginTransaction();
		    GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		    goodsDao.add(goods);
		    manager.commitAndClose();
		
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}
		
		
	}

	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		Goods goods=null;
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
	    goods=goodsDao.getGoodsById(goodsId);
	    manager.commitAndClose();
		
	 }catch(Exception e){
		e.printStackTrace();
	  manager.rollbackAndClose();	
	}
	 return goods;
	}


	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsDao.update(goods);
	    manager.commitAndClose();
		
	    }catch(Exception e){
		e.printStackTrace();
	  manager.rollbackAndClose();	
	}
		
	}
	
	public Page loadPagedGoods(Page page, GoodsQueryHelper helper){
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		   GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		   page.setTotalRecNum((long)goodsDao.countGoods(helper));
		   page.setPageContent(goodsDao.getScopedGoods(helper, page.getStartIndex(), page.getEndIndex()));
           manager.commitAndClose();
		}catch(Exception e){
		e.printStackTrace();
	    manager.rollbackAndClose();	
	  }
	   return page;
	}
	
	public byte[] loadGoodsImageById(Integer goodsId){
		byte [] goodsImage = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsImage = goodsDao.getGoodsImage(goodsId);
		 manager.commitAndClose();
		
	   }catch(Exception e){
		e.printStackTrace();
	    manager.rollbackAndClose();	
	}
	return goodsImage;
	}



	public void delete(Integer goodsId) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		goodsDao.deleteGoodsById(goodsId);
	    manager.commitAndClose();
		
	   }catch(Exception e){
		e.printStackTrace();
	  manager.rollbackAndClose();	
	}
		
	}


	public List<Goods> loadAll() {
		// TODO Auto-generated method stub
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		List<Goods> gooList = null;
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		try{
		   gooList = goodsDao.loadAll();
	        manager.commitAndClose();
		
	     }catch(Exception e){
		    e.printStackTrace();
	        manager.rollbackAndClose();	
	  }
	  return gooList;
	}


	public List<Category> getSubCtg(int ctgPid) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		List<Category> categoryList = null;
		try{
		GoodsDao goodsDao = new GoodsDaoJDBCImpl();
		
		categoryList =  goodsDao.getSubCtgs(ctgPid);
	    manager.commitAndClose();
		
	    }catch(Exception e){
		e.printStackTrace();
	    manager.rollbackAndClose();	
	}
	 return categoryList;
	
	}

}
