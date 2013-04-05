package lh.xiaoyu;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	
	private String uesrName =null;
	private String passWord =null;
	
	
	
	
	public String getUesrName() {
		return uesrName;
	}
	public void setUesrName(String uesrName) {
		this.uesrName = uesrName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
