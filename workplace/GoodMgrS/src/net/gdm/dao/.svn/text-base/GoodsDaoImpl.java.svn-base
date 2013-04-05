/**
 * 
 */
package net.gdm.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.gdm.demo.Goods;
import net.gdm.service.GoodsQueryHelper;
import net.gdm.util.OracleUtil;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class GoodsDaoImpl implements GoodsDao {
	 private final static String ADD="insert into goods values(?,?,?,?,?,?,?,?)";
     private final static String LOAD_ALL="select * from goods";
     private final static String UPDATE="update goods set "+
                                        "goods_price=?"+
                                        ",goods_name=?"+
                                        ",goods_desc=?"+
                                        ",goods_pic=?"+
                                        ",goods_store=?"+
                                        ",goods_status=?"+
                                        ",goods_ctg=?"+
                                        "where goods_id=?";
     private final static String DELETE="delete from goods where goods_id=?";
     private final static String GET_ONE="select * from goods where goods_id=?";
     private final static String LOAD_ALL_CTG="select * from goods where goods_ctg=?";
     private static final String SQL_PICS="select goods_pic from goods where goods_id=?";
     /* (non-Javadoc)
	 * @see net.gdm.dao.GoodsDao#ListGoods()
	 */
	public List<Goods> ListGoods() {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<Goods> listgoods=null;
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			listgoods=new ArrayList<Goods>();
            rest=pstmt.executeQuery();
            
            while(rest.next())
            {
            	Goods goods=new Goods();
            	SmallCategoryDao scd=new SmallCategoryDaoImpl();
            	goods.setGoods_id(rest.getInt("goods_id"));
            	goods.setGoods_price(rest.getDouble("goods_price"));
            	goods.setGoods_name(rest.getString("goods_name"));
            	goods.setGoods_desc(rest.getString("goods_desc"));
            	goods.setGoods_pic(rest.getBytes("goods_pic"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setGoods_status(rest.getString("goods_status"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setSmallCategory(scd.getOne(rest.getInt("goods_ctg")));
            	listgoods.add(goods);
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
			 }
		return listgoods;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.GoodsDao#UpdateGoods(net.gdm.demo.Goods)
	 */

	public void UpdateGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setDouble(1, goods.getGoods_price());
			pstmt.setString(2, goods.getGoods_name());
			pstmt.setString(3, goods.getGoods_desc());
			pstmt.setBytes(4, goods.getGoods_pic());
			pstmt.setString(5, goods.getGoods_store());
			pstmt.setString(6, goods.getGoods_status());
			pstmt.setInt(7, goods.getSmallCategory().getS_ctg_id());
			pstmt.setInt(8, goods.getGoods_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
			 }
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.GoodsDao#addGoods(net.gdm.demo.Goods)
	 */
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(ADD);
			pstmt.setDouble(1, goods.getGoods_price());
			pstmt.setInt(2, goods.getGoods_id());
			pstmt.setString(3, goods.getGoods_name());
			pstmt.setString(4, goods.getGoods_desc());
			pstmt.setBytes(5, goods.getGoods_pic());
			pstmt.setString(6, goods.getGoods_store());
			pstmt.setString(7, goods.getGoods_status());
			pstmt.setInt(8, goods.getSmallCategory().getS_ctg_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
			 }
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.GoodsDao#deleteGoods(int)
	 */
	public void deleteGoods(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
			 }
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.GoodsDao#getOne(int)
	 */
	public Goods getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		Goods goods=new Goods();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				SmallCategoryDao scd=new SmallCategoryDaoImpl();
            	goods.setGoods_id(rest.getInt("goods_id"));
            	goods.setGoods_price(rest.getDouble("goods_price"));
            	goods.setGoods_name(rest.getString("goods_name"));
            	goods.setGoods_desc(rest.getString("goods_desc"));
            	goods.setGoods_pic(rest.getBytes("goods_pic"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setGoods_status(rest.getString("goods_status"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setSmallCategory(scd.getOne(rest.getInt("goods_ctg")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
			 }
		return goods;
	}

	@Override
	public byte[] getGoodsPic(Integer id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		byte[] goodPic=null;
			try {
				pstmt=conn.prepareStatement(SQL_PICS);
				pstmt.setInt(1, id);
				rest=pstmt.executeQuery();
				if(rest.next()){
					java.sql.Blob blob=rest.getBlob("good_pic");
					InputStream inputStream=blob.getBinaryStream();
					goodPic=new byte[(int)blob.length()];
					inputStream.read(goodPic);
					inputStream.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
			}
			
		return goodPic;
	}

	@Override
	public List<Goods> ListGoods(int ctgid) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<Goods> listgoods=null;
		try {
			pstmt=conn.prepareStatement(LOAD_ALL_CTG);
			listgoods=new ArrayList<Goods>();
			pstmt.setInt(1, ctgid);
            rest=pstmt.executeQuery();
            
            while(rest.next())
            {
            	Goods goods=new Goods();
            	SmallCategoryDao scd=new SmallCategoryDaoImpl();
            	goods.setGoods_id(rest.getInt("goods_id"));
            	goods.setGoods_price(rest.getDouble("goods_price"));
            	goods.setGoods_name(rest.getString("goods_name"));
            	goods.setGoods_desc(rest.getString("goods_desc"));
            	goods.setGoods_pic(rest.getBytes("goods_pic"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setGoods_status(rest.getString("goods_status"));
            	goods.setGoods_store(rest.getString("goods_store"));
            	goods.setSmallCategory(scd.getOne(rest.getInt("goods_ctg")));
            	listgoods.add(goods);
            }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
			 }
		return listgoods;
	}

	@Override
	public Page loadPagedGoods(GoodsQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

}
