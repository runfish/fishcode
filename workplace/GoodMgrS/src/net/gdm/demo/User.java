/**
 * 
 */
package net.gdm.demo;

import java.util.Date;
/**
 * @author Administrator
 *
 */
public class User {
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String user_real_name;
	private String user_sex;
	private Date user_date;      //Date
	private String user_email;
	private String user_phone;     //应该是string，用 js 验证是否是电话号码
	private String user_addr;
	private String user_postcode;    //应该是string，用 js 验证是否是6位数
	private String user_status;   //应该不用boolean型 ，用char 或string 更容易保存到数据库
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_real_name() {
		return user_real_name;
	}
	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public Date getUser_date() {
		return user_date;
	}
	public void setUser_date(Date user_date) {
		this.user_date = user_date;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_postcode() {
		return user_postcode;
	}
	public void setUser_postcode(String user_postcode) {
		this.user_postcode = user_postcode;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	

}
