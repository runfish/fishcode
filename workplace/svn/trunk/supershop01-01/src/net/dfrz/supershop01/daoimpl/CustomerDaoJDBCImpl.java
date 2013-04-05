/**
 * 
 */
package net.dfrz.supershop01.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.dfrz.supershop01.dao.CustomerDao;
import net.dfrz.supershop01.domain.Customer;
import net.dfrz.supershop01.exception.DataAccessException;
import net.dfrz.supershop01.utils.DBUtils;

/**
 * @author Administrator
 *
 */
public class CustomerDaoJDBCImpl implements CustomerDao {

	private static final String ADD_CUSTOMER = "insert into customer values(seq_customer.nextval,?,?,?,?,?,?,?,?)";
	
	private static final String GET_CUS_BYNAME = "select * from customer where customer_name =?";
	
	private static final String UPDATE_CUSTOMER = "update customer set customer_name=?,customer_password=?,customer_real_name=?," +
			                                      "customer_birthday=?,customer_mail=?,customer_tel=?,customer_address=?,customer_postcode=?";
	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#add(net.dfrz.supershop01.domain.Customer)
	 */

	public void add(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(ADD_CUSTOMER);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, customer.getCustomerRealname());
			pstmt.setDate(4, customer.getCustomerBirthday());
			pstmt.setString(5, customer.getCustomerMail());
			pstmt.setString(6, customer.getCustomerTel());
			pstmt.setString(7, customer.getCustomerAddress());
			pstmt.setString(8, customer.getCustomerPostCode());
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String detailMsg=null;
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="商品名称出现了雷同!";
			throw new DataAccessException("用户信息增加失败,"+detailMsg);
			
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		
		
		
		

	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#getCustomerByName(java.lang.String)
	 */

	public Customer getCustomerByName(String name) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Customer customer = new Customer();
		
		try {
			pstmt = conn.prepareStatement(GET_CUS_BYNAME);
			pstmt.setString(1, name);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				
				customer.setCustomerId(String.valueOf(rset.getInt("customer_id")));
				customer.setCustomerName(rset.getString("customer_name"));
				customer.setCustomerPassword(rset.getString("customer_password"));
				customer.setCustomerBirthday(rset.getDate("customer_birthday"));
				customer.setCustomerAddress(rset.getString("customer_address"));
				customer.setCustomerMail(rset.getString("customer_mail"));
				customer.setCustomerRealname(rset.getString("customer_real_name"));
				customer.setCustomerPostCode(rset.getString("customer_postcode"));
				customer.setCustomerTel(rset.getString("customer_tel"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DataAccessException("用户信息提取失败");
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, rset);
		}
		
		return customer;
	}

	/* (non-Javadoc)
	 * @see net.dfrz.supershop01.dao.CustomerDao#updateCustomer(net.dfrz.supershop01.domain.Customer)
	 */

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(UPDATE_CUSTOMER);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setString(2, customer.getCustomerPassword());
			pstmt.setString(3, customer.getCustomerRealname());
			pstmt.setDate(4, customer.getCustomerBirthday());
			pstmt.setString(5, customer.getCustomerMail());
			pstmt.setString(6, customer.getCustomerTel());
			pstmt.setString(7, customer.getCustomerAddress());
			pstmt.setString(8, customer.getCustomerPostCode());
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    String detailMsg=null;
			if(e.getMessage().indexOf("ORA-00001")!=-1) 
				detailMsg="商品名称出现了雷同!";
			throw new DataAccessException("用户信息修改失败,"+detailMsg);
			
		}finally{
			DBUtils.getInstance().ReleaseRes(conn, pstmt, null);
		}
		
		
		
		

	}

}
