/**
 * 
 */
package net.dfrz.supershop01.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.dfrz.supershop01.utils.TransactionManager;
import net.dfrz.supershop01.exception.DataAccessException;
/**
 * @author Administrator
 *
 */
public class DBUtils {
	
	
private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();	
	
	private static DBUtils me=new DBUtils();
	
	private DBUtils() {}
	
	public static DBUtils getInstance()
	{
		return me;
	}
	
	//һ����̬���ڸ��౻���ص�ʱ���Զ�����һ�Σ�Ȼ�󽫲������С�
	static {
		try {			
			//�鿴��·�����Ƿ����������������
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static synchronized Connection getConn()
	{
		
		//�ȴӵ�ǰ�߳���ȡ������ʵ��
		Connection conn = tl.get();	
		
		//�����ǰ�߳���û��Connection��ʵ�� 
		if(null == conn){ 				
			try {
				//�����ӳ���ȡ��һ������ʵ�� 
				conn = DriverManager.getConnection("proxool.supershop01-ds");
				//�����󶨵���ǰ�߳���
				tl.set(conn); 
			} catch (SQLException e) {					
				throw new DataAccessException("��ȡ����ʱ�쳣",e);
			}
		
		}
		
			
		return conn;
		
	}
	
	/**
	 * �ͷ����ݿ���Դ
	 * @param conn
	 * @param pstmt
	 * @param rset
	 */
	public void releaseConn(Connection conn){
		if(conn!=null)  {
			tl.remove(); //�ͷŸ��߳��ϵ����Ӱ���
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void ReleaseRes(Connection conn,PreparedStatement pstmt,ResultSet rset)
	{
		try{
		  if(rset!=null) rset.close();
		  if(pstmt!=null) pstmt.close();
		 // if(conn !=null) conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static synchronized TransactionManager getTranManager(){
		return new TransactionManager();
	}
	

}