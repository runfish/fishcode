package com.action.type;

import com.opensymphony.xwork2.Action;

public class ActionTypeTwo implements Action {

	 
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ʵ����Action�ӿڵ�Action");
		return this.NONE;
	}

}
