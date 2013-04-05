/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.sql.Date;

/**
 * @author hhg0012
 *
 */
public class Customer extends ObjectValue {

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	private String customerId;
	private String customerName;
	private String customerPassword;
	private String customerRealname;
	private Date customerBirthday;
	private String customerMail;
	private String customerTel;
	private String customerAddress;
	private String customerPostCode;
	private int    isFreeze;
	
	
	
	
	public int getIsFreeze() {
		return isFreeze;
	}
	public void setIsFreeze(int isFreeze) {
		this.isFreeze = isFreeze;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * @return the customerPassword
	 */
	public String getCustomerPassword() {
		return customerPassword;
	}
	/**
	 * @param customerPassword the customerPassword to set
	 */
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	/**
	 * @return the customerRealname
	 */
	public String getCustomerRealname() {
		return customerRealname;
	}
	/**
	 * @param customerRealname the customerRealname to set
	 */
	public void setCustomerRealname(String customerRealname) {
		this.customerRealname = customerRealname;
	}

	/**
	 * @return the customerBirthday
	 */
	public Date getCustomerBirthday() {
		return customerBirthday;
	}
	/**
	 * @param customerBirthday the customerBirthday to set
	 */
	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}
	/**
	 * @return the customerMail
	 */
	public String getCustomerMail() {
		return customerMail;
	}
	/**
	 * @param customerMail the customerMail to set
	 */
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	/**
	 * @return the customerTel
	 */
	public String getCustomerTel() {
		return customerTel;
	}
	/**
	 * @param customerTel the customerTel to set
	 */
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	/**
	 * @return the customerAddress
	 */
	public String getCustomerAddress() {
		return customerAddress;
	}
	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	/**
	 * @return the customerPostCode
	 */
	public String getCustomerPostCode() {
		return customerPostCode;
	}
	/**
	 * @param customerPostCode the customerPostCode to set
	 */
	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}
	
	
	
	
	
	

}
