/**
 * 
 */
package net.dfrz.jiaqiang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Administrator
 *
 */
@Dfrz(color="red", value = "", array=1)
public class AnnotationTest {

	/**
	 * @param args
	 */
	
	@SuppressWarnings("deprecation")
	@Dfrz("abc")
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
//		System.runFinalizersOnExit(true);
//		if(AnnotationTest.class.isAnnotationPresent(Dfrz.class)){
//			
//			Dfrz annotation = (Dfrz)AnnotationTest.class.getAnnotation(Dfrz.class);
//			System.out.println(annotation);
//			System.out.println(annotation.color());
//			System.out.println(annotation.array().length);
//		}//检查这个类上的注解示是否存在
//		
//		
//		Collection<Integer> collection1 = new ArrayList<Integer>();
//		Collection<String> collection2 = new ArrayList<String>();
//		collection1.add(1);
//		collection2.add("abc");
//		collection1.getClass().getMethod("add", Object.class).invoke(collection1, "abc");
//		System.out.println(collection1);
		
	
		HashMap<String,Integer> maps = new HashMap<String, Integer>();
		maps.put("xiaoyu", 12);
		maps.put("huiqing", 34);
		maps.put("huanguan", 89);
		Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();
		for(Map.Entry<String, Integer> entry : entrySet){
			
			System.out.println(entry.getKey()+":"+entry.getValue());
			
		}
		Number number = add(3.5, 5);
	//	float number1 = add(3.5, 5);
		Object object = add("zxc", 23);
		System.out.println(number);
		System.out.println(object);
		
		swap(new String[]{"123","345","xcv"}, 1, 2);
		System.out.println();
		
		
		
		

	}
	
	private static <T> T add(T x,T y) {
		
		return y;
		
	}
	private static <T> void swap(T []a,int i,int j){
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static <T> T antoConvet(Object object){
		
		return (T)object;
	}

}
