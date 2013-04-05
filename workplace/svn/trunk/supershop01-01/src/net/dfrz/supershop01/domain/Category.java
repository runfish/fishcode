/**
 * 
 */
package net.dfrz.supershop01.domain;

import java.util.List;


/**
 * Project: supershop01-02
 * ClassName: Category
 * Module ID: 3.6 
 * Comments: ������Ʒ�������ģ��
 * JDK :jdk1.6.0_10
 * Create Date�� 2013-1-8
 * @see #ctgId
 * @see #ctgName
 * @see #ctgRank
 * @author: J1205-YouHQ
 * @version: Version 3
 */
public class Category {
	public Category() {
		super();
	}
	public Category(Integer ctgId) {
		super();
		this.ctgId = ctgId;
	}
	/**
	 * ��Ʒ�����
	 */
	private Integer ctgId;
	/**
	 * ��Ʒ�������
	 */
	private String ctgName;
	/**
	 * ��Ʒ���״̬
	 */
	private String ctgStatus; 
	/**
	 * ������б�
	 */
	private List<SmallCategory> smallCategory;
	
	
	/**
	 * ��ȡ��Ʒ�����
	 * @return Integer
	 */
	public Integer getCtgId() {
		return ctgId;
	}
	/**
	 * �޸���Ʒ�����
	 * @param ctgId
	 */
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	/**
	 * ��ȡ��Ʒ�������
	 * @return String
	 */
	public String getCtgName() {
		return ctgName;
	}
	/**
	 * �޸���Ʒ�������
	 * @param ctgName
	 */
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
	/**
	 * ��ȡ��Ʒ���״̬
	 * @return Integer
	 */
	public String getCtgStatus() {
		return ctgStatus;
	}
	/**
	 * �޸���Ʒ���״̬
	 * @param ctgRank
	 */
	public void setCtgStatus(String ctgStatus) {
		this.ctgStatus = ctgStatus;
	}
	/**
	 * ��ȡ������б�
	 * @return ctgs
	 */
	public List<SmallCategory> getSmallCategory() {
		return smallCategory;
	}
	/**
	 * �޸�������б�
	 * @param ctgs
	 */
	public void setSmallCategory(List<SmallCategory> smallCategory) {
		this.smallCategory = smallCategory;
	}
	

	public String toString() {
		// TODO Auto-generated method stub
		return this.ctgId+":"+this.ctgName+":"+this.ctgStatus;
	}
}
