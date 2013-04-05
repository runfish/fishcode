/**
 * 
 */
package net.gdm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.gdm.demo.Admine;
import net.gdm.demo.Order;
import net.gdm.demo.OrderItem;
import net.gdm.demo.ShoppingCart;
import net.gdm.service.OrderQueryHelper;
import net.gdm.util.OracleUtil;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class OrderDaoImpl implements OrderDao {
	 private final static String ADD="insert into order_info values(?,?,?,?,?,?,?,?,?,?,?,?)";
     private final static String LOAD_ALL="select * from order_info";
     private final static String UPDATE="update order_info set "+
                                        "order_time=?"+
                                        ",order_amount=?"+
                                        ",pay_mode=?"+
                                        ",receive_mode=?"+
                                        ",receiver_name=?"+
                                        ",receiver_addr=?"+
                                        ",receiver_postcode=?"+
                                        ",receiver_phone=?"+
                                        ",receiver_email=?"+
                                        ",order_status=?"+
                                        ",user_email=?"+
                                        "where order_id=?";
     private final static String DELETE="delete from order_info where order_id=?";
     private final static String GET_ONE="select * from order_info where order_id=?";
	 private final static String STATUTEOVER="update order_info set order_status='F' where order_id=?";
	 private final static String UPDATESTATUS="upadate order_info set order_status=? where order_id=?";
     private final static String ORDERITEM="select * from order_item where order_id=?";
     /* (non-Javadoc)
	 * @see net.gdm.dao.OrderDao#ListOrder()
	 */
	public List<Order> ListOrder() {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		List<Order> listorder=null;
		ResultSet rest=null;
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			listorder=new ArrayList<Order>();
			while(rest.next())
			{
				Order order=new Order();
				UserDao ud=new UserDaoImpl();
				order.setOrder_id(rest.getInt("order_id"));
				order.setOrder_account(rest.getDouble("order_amount"));
				order.setOrder_time(rest.getDate("order_time"));
				order.setPay_mode(rest.getString("pay_mode"));
				order.setReceive_mode(rest.getString("receive_mode"));
				order.setReceiver_add("receiver_addr");
				order.setReceiver_email("receiver_email");
				order.setReceiver_name("receiver_name");
				order.setReceiver_phone("receiver_phone");
				order.setReceiver_postcode("receiver_postcode");
				order.setReceiver_status("order_status");
				order.setUser(ud.getOne(rest.getString("user_email")));
				listorder.add(order);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
		 }
		return listorder;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderDao#UpateOrder(net.gdm.demo.Order)
	 */

	public void UpateOrder(Order order) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setTimestamp(1, new Timestamp(order.getOrder_time().getTime()));
			pstmt.setDouble(2, order.getOrder_account());
			pstmt.setString(3, order.getPay_mode());
			pstmt.setString(4, order.getReceive_mode());
			pstmt.setString(5, order.getReceiver_name());
			pstmt.setString(6, order.getReceiver_add());
			pstmt.setString(7, order.getReceiver_postcode());
			pstmt.setString(8, order.getReceiver_phone());
			pstmt.setString(9, order.getReceiver_email());
			pstmt.setString(10, order.getReceiver_status());
			pstmt.setString(11, order.getUser().getUser_email());
			pstmt.setInt(12, order.getOrder_id());
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
	 * @see net.gdm.dao.OrderDao#ddOrder(net.gdm.demo.Order)
	 */
	public void addOrder(Order order) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(ADD);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.setTimestamp(2, new Timestamp(order.getOrder_time().getTime()));
			pstmt.setDouble(3, order.getOrder_account());
			pstmt.setString(4, order.getPay_mode());
			pstmt.setString(5, order.getReceive_mode());
			pstmt.setString(6, order.getReceiver_name());
			pstmt.setString(7, order.getReceiver_add());
			pstmt.setString(8, order.getReceiver_postcode());
			pstmt.setString(9, order.getReceiver_phone());
			pstmt.setString(10, order.getReceiver_email());
			pstmt.setString(11, order.getReceiver_status());
			pstmt.setString(12, order.getUser().getUser_email());
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
	 * @see net.gdm.dao.OrderDao#deleteOrder(int)
	 */
	public void deleteOrder(int id) {
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
		finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
		 }
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.OrderDao#getOne(int)
	 */
	public Order getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		Order order=new Order();
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				UserDao ud=new UserDaoImpl();
				order.setOrder_id(rest.getInt("order_id"));
				order.setOrder_account(rest.getDouble("order_amount"));
				order.setOrder_time(rest.getDate("order_time"));
				order.setPay_mode(rest.getString("pay_mode"));
				order.setReceive_mode(rest.getString("receive_mode"));
				order.setReceiver_add(rest.getString("receiver_addr"));
				order.setReceiver_email(rest.getString("receiver_email"));				
				order.setReceiver_name(rest.getString("receiver_name"));
				order.setReceiver_phone(rest.getString("receiver_phone"));
				order.setReceiver_postcode(rest.getString("receiver_postcode"));
				order.setReceiver_status(rest.getString("order_status"));
				order.setUser(ud.getOne(rest.getString("user_email")));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
		 }
		return order;
	}

	@Override
	public void Statusover(Order order) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(STATUTEOVER);
			pstmt.setInt(1, order.getOrder_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
		 }
		
	}

	@Override
	public void changeStatus(Order order, Admine adm) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			pstmt=conn.prepareStatement(UPDATESTATUS);
			pstmt.setString(1, String.valueOf(order.getReceiver_status()));
			pstmt.setInt(2, order.getOrder_id());			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, null);
		 }
	}

	@Override
	public List<OrderItem> getdetailById(int orderid) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<OrderItem> listitem=null; 
		
		try {
			pstmt=conn.prepareStatement(ORDERITEM);
			pstmt.setInt(1, orderid);
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

	@Override
	public Page loadOrdersByMaker(OrderQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return null;
	}



}
