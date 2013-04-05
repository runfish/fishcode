/**
 * 
 */
package net.dfrz.supershop01.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.dfrz.supershop01.domain.Administrator;

/**
 * @author hhg0012
 *
 */
public class OnLineUserListener implements HttpSessionListener{
    
	private static long onlineUserNo=0;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
			synchronized (this) {
				 
				onlineUserNo++;
				
			}	
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	
		   synchronized (this) {
			   
			   onlineUserNo--;
		
		}
	}
	public static long getOnlineUserNo()
	{
		return onlineUserNo;
	}
}
