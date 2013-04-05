/**
 * 
 */
package net.dfrz.supershop01.servicesimpl;

/**
 * @author YDPJ1205
 *
 */
public class GoodsQueryHelper {
	
	private String goodsName;//商品名称
	
	private Double minGoodsPrice;//商品最低价格
	
	private Double maxGoodsPrice;//商品最低价格
	
	private String goodsIsEmpty;//商品是否缺货
	
	private Integer goodsCtgId;//商品所属类别编号

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getMinGoodsPrice() {
		return minGoodsPrice;
	}

	public void setMinGoodsPrice(Double Price) {
		this.minGoodsPrice = Price;
	}

	public Double getMaxGoodsPrice() {
		return maxGoodsPrice;
	}

	public void setMaxGoodsPrice(Double maxGoodsPrice) {
		this.maxGoodsPrice = maxGoodsPrice;
	}

	public String getGoodsIsEmpty() {
		return goodsIsEmpty;
	}

	public void setGoodsIsEmpty(String goodsIsEmpty) {
		this.goodsIsEmpty = goodsIsEmpty;
	}

	public Integer getGoodsCtgId() {
		return goodsCtgId;
	}

	public void setGoodsCtgId(Integer goodsCtgId) {
		this.goodsCtgId = goodsCtgId;
	}


	
	
	

}
