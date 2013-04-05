/**
 * 
 */
package net.gdm.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Order {
	private int order_id;
	private Date order_time;          //Date
	private double order_account;
	private String pay_mode;
	private String receive_mode;
	private String receiver_name;
	private String receiver_add;
	private String receiver_postcode;    //应该是string，用 js 验证是否是6位数
	private String receiver_phone;     //应该是string，用 js 验证是否是电话号码
	private String receiver_email;
	private String receiver_status;  //应该不用boolean型 ，有多种状态且用char 或string 更容易保存到数据库
	private  User user;        //参考老师给的案例，改为 private  User user
	private List<OrderItem> items = new ArrayList<OrderItem>();//参考老师给的案例，加上 private List<OrderItem> items = new ArrayList<OrderItem>();
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date date) {
		this.order_time = date;
	}
	public double getOrder_account() {
		return order_account;
	}
	public void setOrder_account(double order_account) {
		this.order_account = order_account;
	}
	public String getPay_mode() {
		return pay_mode;
	}
	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	public String getReceive_mode() {
		return receive_mode;
	}
	public void setReceive_mode(String receive_mode) {
		this.receive_mode = receive_mode;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_add() {
		return receiver_add;
	}
	public void setReceiver_add(String receiver_add) {
		this.receiver_add = receiver_add;
	}
	public String getReceiver_postcode() {
		return receiver_postcode;
	}
	public void setReceiver_postcode(String receiver_postcode) {
		this.receiver_postcode = receiver_postcode;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public String getReceiver_email() {
		return receiver_email;
	}
	public void setReceiver_email(String receiver_email) {
		this.receiver_email = receiver_email;
	}
	public String getReceiver_status() {
		return receiver_status;
	}
	public void setReceiver_status(String receiver_status) {
		this.receiver_status = receiver_status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}



	
    

}
