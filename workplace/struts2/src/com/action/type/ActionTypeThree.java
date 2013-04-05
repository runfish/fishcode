package com.action.type;

import com.opensymphony.xwork2.ActionSupport;

public class ActionTypeThree extends ActionSupport {
 
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		System.out.println("实现了ActionSupport的Action");

		return this.NONE;
	}

}
