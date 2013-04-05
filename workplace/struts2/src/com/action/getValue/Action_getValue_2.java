package com.action.getValue;

import com.opensymphony.xwork2.ActionSupport;

public class Action_getValue_2 extends ActionSupport  {

  private ClassBean classBean;
  
  public ClassBean getClassBean(){
	  
	  return classBean;
  }
  
  
  
	
	
	/**
 * @param classBean the classBean to set
 */
public void setClassBean(ClassBean classBean) {
	this.classBean = classBean;
}





	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("classid="+this.classBean.getClassid()+"classname="+classBean.getClassname());
		return null;
	}

}
