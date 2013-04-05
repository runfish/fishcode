package net.dfrz;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;





public class ReflectTest {
	
	
	public static void main(String [] agrs) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		
		ReflectPoint rp = new ReflectPoint(3,30);
		
		Field  fieldY = rp.getClass().getField("y");
		System.out.println(fieldY.get(rp));
		Field fieldX = rp.getClass().getDeclaredField("x");
		fieldX.setAccessible(true);
		System.out.println(fieldX.get(rp));
		
		changeStringValue(rp);
		
		System.out.println(rp);
		String string = "abc";
		
		Method methodCharAt = String.class.getMethod("charAt", int.class);
		System.out.println(methodCharAt.invoke(string, 1));
		
		
		
	}

	private static void changeStringValue(Object obj) throws IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		Field [] fields = obj.getClass().getFields();
		
		for(Field field:fields ){
			//这里用双等号 因为字节码只有一份
			if(field.getType()==String.class){
				//属性的类型
				String oldvalue=(String)field.get(obj);
				String newValue = oldvalue.replace('b', 'a');
				field.set(obj, newValue);
			}
		}
		
	}

}
