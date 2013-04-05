package net.dfrz.supershop01.utils;

/**
 * 
 */


import java.sql.Connection;
import java.sql.SQLException;

import net.dfrz.supershop01.exception.DataAccessException;

/**
 * @author J1205-HongHG
 *
 */
public class TransactionManager {
	

	private Connection conn;
	
	public TransactionManager() {
		this.conn = DBUtils.getInstance().getConn();
	}

	/**
	 * ��������
	 * @throws DAOException
	 */
	public void beginTransaction(){
		try {
			 //�������ύ��ʽ��Ϊ�ֹ��ύ
			 conn.setAutoCommit(false); 
		} catch (SQLException e) {
			throw new DataAccessException("��ʼ����ʱ�����쳣",e);
		}
	}
	
	/**
	 * �ύ����
	 * @throws DAOException
	 */
	public void commitAndClose(){
		try {
			conn.commit();
		} catch (SQLException e) {
			throw new DataAccessException("�ύ����ʱ�����쳣",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	/**
	 * �ع�����
	 * @throws DAOException
	 */
	public void rollbackAndClose(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			throw new DataAccessException("�ع�����ʱ�����쳣",e);
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
}
