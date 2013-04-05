package net.dfrz;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.dfrz.Apple;
public class Test {


	public static void main(String[] agrs){
		String string ="abc";
		Class class1=null; 
		try {
			 class1 = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Class class2 = string.getClass();
		
		Class class3 = String.class;
		
		System.out.println(class2==class3);
		System.out.println(class1==class3);
		Constructor constructor=null;
	    try {
			constructor=String.class.getConstructor(StringBuffer.class);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String string2=(String)constructor.newInstance(new StringBuffer("abs"));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Class cls1=new Apple().getClass();
	
}
