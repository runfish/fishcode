package net.dfrz.supershop01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {


	private static final DButils utils=new DButils(); 
	
	private DButils()
	{
		
	}
	/**
	 * 返回一个DButils的实例
	 * @return
	 */
	public static DButils getInstance()
	{
		return utils;
	}
	/**
	 * 获取一个连接
	 * @return
	 */
	public Connection getConn()
	{
		Connection conn=null;
		try 
		{

			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			conn=DriverManager.getConnection("proxool.carsys");
				
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void releaseRes(Connection conn, PreparedStatement pstmt,ResultSet reset)
	{
		try 
		{
			if(conn!=null)
				conn.close();
			if(pstmt!=null)
				pstmt.close();
			if(reset!=null)
				reset.close();
		} catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
