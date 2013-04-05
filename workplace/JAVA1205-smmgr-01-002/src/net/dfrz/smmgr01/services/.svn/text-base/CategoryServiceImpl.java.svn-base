/**
 * 
 */
package net.dfrz.smmgr01.services;

import java.util.ArrayList;
import java.util.List;

import net.dfrz.smmgr01.dao.CategoryDao;
import net.dfrz.smmgr01.dao.CategoryDaoJDBCImpl;
import net.dfrz.smmgr01.dao.GoodsDao;
import net.dfrz.smmgr01.dao.GoodsDaoJDBCImpl;
import net.dfrz.smmgr01.domain.Category;
import net.dfrz.smmgr01.exception.ApplicationException;
import net.dfrz.smmgr01.utils.Page;

/**
 * @author YDP
 *
 */
public class CategoryServiceImpl implements CategoryService {

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.CategoryService#addCtg(net.dfrz.smmgr01.domain.Category)
	 */
	public void addCtg(Category ctg) {
		// TODO Auto-generated method stub
		CategoryDao ctgDao = new CategoryDaoJDBCImpl();
		
		ctgDao.add(ctg);
	

	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.CategoryService#deleteCtg(net.dfrz.smmgr01.domain.Category)
	 */
	public void deleteCtg(Category ctg) {
		// TODO Auto-generated method stub
		CategoryDao ctgDao = new CategoryDaoJDBCImpl();
		ctgDao.delete(ctg);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.CategoryService#getGoodsById(int)
	 */
	public Category getCategoryById(int ctgId) {
		// TODO Auto-generated method stub
		CategoryDao ctgDao = new CategoryDaoJDBCImpl();
		return ctgDao.getCategoryById(ctgId);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.CategoryService#loadAll()
	 */
	public List<Category> loadAll() {
		// TODO Auto-generated method stub
		CategoryDao ctgDao = new CategoryDaoJDBCImpl();
		return ctgDao.loadAll();
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr01.services.CategoryService#updateCtg(net.dfrz.smmgr01.domain.Category)
	 */
	public void updateCtg(Category ctg) {
		// TODO Auto-generated method stub
		CategoryDao ctgDao = new CategoryDaoJDBCImpl();
		ctgDao.update(ctg);

	}

	public Page loadPageAll(Page page) {
		// TODO Auto-generated method stub
		CategoryDao categorydao = new CategoryDaoJDBCImpl();
		int totalRecNum=categorydao.countCategory();
		page.setTotalRecNum((long)totalRecNum);
		page.setPageContent(categorydao.loadPageAll(page.getStartIndex(), page.getEndIndex()));
		return page;
	}


}
