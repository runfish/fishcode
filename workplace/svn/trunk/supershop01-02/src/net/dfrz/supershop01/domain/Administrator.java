/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * @author hhg0012
 *
 */
public class Administrator extends ObjectValue {

	/**
	 * 
	 */
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	
	private int administratorId;
	
	private String administratorName;
	
	private String administratorPassword;
	
	private String realName;
	
	private String birthday;
	
	private String email;
	
	private String telNum;
	
	private String address;
	
	private String postCode;
	
	private boolean isSuperAdministrator;

	public int getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}



	public String getAdministratorName() {
		return administratorName;
	}

	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}

	public String getAdministratorPassword() {
		return administratorPassword;
	}

	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public boolean getIsSuperAdministrator() {
		return isSuperAdministrator;
	}

	public void setSuperAdministrator(Boolean isSuperAdministrator2) {
		this.isSuperAdministrator = isSuperAdministrator2;
	}
}
