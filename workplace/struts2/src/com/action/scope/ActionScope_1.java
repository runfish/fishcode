package com.action.scope;

import com.action.servletobj.BaseAction;

public class ActionScope_1 extends BaseAction{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub\
		
		this.request.setAttribute("req_key", "Resquest作用域的数据");
		this.session.setAttribute("ses_key", "session");
		this.servletContext.setAttribute("app_key", "application作用域中的数据");
		
		return "scope";
	}

}
