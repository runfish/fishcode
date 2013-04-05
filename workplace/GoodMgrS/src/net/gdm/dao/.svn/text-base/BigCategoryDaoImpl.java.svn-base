/**
 * 
 */
package net.gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.gdm.demo.BigCategory;
import net.gdm.util.OracleUtil;

/**
 * @author Administrator
 *
 */
public class BigCategoryDaoImpl implements BigCategoryDao {
	 private final static String ADD="insert into big_category values(?,?,?)";
     private final static String LOAD_ALL="select * from big_category";
     private final static String UPDATE="update big_category set "+
                                        "b_ctg_name=?"+
                                        ",b_ctg_status=?"+
                                        " where b_ctg_id=?";
     private final static String DELETE="delete from big_category where b_ctg_id=?";
     private final static String GET_ONE="select * from big_category where b_ctg_id=?";
	/* (non-Javadoc)
	 * @see net.gdm.dao.BigCategoryDao#addBig(net.gdm.demo.BigCategory)
	 */
	public void addBig(BigCategory bigcategory) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(ADD);
			pstmt.setInt(1, bigcategory.getB_ctg_id());
			pstmt.setString(2, bigcategory.getB_ctg_name());
			pstmt.setString(3, bigcategory.getB_ctg_status());
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
	 * @see net.gdm.dao.BigCategoryDao#deleteBig(int)
	 */
	public void deleteBig(int id) {
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
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.BigCategoryDao#getOne(int)
	 */
	public BigCategory getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		BigCategory bcg=new BigCategory();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			System.out.print(GET_ONE+id);
			rest=pstmt.executeQuery();			
			while(rest.next())
			{
				bcg.setB_ctg_id(id);
				bcg.setB_ctg_name(rest.getString("b_ctg_name"));
				bcg.setB_ctg_status(rest.getString("b_ctg_status"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
		}
		return bcg;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.BigCategoryDao#listbig()
	 */
	public List<BigCategory> listbig() {
		// TODO Auto-generated method stub
		   Connection conn=OracleUtil.getInstance().getConn();
		   PreparedStatement pstmt=null;
		   List<BigCategory> listabctg=null;
		   ResultSet rest=null;
		   try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			listabctg=new ArrayList<BigCategory>();
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				BigCategory bctg=new BigCategory();
				bctg.setB_ctg_id(rest.getInt("b_ctg_id"));
				bctg.setB_ctg_name(rest.getString("b_ctg_name"));
				bctg.setB_ctg_status(rest.getString("b_ctg_status"));
				listabctg.add(bctg);
			}
		   }
	    catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   finally{
	    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
	    }
			return listabctg;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.BigCategoryDao#updateBig(net.gdm.demo.BigCategory)
	 */
	public void updateBig(BigCategory big) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, big.getB_ctg_name());
			pstmt.setString(2, big.getB_ctg_status());
			pstmt.setInt(3, big.getB_ctg_id());
			System.out.print(UPDATE);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
	    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
	    }
	}

}
