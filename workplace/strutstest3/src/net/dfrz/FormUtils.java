/**
 * 
 */
package net.dfrz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 *
 */
public class FormUtils {
	
	public static void fillForm(HttpServletRequest request,String formClassName,String formName){
		
		//analyze
		
		//1: instrance an object Actionform subClass
		
		//2: get all the paramter names
		    // get all filed name
		
		//3: match each paramter name of cilent with each property name of bean
		
		//4: if match  set the corresponding property value of bean with value obtained from the cilent
		
		//5: store the form in the session
		
		try {
			//1:
			ActionForm actionForm = (ActionForm)Class.forName(formClassName).newInstance();
			//2:
			Enumeration paramterEnumeration =request.getParameterNames();
			Field [] fields = actionForm.getClass().getDeclaredFields();
			//3£»
			while(paramterEnumeration.hasMoreElements()){
				String paramterName =(String)paramterEnumeration.nextElement();
				for(Field field:fields){
					String fieldName = field.getName();
					if(paramterName.equals(fieldName)){
						String value = request.getParameter(paramterName);
						org.apache.commons.beanutils.BeanUtils.setProperty(actionForm, fieldName, value);
					}
				}
				
			}
			request.getSession().setAttribute(formName,actionForm);
			System.out.println(actionForm);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
		
		
		
	}

}
