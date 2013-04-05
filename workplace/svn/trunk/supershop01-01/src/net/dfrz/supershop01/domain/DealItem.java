/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.sql.Date;

/**                
 * Project: supershop01-02
 * ClassName: DealItem                                                       
 * Module ID: 4.6  
 * Comments: 定义商品订单条目对象的模版  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-1
 * @see java.sql.Date                                              
 * @see #toString()                            
 * @Author J1205-HongHG                                                      
 * @version Version 3                                        
*/

public class DealItem extends ObjectValue {
	/**
	 * 订单条目编号
	 */
	private Integer itemId; 
	/**
	 * 订单编号
	 */
	private Integer dealId;
	/**
	 * 商品单价
	 */
	private Double itemGoodsPrice;
	/**
	 * 订单商品数量
	 */
	private Integer itemGoodsQty;
	/**
	 * 订单商品编号
	 */
	private Integer dealGoodsId; 
	/**
	 * 订单商品类型编号
	 */
	private Integer dealGoodsCtgId;
	/**
	 * 订单管理员编号
	 */
	private Integer dealAdminId;
	
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getDealId() {
		return dealId;
	}

	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	public Double getItemGoodsPrice() {
		return itemGoodsPrice;
	}

	public void setItemGoodsPrice(Double itemGoodsPrice) {
		this.itemGoodsPrice = itemGoodsPrice;
	}

	public Integer getItemGoodsQty() {
		return itemGoodsQty;
	}

	public void setItemGoodsQty(Integer itemGoodsQty) {
		this.itemGoodsQty = itemGoodsQty;
	}

	public Integer getDealGoodsId() {
		return dealGoodsId;
	}

	public void setDealGoodsId(Integer dealGoodsId) {
		this.dealGoodsId = dealGoodsId;
	}

	public Integer getDealGoodsCtgId() {
		return dealGoodsCtgId;
	}

	public void setDealGoodsCtgId(Integer dealGoodsCtgId) {
		this.dealGoodsCtgId = dealGoodsCtgId;
	}

	public Integer getDealAdminId() {
		return dealAdminId;
	}

	public void setDealAdminId(Integer dealAdminId) {
		this.dealAdminId = dealAdminId;
	}

	/**
	 * 订单对象的格式化形式输出
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return this.itemId+":"+this.itemGoodsPrice+":"+this.itemGoodsQty+":"
		     +":"+this.dealGoodsId+":"+this.dealGoodsCtgId;
	}
	
}
