/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.DealDao;
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.domain.Deal;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.services.DealItemService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * Project: supershop01-02
 * ClassName: DealItemServiceImpl                                                        
 * Module ID: 4.6  
 * Comments: 在业务层为订单类对象提供数据删除，修改，分页显示的功能,DealService的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-9
 * @see Exception
 * @see net.dfrz.supershop01.utils.TransactionManager
 * @see net.dfrz.supershop01.dao.DealItemDao
 * @see net.dfrz.supershop01.daoimpl.DealItemDaoJDBCImpl
 * @see net.dfrz.supershop01.domain.DealItem
 * @see net.dfrz.supershop01.services.DealItemService
 * @see net.dfrz.supershop01.utils.Page
 *@author J1205-HongHG
 *@version Version 1
 */
public class DealItemServiceImpl implements DealItemService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#deleteDeal(net.dfrz.supershop01.domain.Deal)
	 */
	public void deleteDealItem(DealItem dealItem) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			DealDao dealDao=(DealDao)DaoFactory.getDao("DealDao");
			dealItemDao.delete(dealItem);
			Deal deal=dealDao.getDealById(dealItem.getDealId());
			int itemAmount=deal.getItemAmount();
			itemAmount--;
			deal.setItemAmount(itemAmount);
			dealDao.update(deal);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#loadPage(net.dfrz.supershop01.utils.Page, net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public Page loadPage(Page pagedDealItem ,int dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			int totalRecNum=dealItemDao.countDealItem(dealId);
			pagedDealItem.setTotalRecNum((long)totalRecNum);
			pagedDealItem.setPageContent(dealItemDao.loadPage(pagedDealItem.getStartIndex(),pagedDealItem.getEndIndex(),dealId));
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return pagedDealItem;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#updateDeal(net.dfrz.supershop01.domain.Deal)
	 */
	public void updateDealItem(DealItem dealItem) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItemDao.update(dealItem);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.DealService#getDealById(java.lang.Integer)()
	 */
	public DealItem getDealItemById(Integer dealId) {
		// TODO Auto-generated method stub
		TransactionManager manager=DBUtils.getTranManager();
		DealItem dealItem=null;
		try
		{
			manager.beginTransaction();
			DealItemDao dealItemDao=(DealItemDao)DaoFactory.getDao("DealItemDao");
			dealItem=dealItemDao.getDealItemById(dealId);
			manager.commitAndClose();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			manager.rollbackAndClose();
		}
		return dealItem;
	}
}
