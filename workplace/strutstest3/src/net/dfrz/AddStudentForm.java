package net.dfrz;

import java.sql.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "sname="+this.sname+"school="+this.school+"birth="+this.birth+"sorce="+this.sorce;
	}


	
	
	
	
	
 
}
