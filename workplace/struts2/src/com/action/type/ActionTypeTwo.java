package com.action.type;

import com.opensymphony.xwork2.Action;

public class ActionTypeTwo implements Action {

	 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("实现了Action接口的Action");
		return this.NONE;
	}

}
