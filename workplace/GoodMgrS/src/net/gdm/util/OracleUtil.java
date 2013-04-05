/**
 * 
 */
package net.gdm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Administrator
 *
 */
public class OracleUtil {
	private static final OracleUtil me = new OracleUtil();

	public OracleUtil() {

	}

	public static OracleUtil getInstance() {
		return me;
	}

	public Connection getConn() {
		Connection con = null;
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="gxuser";
		String pwd="gxpwd";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pwd);	
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public void releaseRes(Connection con, PreparedStatement pstmt, ResultSet rset) {

		try {
			if (rset != null)  rset.close();
			if (pstmt != null) pstmt.close();
			if (con!=null)    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
