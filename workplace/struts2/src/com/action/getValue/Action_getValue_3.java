package com.action.getValue;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Action_getValue_3 extends ActionSupport implements ModelDriven<ClassBean>  {

	
	private ClassBean classBean = new ClassBean();

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("classid="+this.getModel().getClassid()+"classname="+getModel().getClassname());
		return null;
	}

	@Override
	public ClassBean getModel() {
		// TODO Auto-generated method stub
		return classBean;
	}

}
