/**
 * 
 */
package net.gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.gdm.demo.SmallCategory;
import net.gdm.util.OracleUtil;

/**
 * @author Administrator
 *
 */
public class SmallCategoryDaoImpl implements SmallCategoryDao {
	 private final static String ADD="insert into small_category values(?,?,?,?)";
     private final static String LOAD_ALL="select * from small_category";
     private final static String UPDATE="update small_category set "+
                                        "s_ctg_name=?"+
                                        ",s_ctg_status=?"+
                                        ",b_ctg_id=?"+
                                        "where s_ctg_id=?";
     private final static String DELETE="delete from small_category where s_ctg_id=?";
     private final static String GET_ONE="select * from small_category where s_ctg_id=?";
	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#ListOraderItem()
	 */
	public List<SmallCategory> ListOraderItem() {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<SmallCategory> smallcategorylist=null;
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			BigCategoryDao bigcatdao=new BigCategoryDaoImpl();
			GoodsDao goodsdao=new GoodsDaoImpl();
			while(rest.next())
			{
				SmallCategory samllcategory=new SmallCategory();
				samllcategory.setS_ctg_id(rest.getInt("s_ctg_id"));
				samllcategory.setS_ctg_name(rest.getString("s_ctg_name"));
				samllcategory.setS_ctg_status(rest.getString("s_ctg_status"));
				samllcategory.setBigCategory(bigcatdao.getOne(rest.getInt("b_ctg_id")));
				samllcategory.setGoodsList(goodsdao.ListGoods(rest.getInt("s_ctg_id")));
				smallcategorylist.add(samllcategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return smallcategorylist;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#addSmallCategory(net.gdm.demo.SmallCategory)
	 */
	public void addSmallCategory(SmallCategory smallcategory) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(ADD);
			pstmt.setInt(1, smallcategory.getS_ctg_id());
			pstmt.setString(2, smallcategory.getS_ctg_name());
			pstmt.setString(3, smallcategory.getS_ctg_status());
			pstmt.setInt(4, smallcategory.getBigCategory().getB_ctg_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#deleteSmallCategory(int)
	 */
	public void deleteSmallCategory(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#getOne(int)
	 */
	public SmallCategory getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		SmallCategory smallcategory=new SmallCategory();
		BigCategoryDao bigcatdao=new BigCategoryDaoImpl();
		GoodsDao goodsdao=new GoodsDaoImpl();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				smallcategory.setS_ctg_id(rest.getInt("s_ctg_id"));
				smallcategory.setS_ctg_name(rest.getString("s_ctg_name"));
				smallcategory.setS_ctg_status(rest.getString("s_ctg_status"));
				smallcategory.setBigCategory(bigcatdao.getOne(rest.getInt("b_ctg_id")));
				smallcategory.setGoodsList(goodsdao.ListGoods(rest.getInt("s_ctg_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return smallcategory;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#updateSmallCategory(net.gdm.demo.SmallCategory)
	 */
	public void updateSmallCategory(SmallCategory smallcategory) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, smallcategory.getS_ctg_name());
			pstmt.setString(2, smallcategory.getS_ctg_status());
			pstmt.setInt(3, smallcategory.getBigCategory().getB_ctg_id());
			pstmt.setInt(4, smallcategory.getS_ctg_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
