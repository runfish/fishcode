package net.dfrz.smmgr01.domain;

/**
 * 
 */

/**
 * @author ctd
 *  商品类别   (CRUD)
     属性： 类别编号
            类别名称
 *
 */
public class Category extends ObjectValue {

	private int ctgId;
	private String ctgName;
	public int getCtgId() {
		return ctgId;
	}
	public void setCtgId(int ctgId) {
		this.ctgId = ctgId;
	}
	public String getCtgName() {
		return ctgName;
	}
	public void setCtgName(String ctgName) {
		this.ctgName = ctgName;
	}
}
