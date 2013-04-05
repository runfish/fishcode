/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;

import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.daoimpl.CategoryDaoJDBCImpl;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.services.CategoryService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * @author Administrator
 *
 */
public class CategoryServiceImpl implements CategoryService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#addCtg(net.dfrz.supershop01.domain.Category)
	 */
	public void addCtg(Category ctg) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
			ctgDao.add(ctg);
			manager.commitAndClose();
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#deleteCtg(net.dfrz.supershop01.domain.Category)
	 */
	public void deleteCtg(int ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try 
		{
			manager.beginTransaction();
			CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
			ctgDao.delete(ctgId);
			manager.commitAndClose();
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#getCategoryById(int)
	 */
	public Category getCtgById(int ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		Category ctg=null;
		try 
		{
			manager.beginTransaction();
			CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
			ctg=ctgDao.getCtgById(ctgId);
			manager.commitAndClose();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return ctg;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#loadAll()
	 */
	public List<Category> loadAll() {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		List<Category> ctgList=null;
		try 
		{
			manager.beginTransaction();
		 	ctgList=ctgDao.loadAll();
		 	manager.commitAndClose();
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		
		return ctgList;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CategoryService#updateCtg(net.dfrz.supershop01.domain.Category)
	 */
	public void updateCtg(Category ctg) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		try 
		{
			manager.beginTransaction();
			ctgDao.update(ctg);
			manager.commitAndClose();
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}

	public Page loadPageAll(Page page) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		try 
		{
			manager.beginTransaction();
			int totalRecNum=ctgDao.countCategory();
			page.setTotalRecNum((long)totalRecNum);
			page.setPageContent(ctgDao.loadPageAll(page.getStartIndex(), page.getEndIndex()));
			manager.commitAndClose();
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		
		return page;
	}

	public List<Category> getSubCtgs(Integer ctgId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		CategoryDao ctgDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		List<Category>ctgList=null;
		try 
		{
			manager.beginTransaction();
			ctgList=ctgDao.getSubCtgs(ctgId);
			manager.commitAndClose();
			
		} catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return ctgList;
	}
}
