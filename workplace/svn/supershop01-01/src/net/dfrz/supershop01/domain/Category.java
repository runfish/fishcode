/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * Project: supershop01-01
 * ClassName: Category
 * Module ID: 3.6 
 * Comments: 定义商品类别对象的模版
 * JDK :jdk1.6.0_10
 * Create Date： 2013-1-8
 * @see #ctgId
 * @see #ctgName
 * @see #ctgRank
 * @author: J1205-YouHQ
 * @version: Version 3
 */
public class Category {
	/**
	 * 商品类别编号
	 */
	private Integer ctgId;
	/**
	 * 商品类别名称
	 */
	private String ctgName;
	/**
	 * 商品类别等级
	 */
	private Integer ctgRank;
	
	
	/**
	 * 获取商品类别编号
	 * @return Integer
	 */
	public Integer getCtgId() {
		return ctgId;
	}
	/**
	 * 修改商品类别编号
	 * @param ctgId
	 */
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	/**
	 * 获取商品类别名称
	 * @return String
	 */
	public String getCtgName() {
		return ctgName;
	}
	/**
	 * 修改商品类别名称
	 * @param ctgName
	 */
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
	/**
	 * 获取商品类别等级
	 * @return Integer
	 */
	public Integer getCtgRank() {
		return ctgRank;
	}
	/**
	 * 修改商品类别等级
	 * @param ctgRank
	 */
	public void setCtgRank(Integer ctgRank) {
		this.ctgRank = ctgRank;
	}
	

}
