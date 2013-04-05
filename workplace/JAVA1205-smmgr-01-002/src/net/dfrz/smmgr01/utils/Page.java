/**
 * 
 */
package net.dfrz.smmgr01.utils;

import java.util.Collection;

/**
 * @author JOEYANG ONG
 *
 */
public class Page {
	
    private Integer pageNo;    //��ǰҳ��
    private Integer pageSize;  //ÿҳ��¼����
    private Boolean nextPage;  //�Ƿ�����һҳ
    private Boolean prePage;   //�Ƿ�����һҳ
    private Long totalRecNum;  //�ܹ��ж�������¼
    private Integer totalPageNum;//�ܹ�����ҳ
    private Collection pageContent; //��ҳ������(��¼��ϸ)
    private Integer startIndex; //��¼��ʼλ��
    private Integer endIndex;   //��¼����λ��
        
	public Page() {
		super();
        pageNo=1;
        pageSize=4;
	}
	
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Boolean getNextPage() {
		return pageNo<getTotalPageNum()?true:false;
	}

	public Boolean getPrePage() {
		return pageNo>1?true:false;
	}

	public Long getTotalRecNum() {
		return totalRecNum;
	}
	public void setTotalRecNum(Long totalRecNum) {
		this.totalRecNum = totalRecNum;
	}
	
	public Integer getTotalPageNum() {
		//13%5=3  13/5+1=3
		return totalRecNum%pageSize>0?(int)(totalRecNum/pageSize+1):(int)(totalRecNum/pageSize);
	}

	public Collection getPageContent() {
		return pageContent;
	}
	
	public void setPageContent(Collection pageContent) {
		this.pageContent = pageContent;
	}
    
	public int getStartIndex()
	{
		return pageSize*(pageNo-1)+1;  // size:10 pageno:3   21
	}
    
	public int getEndIndex()
	{
		return (pageSize*pageNo>this.totalRecNum)? (int)(this.totalRecNum.longValue()):(pageSize*pageNo);
	}
    
}