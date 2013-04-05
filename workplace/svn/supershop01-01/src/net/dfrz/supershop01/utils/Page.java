package net.dfrz.supershop01.utils;

import java.util.Collection;

import net.dfrz.supershop01.domain.ObjectValue;


public class Page extends ObjectValue {
	
	private Integer currentPageNo;        //记录当前页号
	private Boolean prePage;              //判断是否有前一页
	private Boolean nextPage;             //判断是否有下一页
	private Integer totalPageNo;          //记录总的页数
	private Integer totalRecNo;           //记录总的记录条数
	private Integer pageSize;             //每页记录条数
	private Collection<?>pageContent;     //每页记录的数据
	private Integer startIndex;           //当前页记录开始的位置
	private Integer endIndex;             //当前页记录结束的位置
	/**
	 * 
	 */
	public Page() {
		
		super();
		currentPageNo=1;
		pageSize=10;
	}
	
	public Integer getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(Integer currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public Boolean getPrePage() {
		return currentPageNo>1?true:false;
	}
	public Boolean getNextPage() {
		return (currentPageNo<getTotalPageNo())?true:false;
	}
	public Integer getTotalPageNo() {
		return totalRecNo%pageSize>0?(int)(totalRecNo/pageSize)+1:(int)totalRecNo/pageSize;
	}
	public Integer getTotalRecNo() {
		return totalRecNo;
	}
	public void setTotalRecNo(Integer totalRecNo) {
		this.totalRecNo = totalRecNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Collection<?>getPageContent() {
		return pageContent;
	}
	public void setPageContent(Collection<?>pageContent) {
		this.pageContent = pageContent;
	}
	public Integer getStartIndex() {
		return pageSize*(currentPageNo-1)+1;
	}
	public Integer getEndIndex() {
		
		return (pageSize*currentPageNo>this.totalRecNo)? (int)(this.totalRecNo.longValue()):(pageSize*currentPageNo);
	}
}
