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
import net.dfrz.supershop01.dao.DaoFactory;
import net.dfrz.supershop01.dao.GoodsDao;
import net.dfrz.supershop01.dao.SmallCategoryDao;
import net.dfrz.supershop01.domain.Category;
import net.dfrz.supershop01.domain.SmallCategory;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;
import net.dfrz.supershop01.utils.Page;



/**
 * @author Administrator
 *
 */
public class SmallCategoryDaoJDBCImpl implements SmallCategoryDao {
	 private final static String ADD="insert into small_category values(seq_small_ctgid.nextval,?,?,?)";
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
		Connection conn=DBUtils.getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<SmallCategory> smallcategorylist=null;
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			//小游同志 记得要new
			smallcategorylist = new ArrayList<SmallCategory>();
			CategoryDao bigcatdao=new CategoryDaoJDBCImpl();
			GoodsDao goodsdao=new GoodsDaoJDBCImpl();
			while(rest.next())
			{
				SmallCategory samllcategory=new SmallCategory();
				samllcategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				samllcategory.setSmallCtgName(rest.getString("s_ctg_name"));
				samllcategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				samllcategory.setBigCategory(bigcatdao.getCtgById(rest.getInt("b_ctg_id")));
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
		Connection conn=DBUtils.getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(ADD);
			
			pstmt.setString(1, smallcategory.getSmallCtgName());
			pstmt.setString(2, smallcategory.getSmallCtgStatus());
			pstmt.setInt(3, smallcategory.getBigCategory().getCtgId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String detail = null;
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				 detail = "已存在该类别，请重新确认后在添加!";
			throw new DataAccessException("商品类别增加失败"+detail);
			
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#deleteSmallCategory(int)
	 */
	public void deleteSmallCategory(int id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
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
		Connection conn=DBUtils.getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		SmallCategory smallCategory=null;
		CategoryDao bigcatdao=new CategoryDaoJDBCImpl();
		GoodsDao goodsdao=new GoodsDaoJDBCImpl();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				smallCategory=new SmallCategory();
				smallCategory.setSmallCtgId(rest.getInt("s_ctg_id"));
				smallCategory.setSmallCtgName(rest.getString("s_ctg_name"));
				smallCategory.setSmallCtgStatus(rest.getString("s_ctg_status"));
				smallCategory.setBigCategory(bigcatdao.getCtgById(rest.getInt("b_ctg_id")));
				smallCategory.setGoodsList(goodsdao.ListGoods(rest.getInt("s_ctg_id")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return smallCategory;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.SmallCategoryDao#updateSmallCategory(net.gdm.demo.SmallCategory)
	 */
	public void updateSmallCategory(SmallCategory smallcategory) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, smallcategory.getSmallCtgName());
			pstmt.setString(2, smallcategory.getSmallCtgStatus());
			pstmt.setInt(3, smallcategory.getBigCategory().getCtgId());
			pstmt.setInt(4, smallcategory.getSmallCtgId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("商品类别修改失败");
		}
	}
	public int countSmallCategory()
	{
		String sql=this.buildSqlByHelper();
		sql=sql.replace("*", "count(*) total");
		
		Connection conn=DBUtils.getConn();
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
	public List<SmallCategory>loadPage(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<SmallCategory> smallCtgList=null;
		CategoryDao categoryDao=(CategoryDao)DaoFactory.getDao("CategoryDao");
		
		try {
			
			smallCtgList=new ArrayList<SmallCategory>();
			
			String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper()+" ) a where rownum<=? ) where rn>=?";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				
			  SmallCategory smallcategory=new SmallCategory();
			   
			  smallcategory.setSmallCtgId(rset.getInt("s_ctg_id"));
			  smallcategory.setSmallCtgName(rset.getString("s_ctg_name"));
			  smallcategory.setSmallCtgStatus(rset.getString("s_ctg_status"));
			  Category category=new Category();
			  category.setCtgId(rset.getInt("b_ctg_id"));
			  category=categoryDao.getCtgById(category.getCtgId());
			  
			  smallcategory.setBigCategory(category);
		       
		      smallCtgList.add(smallcategory);
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return smallCtgList;
	}
    private String buildSqlByHelper(){
  		
  		String sql="select * from small_category where 1=1";
  		
  		return sql;
  		
  	}
}
