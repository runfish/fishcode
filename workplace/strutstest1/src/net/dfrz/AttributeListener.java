/**
 * 
 */
package net.dfrz;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.struts.action.ActionForm;

/**
 * @author Administrator
 *
 */
public class AttributeListener implements HttpSessionAttributeListener,
		ServletRequestAttributeListener {
	

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
		String attributeName = event.getName();
		Object obj = null;
		if(event.getValue() instanceof ActionForm){
			System.out.println(" in session add");
			System.out.println("name="+attributeName+"\tvalue="+event.getValue());
		}
		

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println(" in session remove");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		System.out.println(" in session replaced");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
	
		String attributeName = event.getName();
		Object obj = null;
		if(event.getValue() instanceof ActionForm){
			System.out.println(" in request add");
			System.out.println("name="+attributeName+"\tvalue="+event.getValue());
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println(" in request remove");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		// TODO Auto-generated method stub
		System.out.println(" in request replaced");
	}

}
