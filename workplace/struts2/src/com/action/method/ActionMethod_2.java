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
		System.out.println("ִ��execute����");
		return null;
	}

	public String save() throws Exception {

		System.out.println("���淽��");

		return "save";
	}

	public String list() throws Exception {

		System.out.println("�б���");

		return "list";
	}

	public String update() throws Exception {

		System.out.println("���·���");

		return "update";
	}

	public String delete() throws Exception {

		System.out.println("ɾ������");

		return "delete";
	}

}
