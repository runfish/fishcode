package net.dfrz.supershop01.exception;

/**                
 * Project: supershop01-02
 * ClassName: DataAccessException                                                          
 * Comments: ��װ�������ݲ��쳣  
 * JDK :jdk1.6.0_10 
 * Create Date�� 2013-1-8
 * @see net.dfrz.supershop01.exception.ApplicationException
 * @see #DataAccessException()
 * @see #DataAccessException(String)
 * @see #DataAccessException(Throwable)
 * @see #DataAccessException(String, Throwable)
 * @author J1205-HongHG
 * @version 5
 */
public class DataAccessException extends ApplicationException {
	/**
	 *���ݲ��쳣��Ĭ�Ϲ��캯��
	 */
	public DataAccessException() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * ���ݲ��쳣�Ĵ��ι��캯��
	 * @param message -�쳣��Ϣ
	 */
	public DataAccessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	/**
	 * ���ݲ��쳣�Ĵ��ι��캯��
	 * @param cause -�쳣����
	 */
	public DataAccessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	/**
	 * ���ݲ��쳣�Ĵ��ι��캯��
	 * @param message -�쳣��Ϣ
	 * @param cause -�쳣����
	 */
	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
