/**
 * 
 */
package net.dfrz.supershop01.dao;



import java.util.List;

import net.dfrz.supershop01.domain.Administrator;

/**
 * @author hhg0012
 *
 */
public interface AdministratorDao {
	
	 void save(Administrator administrator);
	 Administrator getAdministratorById(int administratorId);
	 Administrator getAdministratorByName(String administratorName);
	 List<Administrator> loadAll();
	 void update (Administrator administrator);
	 void delete(int adminId);
	 int getMaxId();
	 

}
