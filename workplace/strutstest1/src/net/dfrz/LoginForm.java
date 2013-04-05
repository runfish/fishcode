/**
 * 
 */
package net.dfrz;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 *
 */
public class LoginForm extends ActionForm {
	
	private String userName = null;
	
	private String passWord = null;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	

}
