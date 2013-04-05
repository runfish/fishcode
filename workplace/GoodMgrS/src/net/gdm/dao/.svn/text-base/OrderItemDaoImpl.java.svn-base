/**
 * 
 */
package net.gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.gdm.demo.OrderItem;
import net.gdm.util.OracleUtil;

/**
 * @author Administrator
 *
 */
public class OrderItemDaoImpl implements OrderItemDao {
	 private final static String ADD="insert into order_item values(?,?,?,?,?)";
     private final static String LOAD_ALL="select * from order_item";
     private final static String UPDATE="update order_item set "+
                                        "item_amount=?"+
                                        ",item_goods_price=?"+
                                        ",goods_id=?"+
                                        ",order_id=?"+
                                        "where item_id=?";
     private final static String DELETE="delete from order_item where item_id=?";
     private final static String GET_ONE="select * from order_item where item_id=?";
	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderItemDao#ListOraderItem()
	 */
	public List<OrderItem> ListOraderItem() {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<OrderItem> listitem=null; 
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			GoodsDao goodsdao=new GoodsDaoImpl();
			OrderDao orderdao=new OrderDaoImpl();
			
			while(rest.next())
			{
				OrderItem item=new OrderItem();
			    item.setGoods(goodsdao.getOne(rest.getInt("goods_id")));
			    item.setOrder(orderdao.getOne(rest.getInt("order_id")));
			    item.setItem_amount(rest.getInt("order_amount"));
			    item.setItem_id(rest.getInt("item_id"));
			    item.setItem_goods_price(rest.getDouble("item_goods_price"));
			    listitem.add(item);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listitem;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderItemDao#addOraderItem(net.gdm.demo.OraderItem)
	 */
	public void addOraderItem(OrderItem item) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(ADD);
			pstmt.setInt(1,item.getItem_id());
			pstmt.setInt(2, item.getItem_amount());
			pstmt.setDouble(3, item.getItem_goods_price());
			pstmt.setInt(4, item.getGoods().getGoods_id());
			pstmt.setInt(5, item.getOrder().getOrder_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderItemDao#deleteOraderItem(int)
	 */
	public void deleteOraderItem(int id) {
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
	 * @see net.gdm.dao.OrderItemDao#getOne(int)
	 */
	public OrderItem getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		OrderItem item=new OrderItem();
		GoodsDao goodsdao=new GoodsDaoImpl();
		OrderDao orderdao=new OrderDaoImpl();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				 item.setGoods(goodsdao.getOne(rest.getInt("goods_id")));
				 item.setOrder(orderdao.getOne(rest.getInt("order_id")));
				 item.setItem_amount(rest.getInt("order_amount"));
				 item.setItem_id(rest.getInt("item_id"));
				 item.setItem_goods_price(rest.getDouble("item_goods_price"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderItemDao#updateOraderItem(net.gdm.demo.OraderItem)
	 */
	public void updateOraderItem(OrderItem item) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(UPDATE);			
			pstmt.setInt(1, item.getItem_amount());
			pstmt.setDouble(2, item.getItem_goods_price());
			pstmt.setInt(3, item.getGoods().getGoods_id());
			pstmt.setInt(4, item.getOrder().getOrder_id());
			pstmt.setInt(5,item.getItem_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
