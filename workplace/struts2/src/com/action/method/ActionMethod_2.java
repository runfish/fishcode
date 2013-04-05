package com.action.method;

import com.opensymphony.xwork2.ActionSupport;

public class ActionMethod_2 extends ActionSupport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行execute方法");
		return null;
	}

	public String save() throws Exception {

		System.out.println("保存方法");

		return "save";
	}

	public String list() throws Exception {

		System.out.println("列表方法");

		return "list";
	}

	public String update() throws Exception {

		System.out.println("更新方法");

		return "update";
	}

	public String delete() throws Exception {

		System.out.println("删除方法");

		return "delete";
	}

}
