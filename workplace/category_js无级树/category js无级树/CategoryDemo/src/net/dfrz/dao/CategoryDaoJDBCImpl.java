/**
 * 
 */
package net.dfrz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.dfrz.domain.Category;
import net.dfrz.utils.DBUtils;

/**
 * @author ctd
 *
 */
public class CategoryDaoJDBCImpl implements CategoryDao {
	
	private static final String ADD_CTG="insert into category values(seq_ctgid.nextval,?,?,?)";
	//private static final String GET_CTG_BYID="select * from category where ctg_id=?";
	private static final String GET_SUBCTGS="select * from category where ctg_pid=?";
	private static final String LOAD_ALL="select * from category order by ctg_id";
	

	/* (non-Javadoc)
	 * @see net.dfrz.dao.CategoryDao#add(net.dfrz.domain.Category)
	 */
	public void add(Category ctg) {
		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		
		try {
			
			pstmt=conn.prepareStatement(ADD_CTG);
			pstmt.setInt(1, ctg.getParentCtg().getCtgId());
            pstmt.setString(2, ctg.getCtgName());
            pstmt.setString(3, ctg.getLinkUrl());
            pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(conn,pstmt,null);
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.dao.CategoryDao#getSubCtgs(java.lang.Integer)
	 */
	public List<Category> getSubCtgs(Integer ctgPid) {

		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> subCtgs=null;
		
		try {
			
			pstmt=conn.prepareStatement(GET_SUBCTGS);
			pstmt.setInt(1, ctgPid);
            rset=pstmt.executeQuery();
            
            subCtgs=new ArrayList<Category>();
            
            while(rset.next()){
            	
            	Category ctg=new Category();
            	ctg.setCtgId(rset.getInt("ctg_id"));
            	ctg.setCtgName(rset.getString("ctg_name"));
            	ctg.setLinkUrl(rset.getString("ctg_linkurl"));
            	subCtgs.add(ctg);
            	
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(conn,pstmt,rset);
		}
		
		return subCtgs;
	}

	public List<Category> loadall() {
		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> ctgs=null;
		
		try {
			
			pstmt=conn.prepareStatement(LOAD_ALL);
            rset=pstmt.executeQuery();
            
            ctgs=new ArrayList<Category>();
            
            while(rset.next()){
            	
            	Category ctg=new Category();
            	ctg.setCtgId(rset.getInt("ctg_id"));
            	ctg.setCtgName(rset.getString("ctg_name"));
            	ctg.setLinkUrl(rset.getString("ctg_linkurl"));
            	ctg.setParentCtg(new Category(rset.getInt("ctg_pid")));
            	ctgs.add(ctg);
            	
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(conn,pstmt,rset);
		}
		return ctgs;
	}

}
