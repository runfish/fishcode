/**
 * 
 */
package net.gdm.demo;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class BigCategory {
    private int b_ctg_id;
    private String b_ctg_name;
    private String b_ctg_status;   //应该不用boolean型 ，用char 或string 更容易保存到数据库
    private List<SmallCategory> smallCategory;   //参考老师给的案例，加上 private List<SmallCategory> smallCategory;
	public int getB_ctg_id() {
		return b_ctg_id;
	}
	public void setB_ctg_id(int b_ctg_id) {
		this.b_ctg_id = b_ctg_id;
	}
	public String getB_ctg_name() {
		return b_ctg_name;
	}
	public void setB_ctg_name(String b_ctg_name) {
		this.b_ctg_name = b_ctg_name;
	}
	public String getB_ctg_status() {
		return b_ctg_status;
	}
	public void setB_ctg_status(String b_ctg_status) {
		this.b_ctg_status = b_ctg_status;
	}
	public List<SmallCategory> getSmallCategory() {
		return smallCategory;
	}
	public void setSmallCategory(List<SmallCategory> smallCategory) {
		this.smallCategory = smallCategory;
	}
    
  
}
