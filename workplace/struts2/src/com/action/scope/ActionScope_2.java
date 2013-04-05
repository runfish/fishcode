package com.action.scope;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.action.servletobj.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class ActionScope_2 extends BaseAction {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// 获取作用域中的Map对象

		// ServletActionContext

		ActionContext actionContext = ActionContext.getContext();

		Map<String, Object> sessionMap = actionContext.getSession();

		Map<String, Object> appMap = actionContext.getApplication();

		// 不建议用map对象去获取request作用域的数据
		Map<String, Object> requestMap = (Map<String, Object>) actionContext
				.get("request");

		sessionMap.put("ses_key", "session中的数据");

		appMap.put("app_key", "application作用域中的数据");

		requestMap.put("req_key", "request作用域中的对象");

		return "scope2";
	}

}
