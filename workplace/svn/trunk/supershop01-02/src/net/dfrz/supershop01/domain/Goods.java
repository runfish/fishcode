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
	 * ��Ʒ   (CRUD)
       ����:  ��Ʒ���
             ��Ʒ����
             ��Ʒ����
             �Ƿ�ȱ��
             ��Ʒ����
             ��ƷͼƬ
             ��Ʒ�����
             ��Ʒ���
             ��Ʒ����Ա���
            

	 */
	private int goodsId;//��Ʒ���
	
	private String goodsName;//��Ʒ����
	
	private double goodsPrice;//��Ʒ�۸�
	
	private int goodsIsEmpty;//��Ʒ�Ƿ�ȱ��
	
	private String goodsDesc;//��Ʒ����
	
	private byte[] goodsImage;//��Ʒ��ͼƬ
	
	private int goodsCtgId;//��Ʒ���������
	
	private int goodsQty;//��Ʒ�Ŀ������
	
	private int goodsAdminId;//��Ʒ�����Ĺ���Ա

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
