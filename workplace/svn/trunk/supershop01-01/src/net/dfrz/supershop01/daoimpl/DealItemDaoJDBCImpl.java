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
import net.dfrz.supershop01.dao.DealItemDao;
import net.dfrz.supershop01.domain.DealItem;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * Project: supershop01-02
 * ClassName: dealDaoJDBCImpl                                                        
 * Module ID: 4.6  
 * Comments: 在数据层为订单类对象提供数据删除，修改，分页显示的功能,dealDao的实现类  
 * JDK :jdk1.6.0_10 
 * Create Date： 2013-2-1
 *@author J1205-HongHG
 *@version Version 5
 */
public class DealItemDaoJDBCImpl implements DealItemDao {

	private static final String ADD_ITEM="insert into deal_item values(seq_dealItem.nextval,?,?,?,?,?,?)";
	/**
	 * 订单条目SQL删除语句  
	 */
	private static final String DELETE_ITEM="delete from deal_item where item_id=?";
	/**
	 * 订单条目SQL更新语句     
	 */
	private static final String UPDATE_ITEM="update deal_item set item_goods_qty=?,item_goods_price=?,goods_id=?" +
			",goods_ctg_id=?,deal_id=?,admin_id=? where item_id=?";
    /**
     * 查找订单条目信息的SQL语句
     */
    private static final String SEARCHITEM_BYID="select*from deal_item where item_id=?";
    /* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#add(net.dfrz.supershop01.domain.Deal)
	 */
    public void add(DealItem dealItem) {
		// TODO Auto-generated method stub
    	/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		try
		{  
			pstmt=conn.prepareStatement(ADD_ITEM);
            
			pstmt.setInt(1, dealItem.getItemId());
			pstmt.setInt(2,dealItem.getItemGoodsQty());
			pstmt.setDouble(3, dealItem.getItemGoodsPrice());
			pstmt.setInt(4, dealItem.getDealGoodsId());
			pstmt.setInt(5,dealItem.getDealGoodsCtgId());
			pstmt.setInt(6, dealItem.getDealId());
			pstmt.setInt(7, dealItem.getDealAdminId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("增加订单条目信息失败!");
		}
	}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#delete(net.dfrz.supershop01.domain.Deal)
	 */
	public void delete(DealItem dealItem) {
		// TODO Auto-generated method stub

		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		
		try 
		{
			pstmt=conn.prepareStatement(DELETE_ITEM);
			pstmt.setInt(1, dealItem.getItemId());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单条目信息删除失败!");
		}
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#loadPage(java.lang.Integer,java.lang.Integer, net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public List<DealItem> loadPage(int startIndex,int endIndex,int dealId) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset=null;
		/**
		 * 分页查询SQL语句
		 */
		String sql="select * from ( select rownum rn,a.* from ( "+ this.buildSqlByHelper(dealId)+" ) a where rownum<=? ) where rn>=?";
		/**
		 * 存放从数据库中获取的订单条目对象的ArrayList数组
		 */
		ArrayList<DealItem>dealItemList=new ArrayList<DealItem>();
		/**
		 * 封装订单条目信息的订单对象
		 */
		DealItem dealItem=null;
		
		try 
		{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,endIndex);
			pstmt.setInt(2,startIndex);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				dealItem=new DealItem();
				dealItem.setItemId(rset.getInt("item_id"));
				dealItem.setItemGoodsQty(rset.getInt("item_goods_qty"));
				dealItem.setItemGoodsPrice(rset.getDouble("item_goods_price"));
				dealItem.setDealGoodsId(rset.getInt("goods_id"));
				dealItem.setDealGoodsCtgId(rset.getInt("goods_ctg_id"));
				dealItem.setDealId(rset.getInt("deal_id"));
				dealItem.setDealAdminId(rset.getInt("admin_id"));
				
				dealItemList.add(dealItem);
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealItemList;
	}
 

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#update(net.dfrz.supershop01.domain.Deal)
	 */
	public void update(DealItem dealItem) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		try
		{  
			pstmt=conn.prepareStatement(UPDATE_ITEM);

			pstmt.setInt(1,dealItem.getItemGoodsQty());
			pstmt.setDouble(2, dealItem.getItemGoodsPrice());
			pstmt.setInt(3, dealItem.getDealGoodsId());
			pstmt.setInt(4,dealItem.getDealGoodsCtgId());
			pstmt.setInt(5, dealItem.getDealId());
			pstmt.setInt(6, dealItem.getDealAdminId());
			pstmt.setInt(7, dealItem.getItemId());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("订单信息修改失败!");
		}
	}
	
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#countdeal(net.dfrz.supershop01.servicesimpl.DealQuryHelper)
	 */
	public int countDealItem(int dealId) {
			
			String sql=this.buildSqlByHelper(dealId);
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
	/**
	 * 商品订单条目组合查询的SQL语句生成器
	 * @param helper -商品订单组合查询语句的条件的封装对象
	 * @return String
	 */
	private String buildSqlByHelper(int dealId){
			
			String sql="select * from deal_item where 1=1";
			
			sql+=" and deal_id="+dealId;
			
			sql+=" order by item_id";
	
			return sql;
			
		}
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.dealDao#getDealById(java.lang.Integer)
	 */
	public DealItem getDealItemById(Integer dealId) {
		// TODO Auto-generated method stub
		/**
		 * 获取数据库连接
		 */
		Connection conn=DBUtils.getInstance().getConn();
		/**
		 * 准备数据库SQL语句
		 */
		PreparedStatement pstmt=null;
		/**
		 * 数据库数据在内存中的存放对象
		 */
		ResultSet rset=null;
		/**
		 * 封装订单信息的订单对象
		 */
		DealItem dealItem=null;
		
		try 
		{
			pstmt=conn.prepareStatement(SEARCHITEM_BYID);
			pstmt.setInt(1, dealId);
			
			rset=pstmt.executeQuery();
			
			while(rset.next())
			{
				dealItem=new DealItem();
				dealItem.setItemId(rset.getInt("item_id"));
				dealItem.setItemGoodsQty(rset.getInt("item_goods_qty"));
				dealItem.setItemGoodsPrice(rset.getDouble("item_goods_price"));
				dealItem.setDealGoodsId(rset.getInt("goods_id"));
				dealItem.setDealGoodsCtgId(rset.getInt("goods_ctg_id"));
				dealItem.setDealId(rset.getInt("deal_id"));
				dealItem.setDealAdminId(rset.getInt("admin_id"));
			}
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dealItem;
	}
}
