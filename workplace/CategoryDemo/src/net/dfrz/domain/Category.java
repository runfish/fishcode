/**
 * 
 */
package net.dfrz.domain;

import java.util.List;

/**
 * @author ctd
 *
 */
public class Category {
	
	private Integer ctgId;
	private String  ctgName;
	private String  linkUrl;
	private Category parentCtg;
	private List<Category> ctgs;//子类表列表
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Category(Integer ctgId) {
		super();
		this.ctgId = ctgId;
	}


	public Integer getCtgId() {
		return ctgId;
	}
	public void setCtgId(Integer ctgId) {
		this.ctgId = ctgId;
	}
	public String getCtgName() {
		return ctgName;
	}
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public List<Category> getCtgs() {
		return ctgs;
	}
	public void setCtgs(List<Category> ctgs) {
		this.ctgs = ctgs;
	}
	public Category getParentCtg() {
		return parentCtg;
	}
	public void setParentCtg(Category parentCtg) {
		this.parentCtg = parentCtg;
	}
	
	
	
}
