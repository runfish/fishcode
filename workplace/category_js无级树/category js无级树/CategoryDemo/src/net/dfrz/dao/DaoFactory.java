/**
 * 
 */
package net.dfrz.dao;

/**
 * @author ctd
 *
 */
public class DaoFactory {
	
	
	public static Object getDao(String daoName){
		if("ctgDao".equals(daoName))
			return new CategoryDaoJDBCImpl();
		return null;
	}

}
