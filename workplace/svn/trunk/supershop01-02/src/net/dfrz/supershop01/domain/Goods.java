/**
 * 
 */
package net.dfrz.supershop01.domain;

/**
 * @author YDP1205
 *
 */
public class Goods extends ObjectValue {

	/**
	 * 
	 */
	public Goods() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 商品   (CRUD)
       属性:  商品编号
             商品名称
             商品单价
             是否缺货
             商品描述
             商品图片
             商品类别编号
             商品库存
             商品管理员编号
            

	 */
	private int goodsId;//商品编号
	
	private String goodsName;//商品名称
	
	private double goodsPrice;//商品价格
	
	private int goodsIsEmpty;//商品是否缺货
	
	private String goodsDesc;//商品描述
	
	private byte[] goodsImage;//商品的图片
	
	private int goodsCtgId;//商品所属类别编号
	
	private int goodsQty;//商品的库存数量
	
	private int goodsAdminId;//商品所属的管理员

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}





	public int getGoodsIsEmpty() {
		return goodsIsEmpty;
	}

	public void setGoodsIsEmpty(int goodsIsEmpty) {
		this.goodsIsEmpty = goodsIsEmpty;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public byte[] getGoodsImage() {
		return goodsImage;
	}

	public void setGoodsImage(byte[] goodsImage) {
		this.goodsImage = goodsImage;
	}

	public int getGoodsCtgId() {
		return goodsCtgId;
	}

	public void setGoodsCtgId(int goodsCtgId) {
		this.goodsCtgId = goodsCtgId;
	}

	public int getGoodsQty() {
		return goodsQty;
	}

	public void setGoodsQty(int goodsQty) {
		this.goodsQty = goodsQty;
	}

	public int getGoodsAdminId() {
		return goodsAdminId;
	}

	public void setGoodsAdminId(int goodsAdminId) {
		this.goodsAdminId = goodsAdminId;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return goodsId+":"+goodsName+":"+goodsPrice+":"+goodsIsEmpty+":"+goodsDesc
		       +":"+goodsCtgId+":"+goodsQty+":"+goodsAdminId;
	}


}
