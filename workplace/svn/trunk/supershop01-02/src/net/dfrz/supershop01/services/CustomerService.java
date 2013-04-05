/**
 * 
 */
package net.dfrz.supershop01.services;

import net.dfrz.supershop01.domain.Customer;

/**
 * @author hhg0012
 *
 */
public interface CustomerService {
	void create(Customer customer);
	Customer getCustomerByName(String name);
	void modifyCustomer(Customer customer);
}
