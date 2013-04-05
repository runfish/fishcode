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
import java.util.List;

import net.gdm.demo.User;
import net.gdm.service.UserQueryHelper;
import net.gdm.util.OracleUtil;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao {
	 private final static String ADD="insert into users values(?,?,?,?,?,?,?,?,?,?,?)";
     private final static String LOAD_ALL="select * from users";
     private final static String UPDATE="update users set "+
                                        "user_name=?"+
                                        ",user_pwd=?"+
                                        ",user_real_name=?"+
                                        ",user_sex=?"+
                                        ",user_birthday=?"+
                                        ",user_email=?"+
                                        ",user_phone=?"+
                                        ",user_addr=?"+
                                        ",user_postcode=?"+
                                        "user_statue=?"+
                                        "where user_id=?";
     private final static String DELETE="delete from users where user_id=?";
     private final static String GET_ONE="select * from users where user_id=?";
     private final static String GET_ONE_EMAIL="select * from users where user_email=?";
	 private final static String PWDUPDATE="update users set user_pwd=? where user_id=?";
     private final static String FORZEN="update user set user_statue='F' where user_id=?";
     private final static String NOTFORZEN="update user set user_statue='T' where user_id=?";
	 /* (non-Javadoc)
	 * @see net.gdm.dao.UserDao#ListUser()
	 */
	public List<User> ListUser() {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		List<User> listuser=null;
		
		try {
			pstmt=conn.prepareStatement(LOAD_ALL);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				User user=new User();
				user.setUser_id(rest.getInt("user_id"));
				user.setUser_name(rest.getString("user_name"));
				user.setUser_pwd(rest.getString("user_pwd"));
				user.setUser_real_name(rest.getString("user_real_name"));
				user.setUser_sex(rest.getString("user_sex"));
				user.setUser_date(rest.getDate("user_birthday"));
				user.setUser_email(rest.getString("user_email"));
				user.setUser_phone(rest.getString("user_phone"));
				user.setUser_addr(rest.getString("user_addr"));
				user.setUser_postcode(rest.getString("user_postcode"));
				user.setUser_status(rest.getString("user_statue"));
				listuser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listuser;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.UserDao#addUser(net.gdm.demo.User)
	 */
	public void addUser(User user) {
		// TODO Auto-generated mehod stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		
		try {
			
			pstmt=conn.prepareStatement(ADD);
			pstmt.setInt(1, user.getUser_id());
			pstmt.setString(2, user.getUser_name());
			pstmt.setString(3, user.getUser_pwd());
			pstmt.setString(4, user.getUser_real_name());
			pstmt.setString(5, user.getUser_sex());
			pstmt.setTimestamp(6, new Timestamp(user.getUser_date().getTime()));
			pstmt.setString(7, user.getUser_email());
			pstmt.setString(8, user.getUser_phone());
			pstmt.setString(9, user.getUser_addr());
			pstmt.setString(10, user.getUser_postcode());
			pstmt.setString(11, user.getUser_status());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.UserDao#deleteUser(int)
	 */
	public void deleteUser(int id) {
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
	 * @see net.gdm.dao.UserDao#getOne(int)
	 */
	public User getOne(int id) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		User user=new User();
		
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, id);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				
				user.setUser_id(rest.getInt("user_id"));
				user.setUser_name(rest.getString("user_name"));
				user.setUser_pwd(rest.getString("user_pwd"));
				user.setUser_real_name(rest.getString("user_real_name"));
				user.setUser_sex(rest.getString("user_sex"));
				user.setUser_date(rest.getDate("user_birthday"));
				user.setUser_email(rest.getString("user_email"));
				user.setUser_phone(rest.getString("user_phone"));
				user.setUser_addr(rest.getString("user_addr"));
				user.setUser_postcode(rest.getString("user_postcode"));
				user.setUser_status(rest.getString("user_statue"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.UserDao#updateUser(net.gdm.demo.User)
	 */
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(UPDATE);
			
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_pwd());
			pstmt.setString(3, user.getUser_real_name());
			pstmt.setString(4, user.getUser_sex());
			pstmt.setTimestamp(5, new Timestamp(user.getUser_date().getTime()));
			pstmt.setString(6, user.getUser_email());
			pstmt.setString(7, user.getUser_phone());
			pstmt.setString(8, user.getUser_addr());
			pstmt.setString(9, user.getUser_postcode());
			pstmt.setString(10, user.getUser_status());
			pstmt.setInt(11, user.getUser_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User getOne(String useremail) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		User user=new User();
		
		try {
			pstmt=conn.prepareStatement(GET_ONE_EMAIL);
			pstmt.setString(1, useremail);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				
				user.setUser_id(rest.getInt("user_id"));
				user.setUser_name(rest.getString("user_name"));
				user.setUser_pwd(rest.getString("user_pwd"));
				user.setUser_real_name(rest.getString("user_real_name"));
				user.setUser_sex(rest.getString("user_sex"));
				user.setUser_date(rest.getDate("user_birthday"));
				user.setUser_email(rest.getString("user_email"));
				user.setUser_phone(rest.getString("user_phone"));
				user.setUser_addr(rest.getString("user_addr"));
				user.setUser_postcode(rest.getString("user_postcode"));
				user.setUser_status(rest.getString("user_statue"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Page loadPagedUser(UserQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyPwd(User user) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(PWDUPDATE);		
			pstmt.setString(1, user.getUser_pwd());			
			pstmt.setInt(2, user.getUser_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void freezeUser(String userEmail) {
		// TODO Auto-generated method stub
		
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
        
		try {
			
			pstmt=conn.prepareStatement(FORZEN);
			User user= getOne(userEmail);		
			pstmt.setInt(1, user.getUser_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deFreezeUser(String userEmail) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
        
		try {
			
			pstmt=conn.prepareStatement(NOTFORZEN);
			User user= getOne(userEmail);		
			pstmt.setInt(1, user.getUser_id());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
