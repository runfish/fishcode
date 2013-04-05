package net.dfrz;

import java.sql.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddStudentForm extends ActionForm {
	
	private  String sname =null;
	
	private  String school = null;
	
	private  float sorce = 0;
	
	private Date birth = null;

	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/**
	 * @return the sorce
	 */
	public float getSorce() {
		return sorce;
	}

	/**
	 * @param sorce the sorce to set
	 */
	public void setSorce(float sorce) {
		this.sorce = sorce;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
		System.out.println("set Method"+System.currentTimeMillis());
	}

	public AddStudentForm() {

		System.out.println("in addStudentForm constructor"+System.currentTimeMillis());
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.ServletRequest)
	 */
	@Override
	public void reset(ActionMapping mapping, ServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("in reset servletrequest Method");
		

	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#reset(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void reset(ActionMapping actionmapping,
			HttpServletRequest httpservletrequest) {
		// TODO Auto-generated method stub
		System.out.println("in reset httpservletrequest Method");
		
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("in the validate method");
		ActionErrors errors = new ActionErrors();
		ActionMessage message =new ActionMessage("hehe");
		errors.add("error",message);
		return errors;
	}
	
	
	
	
	
 
}
