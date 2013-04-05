package net.dfrz.smmgr01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.dfrz.smmgr01.domain.Category;
import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.exception.DataAccessException;
import net.dfrz.smmgr01.utils.DBUtils;
/**
 * 
 * @author YDP
 *
 */
public class CategoryDaoJDBCImpl implements CategoryDao {

	private static final String ADD_CTG="insert into category values(seq_ctg.nextval,?)";
	private static final String DELETE_CTG="delete from category where ctg_id=?";
	private static final String LOADALL_CTG="select * from category order by ctg_id desc";
	private static final String UPDATE_CTG="update category set ctg_name=? where ctg_id=?";
	private static final String LOAD_CTG_BYID="select * from category where ctg_id=?";
	
	
	
/**
 * 实现把商品类别信息增加到数据库
 */
	public void add(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn =DBUtils.getInstance().getConn();//获取数据库连接
		PreparedStatement pstmt=null;
		
		
		try {
			
			pstmt=conn.prepareStatement(ADD_CTG);
			pstmt.setString(1, ctg.getCtgName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			String detailMsg=null;
			
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="类别名称出现了雷同!";
			
			throw new DataAccessException("类别信息保存失败,"+detailMsg);
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}
/**
 * 实现对数据库中类别信息的删除操作
 */
	public void delete(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		
		try {
			
			pstmt=conn.prepareStatement(DELETE_CTG);
			pstmt.setInt(1,ctg.getCtgId());			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("类别信息删除失败！");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}
/**
 * 实现根据用户提供的类别编号从数据库中取出相应的类别信息
 */
	public Category getCategoryById(int ctgId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
        Category ctg =null;
		
		try {
			
			pstmt=conn.prepareStatement(LOAD_CTG_BYID);	
			pstmt.setInt(1, ctgId);
			rset=pstmt.executeQuery();
			
			if(rset.next()){
				ctg=new Category();
				ctg.setCtgId(rset.getInt("ctg_id"));
				ctg.setCtgName(rset.getString("ctg_name"));
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		return ctg;

	}
/**
 * 实现吧数据库中所有有关于类别的信息全部取出操作
 */
	public List<Category> loadAll() {
		// TODO Auto-generated method stub

		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<Category> ctgList=null;
		
		try {
			
			pstmt=conn.prepareStatement(LOADALL_CTG);			
			rset=pstmt.executeQuery();
			
			ctgList=new ArrayList<Category>();
			
			while(rset.next()){
				
			   Category ctg=new Category();
			   
		       ctg.setCtgId(rset.getInt("ctg_id"));
		       ctg.setCtgName(rset.getString("ctg_name"));
			
			   ctgList.add(ctg);
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return ctgList;
	}

	/**
	 * 实现产品类别更新操作
	 */
	public void update(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		
		try {
			
			pstmt=conn.prepareStatement(UPDATE_CTG);
			pstmt.setString(1, ctg.getCtgName());
			pstmt.setInt(2, ctg.getCtgId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("类别信息修改失败!");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}
	public int countCategory() {
		// TODO Auto-generated method stub
		String sql=this.buildSqlByHelper();
		sql=sql.replace("*", "count(*) total");
		
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Integer total=null;
		
		try{
		   pstmt=conn.prepareStatement(sql);
		   rset=pstmt.executeQuery();
		   
		   if(rset.next()){
			  total=rset.getInt("total"); 
		   }
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}	
		
		return total;
	}
	public List<Category> loadPageAll(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<Category> categoryList=null;
		
		try {
			
			categoryList=new ArrayList<Category>();
			
			String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper()+" ) a where rownum<=? ) where rn>=?";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				
			  Category category=new Category();
			   
			  category.setCtgId(rset.getInt("ctg_id"));
			  category.setCtgName(rset.getString("ctg_name"));

			
			   categoryList.add(category);
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return categoryList;
	}
     private String buildSqlByHelper(){
  		
  		String sql="select * from category where 1=1";
  		
  		return sql;
  		
  	}

}
