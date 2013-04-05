package com.action.getValue;

import com.opensymphony.xwork2.ActionSupport;

public class Action_getValue_1 extends ActionSupport  {


	private String classid;
	
	private String classname;
	
	
	
	
	/**
	 * @return the classid
	 */
	public String getClassid() {
		return classid;
	}




	/**
	 * @param classid the classid to set
	 */
	public void setClassid(String classid) {
		this.classid = classid;
	}




	/**
	 * @return the classname
	 */
	public String getClassname() {
		return classname;
	}




	/**
	 * @param classname the classname to set
	 */
	public void setClassname(String classname) {
		this.classname = classname;
	}




	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("classid="+this.classid+"classname="+this.classname);
		return null;
	}

}
