/**
 * 
 */
package net.gdm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import net.gdm.demo.Admine;
import net.gdm.service.AdmineQueryHelper;
import net.gdm.util.OracleUtil;
import net.gdm.util.Page;

/**
 * @author Administrator
 *
 */
public class AdmineDaoImpl implements AdmineDao {
     private final static String ADD="insert into admine_users values(?,?,?,?,?,?,?,?,?,?)";
     private final static String LOAD_ALL="select * from admine_users";
     private final static String UPDATE="update admine_users set "+
                                        "admine_name=?"+
                                        ",admine_pwd=?"+
                                        ",admine_real_name=?"+
                                        ",admine_sex=?"+
                                        ",admine_birthday=?"+
                                        ",admine_email=?"+
                                        ",admine_phone=?"+
                                        ",admine_addr=?"+
                                        ",admine_postcode=?"+
                                        "where admine_id=?";
     private final static String DELETE="delete from admine_users where admine_id=?";
     private final static String GET_ONE="select * from admine_users where admine_id=?";
     private final static String GET_ONE_EMAIL="select * from admine_users where admine_email=?";
     private final static String MODIFYPWD="update admine_users set admine_pwd=? where admine_id=?";
     /* (non-Javadoc)
	 * @see net.gdm.dao.AdmineDao#ListAdmine()
	 */
	public List<Admine> ListAdmine() {
		// TODO Auto-generated method stub
	   Connection conn=OracleUtil.getInstance().getConn();
	   PreparedStatement pstmt=null;
	   List<Admine> listadmine=null;
	   ResultSet rest=null;
	   try {
		pstmt=conn.prepareStatement(LOAD_ALL);
		listadmine=new ArrayList<Admine>();
		rest=pstmt.executeQuery();
		
		while(rest.next())
		{
			Admine admine=new Admine();
			admine.setAdimine_id(rest.getInt("admine_id"));
			admine.setAdmine_name(rest.getString("admine_name"));
			admine.setAdmine_pwd(rest.getString("admine_pwd"));
			admine.setAdmine_real_name(rest.getString("admine_real_name"));
			admine.setAdmine_sex(rest.getString("admine_sex"));
            admine.setAdmine_birth(rest.getDate("admine_birthday"));
			admine.setAdmine_email(rest.getString("admine_email"));
			admine.setAdmine_tel(rest.getString("admine_phone"));
			admine.setAdmine_address(rest.getString("admine_addr"));
			admine.setAdmine_postcode(rest.getString("admine_postcode"));
			listadmine.add(admine);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
	    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
	 }
		return listadmine;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.AdmineDao#addAdmine(net.gdm.demo.Admine)
	 */
	public void addAdmine(Admine admine) {
		// TODO Auto-generated method stub
		  Connection conn=OracleUtil.getInstance().getConn();
		  PreparedStatement pstmt=null;
		  
		  try {
				pstmt=conn.prepareStatement(ADD);
				pstmt.setInt(1, admine.getAdimine_id());
				pstmt.setString(2, admine.getAdmine_name());
				pstmt.setString(3, admine.getAdmine_pwd());
				pstmt.setString(4, admine.getAdmine_real_name());
				pstmt.setString(5, admine.getAdmine_sex());
				pstmt.setTimestamp(6, new Timestamp(admine.getAdmine_birth().getTime()));
				//pstmt.setDate(6, (Date) admine.getAdmine_birth());
				pstmt.setString(7, admine.getAdmine_email());
				pstmt.setString(8, admine.getAdmine_tel());
				pstmt.setString(9, admine.getAdmine_address());
				pstmt.setString(10, admine.getAdmine_postcode());
				System.out.print(ADD);
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
	 * @see net.gdm.dao.AdmineDao#deleteAdmine(int)
	 */
	public void deleteAdmine(int admineid) {
		// TODO Auto-generated method stub
		  Connection conn=OracleUtil.getInstance().getConn();
		  PreparedStatement pstmt=null;
		  
		  try {
			pstmt=conn.prepareStatement(DELETE);
			pstmt.setInt(1, admineid);
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
	 * @see net.gdm.dao.AdmineDao#getOne(int)
	 */
	public Admine getOne(int admineid) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		Admine admine=new Admine();
		
		try {
			pstmt=conn.prepareStatement(GET_ONE);
			pstmt.setInt(1, admineid);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				admine.setAdimine_id(rest.getInt("admine_id"));
				admine.setAdmine_name(rest.getString("admine_name"));
				admine.setAdmine_pwd(rest.getString("admine_pwd"));
				admine.setAdmine_real_name(rest.getString("admine_real_name"));
				admine.setAdmine_sex(rest.getString("admine_sex"));
				admine.setAdmine_birth(rest.getDate("admine_birthday"));
				admine.setAdmine_email(rest.getString("admine_email"));
				admine.setAdmine_tel(rest.getString("admine_phone"));
				admine.setAdmine_address(rest.getString("admine_addr"));
				admine.setAdmine_postcode(rest.getString("admine_postcode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
		 } 	
		return admine;
	}

	/* (non-Javadoc)
	 * @see net.gdm.dao.AdmineDao#updateAdmine(net.gdm.demo.Admine)
	 */
	public void updateAdmine(Admine admine) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			pstmt=conn.prepareStatement(UPDATE);
			pstmt.setString(1, admine.getAdmine_name());
		    pstmt.setString(2, admine.getAdmine_pwd());
		    pstmt.setString(3, admine.getAdmine_real_name());
		    pstmt.setString(4, admine.getAdmine_sex());
		    pstmt.setTimestamp(5, new Timestamp(admine.getAdmine_birth().getTime()));
		    pstmt.setString(6, admine.getAdmine_email());
		    pstmt.setString(7, admine.getAdmine_tel());
		    pstmt.setString(8, admine.getAdmine_address());
		    pstmt.setString(9, admine.getAdmine_postcode());
		    pstmt.setInt(10, admine.getAdimine_id());
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

	@Override
	public Admine getOne(String email) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rest=null;
		Admine admine=new Admine();
		
		try {
			pstmt=conn.prepareStatement(GET_ONE_EMAIL);
			pstmt.setString(1, email);
			rest=pstmt.executeQuery();
			
			while(rest.next())
			{
				admine.setAdimine_id(rest.getInt("admine_id"));
				admine.setAdmine_name(rest.getString("admine_name"));
				admine.setAdmine_pwd(rest.getString("admine_pwd"));
				admine.setAdmine_real_name(rest.getString("admine_real_name"));
				admine.setAdmine_sex(rest.getString("admine_sex"));
				admine.setAdmine_birth(rest.getDate("admine_birthday"));
				admine.setAdmine_email(rest.getString("admine_email"));
				admine.setAdmine_tel(rest.getString("admine_phone"));
				admine.setAdmine_address(rest.getString("admine_addr"));
				admine.setAdmine_postcode(rest.getString("admine_postcode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		    OracleUtil.getInstance().releaseRes(conn, pstmt, rest);
		 } 	
		return admine;
	}


	@Override
	public void modifyPwd(Admine adm) {
		// TODO Auto-generated method stub
		Connection conn=OracleUtil.getInstance().getConn();
		PreparedStatement pstmt=null;

		try {
			
			pstmt=conn.prepareStatement(MODIFYPWD);
			pstmt.setString(1, adm.getAdmine_pwd());
		    pstmt.setInt(2, adm.getAdimine_id());
		    pstmt.executeUpdate();
		    conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Page loadPagedAdmine(AdmineQueryHelper helper, Page page) {
		// TODO Auto-generated method stub
		return null;
	}
}
