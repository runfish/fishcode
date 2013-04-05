/**
 * 
 */
package net.dfrz.supershop01.dao;

import net.dfrz.supershop01.daoimpl.CategoryDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealDaoJDBCImpl;
import net.dfrz.supershop01.daoimpl.DealItemDaoJDBCImpl;


/**
 * @author ctd
 *
 */
public class DaoFactory {
	
	
	public static Object getDao(String daoName){
		if("CategoryDao".equals(daoName))
		{
			return  new CategoryDaoJDBCImpl();
		}
		else if("DealDao".equals(daoName))
		{
			return new DealDaoJDBCImpl();
		}
		else if("DealItemDao".equals(daoName))
		{
			return new DealItemDaoJDBCImpl();
		}
		else if("GoodsDao".equals(daoName))
		{
			return null;
		}
		else if("AdministratorDao".equals(daoName))
		{
			return null;
		}
		else if("CustomerDao".equals(daoName))
		{
			return null;
		}
		
		return null;
	}

}