package com.henme.controller;

import com.jfinal.aop.PrototypeInterceptor;
import com.jfinal.core.ActionInvocation;

public class BlogPageInfo extends PrototypeInterceptor {
	private BlogController controller;
	
	Integer pageNum;
	Integer numPerPage;
	Integer id;
	String title;
	String content;
	String orderName;
	String orderType;

	private void initPara(ActionInvocation ai) {
		controller = (BlogController) ai.getController();
		pageNum = controller.getParaToInt("pageNum", 1); 
		numPerPage = controller.getParaToInt("numPerPage", 10); 
		id = controller.getParaToInt("id");
		title = controller.getPara("title");
		content = controller.getPara("content");
		orderName = controller.getPara("orderName","id");
		orderType = controller.getPara("orderType","desc");
	}

	public void doIntercept(ActionInvocation ai) {
		initPara(ai);
		controller.keepPara();
		controller.setAttr("pageInfo", this);
		ai.invoke();
	}

}