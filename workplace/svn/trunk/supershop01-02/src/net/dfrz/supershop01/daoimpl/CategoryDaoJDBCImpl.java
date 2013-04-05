/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.dfrz.supershop01.dao.CategoryDao;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;


/**
 * @author Administrator
 *
 */
public class CategoryDaoJDBCImpl implements CategoryDao {

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CategoryDao#add(net.dfrz.supershop01.domain.Category)
	 */
	
	private final static String ADD_CTG = "insert into big_category values(?,?,?)";

	private static final String DELETE_CTG="delete from big_category where b_ctg_id=?";
	private static final String LOADALL_CTG="select * from big_category order by b_ctg_id desc";
	private static final String UPDATE_CTG="update big_category set "+
													"b_ctg_name=?"+
													",b_ctg_status=?"+
													" where b_ctg_id=?";
	private static final String LOAD_CTG_BYID="select * from big_category where b_ctg_id=?";
	private static final String GET_SUBCTGS="select * from big_category where b_ctg_id=?";


	
	public void add(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn =DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		
		try {
			
			pstmt=conn.prepareStatement(ADD_CTG);
			pstmt.setInt(1, ctg.getCtgId());
			pstmt.setString(2, ctg.getCtgName());
			pstmt.setString(3, ctg.getCtgStatus());
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			String detailMsg=null;
			
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="������Ƴ�������ͬ!";
			
			throw new DataAccessException("�����Ϣ����ʧ��,"+detailMsg);
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CategoryDao#delete(net.dfrz.supershop01.domain.Category)
	 */
	public void delete(int ctgId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		
		try {
			
			pstmt=conn.prepareStatement(DELETE_CTG);
			pstmt.setInt(1,ctgId);			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("�����Ϣɾ��ʧ�ܣ�");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CategoryDao#getCtgById(int)
	 */
	public Category getCtgById(int ctgId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
        Category ctg =null;
		
		try {
			
			pstmt=conn.prepareStatement(LOAD_CTG_BYID);	
			pstmt.setInt(1,ctgId);
			System.out.print(LOAD_CTG_BYID+ctgId);
			rset=pstmt.executeQuery();			
			while(rset.next())
			{
				ctg=new Category();
				ctg.setCtgId(ctgId);
				ctg.setCtgName(rset.getString("b_ctg_name"));
				ctg.setCtgStatus(rset.getString("b_ctg_status"));				
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		return ctg;

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CategoryDao#update(net.dfrz.supershop01.domain.Category)
	 */
	public void update(Category ctg) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		
		try {
			
			pstmt=conn.prepareStatement(UPDATE_CTG);
			
			pstmt.setString(1, ctg.getCtgName());
			pstmt.setString(2, ctg.getCtgStatus());
			pstmt.setInt(3, ctg.getCtgId());
			System.out.print(UPDATE_CTG);
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("�����Ϣ�޸�ʧ��!");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		
	}

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
		       ctg.setCtgId(rset.getInt("b_ctg_id"));
		       ctg.setCtgName(rset.getString("b_ctg_name"));
		       ctg.setCtgStatus(rset.getString("b_ctg_status"));
		       
			
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
			   
		      category.setCtgId(rset.getInt("b_ctg_id"));
		      category.setCtgName(rset.getString("b_ctg_name"));
		      category.setCtgStatus(rset.getString("b_ctg_status"));
		       
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
  		
  		String sql="select * from b_category where 1=1";
  		
  		return sql;
  		
  	}

	public List<Category> getSubCtgs(Integer ctgId) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<Category> subCtgs=null;
		
		try {
			
			pstmt=conn.prepareStatement(GET_SUBCTGS);
			pstmt.setInt(1, ctgId);
            rset=pstmt.executeQuery();
            
            subCtgs=new ArrayList<Category>();
            
            while(rset.next()){
            	
            	Category ctg=new Category();
     	        ctg.setCtgId(rset.getInt("b_ctg_id"));
		        ctg.setCtgName(rset.getString("b_ctg_name"));
		        ctg.setCtgStatus(rset.getString("b_ctg_status"));
                subCtgs.add(ctg);
            	
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().ReleaseRes(conn,pstmt,rset);
		}
		
		return subCtgs;
	}

}