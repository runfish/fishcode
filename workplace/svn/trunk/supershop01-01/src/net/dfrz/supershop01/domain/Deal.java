/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.sql.Date;

/**                
 * Project: supershop01-02
 * ClassName: Deal                                                     
 * Module ID: 4.6  
 * Comments: 定义商品订单对象的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-1-8
 * @see java.sql.Date                                              
 * @see #dealId 
 * @see #dealCustomerId  
 * @see #consigneeInfo
 * @see #payPattern
 * @see #receivePattern
 * @see #itemAmount
 * @see #getDealId()
 * @see #getDealCustomerId()
 * @see #getConsigneeInfo()
 * @see #getPayPattern()
 * @see #getReceivePattern()
 * @see #getItemAmount()
 * @see #setDealId(Integer) 
 * @see #setDealCustomerId(Integer) 
 * @see #setConsigneeInfo(String)
 * @see #setPayPattern(String)
 * @see #setReceivePattern(String)
 * @see #setItemAmount(Integer)
 * @see #toString()                            
 * @Author J1205-HongHG                                                      
 * @version Version 138                                       
*/

public class Deal extends ObjectValue {
	/**
	 * 订单编号
	 */
	private static Integer dealId=10000; 
	/**
	 * 订单用户编号
	 */
	private Integer dealCustomerId;
	/**
	 * 订单收货人信息（包括收获人姓名、联系方式、收货地址、邮政编码、电子邮箱）
	 */
	private String consigneeInfo;
	/**
	 * 订单付款方式
	 */
	private String  payPattern;
	/**
	 * 订单商品收货方式
	 */
	private String receivePattern;
	/**
	 * 订单条目数量
	 */
	private Integer itemAmount;
	/**
	 * 订单状态
	 */
	private String dealStatus;
	/**
	 * 下单日期
	 */
	private Date dealDate;
	/**
	 * 订单审核时间
	 */
	private Date dealExamDate;
   /**
    * 获取订单的编号
    * @return Integer
    */
	public synchronized Integer getDealId() {
		return dealId;
	}
	/**
	 * 修改订单编号
	 * @param dealId -订单编号
	 */
	public synchronized void setDealId(Integer dealId) {
			
			Deal.dealId = dealId;
	}
	/**
	 * 获取下单的用户编号
	 * @return Integer
	 */
	public Integer getDealCustomerId() {
		return dealCustomerId;
	}
	/**
	 * 修改下单的用户编号
	 * @param dealCustomerId -订单所属用户编号
	 */
	public void setDealCustomerId(Integer dealCustomerId) {
		this.dealCustomerId = dealCustomerId;
	}
	/**
	 * 获取订单的收货人信息
	 * @return String
	 */
	public String getConsigneeInfo() {
		return consigneeInfo;
	}
	/**
	 * 修改订单的收货人信息
	 * @param consigneeInfo -订单的收货人信息
	 */
	public void setConsigneeInfo(String consigneeInfo) {
		this.consigneeInfo = consigneeInfo;
	}
	/**
	 * 获取订单的付款方式
	 * @return String
	 */
	public String getPayPattern() {
		return payPattern;
	}
	/**
	 * 修改订单的付款方式
	 * @param payPattern -订单的付款方式
	 */
	public void setPayPattern(String payPattern) {
		this.payPattern = payPattern;
	}
	/**
	 * 获取订单商品的收货方式
	 * @return String
	 */
	public String getReceivePattern() {
		return receivePattern;
	}
	/**
	 * 修改订单商品的收货方式
	 * @param receivePattern -订单商品的收货方式
	 */
	public void setReceivePattern(String receivePattern) {
		this.receivePattern = receivePattern;
	}
	/**
	 * 获取订单条目数量
	 * @return Integer
	 */
	public Integer getItemAmount() {
		return itemAmount;
	}
	/**
	 * 修改订单条目数量
	 * @param itemAmount -当前订单所属的条目数量
	 */
	public void setItemAmount(Integer itemAmount) {
		this.itemAmount = itemAmount;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	public Date getDealExamDate() {
		return dealExamDate;
	}
	public void setDealExamDate(Date dealExamDate) {
		this.dealExamDate = dealExamDate;
	}
	/**
	 * 订单对象的格式化形式输出
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return this.consigneeInfo+":"+this.payPattern+":"+this.receivePattern;
	}
}
