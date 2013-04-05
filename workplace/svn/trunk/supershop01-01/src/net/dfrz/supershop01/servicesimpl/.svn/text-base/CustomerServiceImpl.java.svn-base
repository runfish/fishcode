/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.daoimpl.CustomerDaoJDBCImpl;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.services.CustomerService;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.TransactionManager;

/**
 * @author Administrator
 *
 */
public class CustomerServiceImpl implements CustomerService {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#create(net.dfrz.supershop01.domain.Customer)
	 */
	
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		try{
			manager.beginTransaction();
			customerDao.add(customer);
		    manager.commitAndClose();
				
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#getCustomerByName(java.lang.String)
	 */
	
	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		Customer customer = null;
		try{
			 manager.beginTransaction();
			 customer = customerDao.getCustomerByName(name);
			 manager.commitAndClose();
				
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}
		return customer;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.services.CustomerService#modifyCustomer(net.dfrz.supershop01.domain.Customer)
	 */
	
	public void modifyCustomer(Customer customer) {
		// TODO Auto-generated method stub
		TransactionManager manager = DBUtils.getInstance().getTranManager();
		CustomerDao customerDao = new CustomerDaoJDBCImpl();
		try{
			 manager.beginTransaction();
			 customerDao.updateCustomer(customer);
			 manager.commitAndClose();
				
		}catch(Exception e){
			e.printStackTrace();
		  manager.rollbackAndClose();	
		}

	}

}
