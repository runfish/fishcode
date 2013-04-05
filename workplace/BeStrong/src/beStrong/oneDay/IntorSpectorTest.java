/**
 * 
 */
package beStrong.oneDay;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @author Administrator
 *
 */
public class IntorSpectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		RefectPoint rp1 = new RefectPoint(3,5);
		String protypeName = "color";
		PropertyDescriptor pd = new PropertyDescriptor(protypeName,rp1.getClass()); 
		
		Method methodGetColor = pd.getReadMethod();
		Object returnvalue = methodGetColor.invoke(rp1);
		System.out.println(returnvalue);
		
		
       // PropertyDescriptor pd2 = new PropertyDescriptor(protypeName,rp1.getClass()); 
		
		Method methodSetColor = pd.getWriteMethod();
		methodSetColor.invoke(rp1,23);
		System.out.println(rp1.getColor());
		

		BeanInfo beanInfo = Introspector.getBeanInfo(rp1.getClass());
		PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
		Object reValue = null;
		for(PropertyDescriptor pd1 : pds){
			if(pd1.getName().equals(protypeName)){
				Method methodColor = pd1.getReadMethod();
				methodColor.invoke(rp1);
				break;
			}
		}
		
		

	}

}
