package net.dfrz.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtils {
	
	private static final DBUtils me=new DBUtils();
		
	private DBUtils() {
		super();
	}
	
	public static DBUtils getInstance(){
		return me;
	}


	public Connection getConn(){
		
		Connection conn=null;
		
		try {
			//查看类路径中是否存在这个驱动入口类
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.hotelsys-ds");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	
	public void releaseRes(Connection conn,PreparedStatement pstmt,ResultSet rset){

			try {
				
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	

}
