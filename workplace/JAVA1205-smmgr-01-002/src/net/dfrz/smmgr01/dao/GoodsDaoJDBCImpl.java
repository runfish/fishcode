/**
 * 
 */
package net.dfrz.smmgr01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.dfrz.smmgr01.domain.Goods;
import net.dfrz.smmgr01.exception.DataAccessException;
import net.dfrz.smmgr01.services.GoodsQuryHelper;
import net.dfrz.smmgr01.utils.DBUtils;


/**
 * @author ctd
 *
 */
public class GoodsDaoJDBCImpl implements GoodsDao {

	private static final String ADD_GOODS="insert into goods values(seq_goodsNo.nextval,?,?,?,?,?,?)";
	private static final String DELETE_GOODS="delete from goods where goods_id=?";
	private static final String LOADALL_GOODS="select * from goods order by goods_id desc";
	private static final String UPDATE_GOODS="update goods set goods_name=?,goods_price=?,goods_ctg_id=?,goods_src=?,goods_store_condition=?,goods_status=? where goods_id=?";
	private static final String LOAD_GOODS_BYID="select * from goods where goods_id=?";
	/* (non-Javadoc)
	 * @see net.dfrz.smmgr05.dao.GoodsDao#add(net.dfrz.smmgr05.domain.Goods)
	 */
	public void add(Goods goods) {
		// TODO Auto-generated method stub

		Connection conn =DBUtils.getInstance().getConn();//获取数据库连接
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			
			pstmt=conn.prepareStatement(ADD_GOODS);
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setDouble(2, goods.getGoodsPrice());
			pstmt.setInt(3, goods.getCtgId());
			pstmt.setString(4, goods.getSrc());
			pstmt.setString(5, goods.getStatus());
			
			for(String gsc:goods.getGoodsStoreCondition())
			{
				sb.append(gsc);
				sb.append("|");
			}

			if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
			
			pstmt.setString(6,sb.toString());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			String detailMsg=null;
			
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="商品名称出现了雷同!";
			
			throw new DataAccessException("商品信息保存失败,"+detailMsg);
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr05.dao.GoodsDao#delete(net.dfrz.smmgr05.domain.Goods)
	 */
	public void delete(Goods goods) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		
		try {
			
			pstmt=conn.prepareStatement(DELETE_GOODS);
			pstmt.setInt(1,goods.getGoodsId());			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException("商品信息删除失败！");
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr05.dao.GoodsDao#loadAll()
	 */
	public List loadAll(int beginIndex,int endIndex,GoodsQuryHelper helper) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		List<Goods> goodsList=null;
		String[]csg=null;
		
		try {
			
			goodsList=new ArrayList<Goods>();
			
			String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(helper)+" ) a where rownum<=? ) where rn>=?";
			pstmt=conn.prepareStatement(sql);	
			pstmt.setInt(1, endIndex);
			pstmt.setInt(2, beginIndex);
			rset=pstmt.executeQuery();
			
			while(rset.next()){
				
			   Goods goods=new Goods();
			   
		       goods.setGoodsId(rset.getInt("goods_id"));
		       goods.setGoodsName(rset.getString("goods_name"));
		       goods.setGoodsPrice(rset.getInt("goods_price"));
		       csg=rset.getString("goods_store_condition").split("|");
		       goods.setGoodsStoreCondition(csg);
		       goods.setSrc(rset.getString("goods_src"));
		       goods.setStatus(rset.getString("goods_status"));
		       goods.setCtgId(rset.getInt("goods_ctg_id"));
			
			   goodsList.add(goods);
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return goodsList;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.smmgr05.dao.GoodsDao#update(net.dfrz.smmgr05.domain.Goods)
	 */
	public void update(Goods goods) {
		// TODO Auto-generated method stub

		Connection conn =DBUtils.getInstance().getConn();//获取数据库连接
		PreparedStatement pstmt=null;
		StringBuffer sb=new StringBuffer();
		
		try {
			
			pstmt=conn.prepareStatement(UPDATE_GOODS);
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setDouble(2, goods.getGoodsPrice());
			pstmt.setInt(3, goods.getCtgId());
			pstmt.setString(4, goods.getSrc());
			for(String gsc:goods.getGoodsStoreCondition())
			{
				sb.append(gsc);
				sb.append("|");
			}

			if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
			  
			pstmt.setString(5,sb.toString());
			pstmt.setString(6, goods.getStatus());
			pstmt.setInt(7,goods.getGoodsId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
			String detailMsg=null;
			
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="商品名称出现了雷同!";
			
			throw new DataAccessException("商品信息保存失败,"+detailMsg);
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
	}

	public Goods getGoodsById(int goodsId) {
		// TODO Auto-generated method stub
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null; 
		ResultSet rset=null;
		Goods goods=null;
		String[]csg=null;
		
		try {
			
			pstmt=conn.prepareStatement(LOAD_GOODS_BYID);
			pstmt.setInt(1,goodsId);
			rset=pstmt.executeQuery();
			
			
			if(rset.next()){
			   goods=new Goods();
				
		       goods.setGoodsId(rset.getInt("goods_id"));
		       goods.setGoodsName(rset.getString("goods_name"));
		       goods.setGoodsPrice(rset.getInt("goods_price"));
		       csg=rset.getString("goods_store_condition").split("|");
		       goods.setGoodsStoreCondition(csg);
		       goods.setSrc(rset.getString("goods_src"));
		       goods.setStatus(rset.getString("goods_status"));
		       goods.setCtgId(rset.getInt("goods_ctg_id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}		
		
		return goods;
	}
	
      public int countGoods(GoodsQuryHelper helper) {
		
		String sql=this.buildSqlByHelper(helper);
		sql=sql.replace("*", "count(*) total");
		sql=sql.substring(0, sql.indexOf("order"));
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
      
      private String buildSqlByHelper(GoodsQuryHelper helper){
  		
  		String sql="select * from goods where 1=1";
  		
  		if(helper.getGoodsName()!=null&&helper.getGoodsName().trim().length()>0)
  		{
  			sql+=" and goods_name like '%"+helper.getGoodsName()+"%'";
  		}
  		if (helper.getGoodsCtgId()!=null)
  		{
			sql+=" and goods_ctg_id="+helper.getGoodsCtgId();
		}
  		if(helper.getGoodsSrc()!=null&&helper.getGoodsSrc().trim().length()>0)
  		{
  			sql+=" and goods_src='"+helper.getGoodsSrc()+"'";
  		}
  		sql+=" order by goods_id";
 
  		return sql;
  		
  	}

}
