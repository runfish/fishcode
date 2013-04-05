/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import java.util.List;


import net.dfrz.supershop01.dao.AdministratorDao;
import net.dfrz.supershop01.daoimpl.AdministratorDaoXMLImpl;
import net.dfrz.supershop01.domain.Administrator;
import net.dfrz.supershop01.exception.ServiceRunTimeException;
import net.dfrz.supershop01.services.AdministratorService;

/**
 * @author Administrator
 *
 */
public class AdministratorServiceImpl implements AdministratorService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#delete(java.lang.Integer)
	 */
	public void delete(int adminId) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		administratorDao.delete(adminId);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#getAdministratorById(java.lang.Integer)
	 */
	public Administrator getAdministratorById(int administratorId) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		Administrator administrator = administratorDao.getAdministratorById(administratorId);
		if(administrator==null)
		{
			throw new ServiceRunTimeException("�ù���Ա�û������ڣ�����������!");
		}
		
		return administrator;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#loadAll()
	 */
	public List<Administrator> loadAll() {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		List<Administrator> administratorList = administratorDao.loadAll();
		
		return administratorList;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#save(net.dfrz.supershop01.domain.Administrator)
	 */

	public void save(Administrator administrator) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		
		administratorDao.save(administrator);

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.AdministratorService#update(net.dfrz.supershop01.domain.Administrator)
	 */
	public void update(Administrator administrator) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		administratorDao.update(administrator);

	}

	public int getMax() {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		return administratorDao.getMaxId();
	}

	public Administrator getAdministratorByName(String administratorName) {
		// TODO Auto-generated method stub
		AdministratorDao administratorDao = new AdministratorDaoXMLImpl();
		return administratorDao.getAdministratorByName(administratorName);
	}

}