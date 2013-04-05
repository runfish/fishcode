package com.action.scope;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.action.servletobj.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class ActionScope_2 extends BaseAction {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		// ��ȡ�������е�Map����

		// ServletActionContext

		ActionContext actionContext = ActionContext.getContext();

		Map<String, Object> sessionMap = actionContext.getSession();

		Map<String, Object> appMap = actionContext.getApplication();

		// ��������map����ȥ��ȡrequest�����������
		Map<String, Object> requestMap = (Map<String, Object>) actionContext
				.get("request");

		sessionMap.put("ses_key", "session�е�����");

		appMap.put("app_key", "application�������е�����");

		requestMap.put("req_key", "request�������еĶ���");

		return "scope2";
	}

}
