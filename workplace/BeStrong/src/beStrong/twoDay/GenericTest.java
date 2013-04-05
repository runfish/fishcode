/**
 * 
 */
package beStrong.twoDay;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.text.DefaultEditorKit.CopyAction;

import beStrong.oneDay.RefectPoint;

/**
 * @author Administrator
 *
 */
public class GenericTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	
	/**
	 * java里面的泛型是给javac看的 目的是告诉编译器这个集合只能装某种类型
	 * 通过反射的方式可以在一个已经指定类型的
	 * 参数化类型是不考虑继承关系的
	 * 
	 * 泛型中的问号是？是通配符 表示能匹配任意类型
	 * Collection<? extend Integer>
	 * Collection<? super Integer>
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ArrayList collection = new ArrayList();
		collection.add("abc");
		collection.add(23);
		collection.add('A');
		
		ArrayList<String> collection1 = new ArrayList<String>();
		collection1.add("abc");
		
		ArrayList<Integer> collection2 = new ArrayList<Integer>();
		
		System.out.println(collection1.getClass()==collection2.getClass());
		
		collection2.getClass().getMethod("add", Object.class).invoke(collection2, "abc");
		
		System.out.println(collection2.get(0));
	//	printCollection(collection2);这里会报错这就相当于Collection<Object> collection = new ArrayList<Integer>(); 这是不允许的

		printCollection(collection2);
		
		
		HashMap<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("xiaoyu", 23);
		maps.put("lh", 24);
		maps.put("ly", 24);
		
		Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();
		
		for(Map.Entry<String, Integer> entry: entrySet){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		
		swap(new String[]{"abc","123","cdr"}, 2, 1);
		String obj = "abc";
		String x1 = antoConvert(obj);
		
		copy1(new Vector<String>(),new String[10] );//这里之前的集合泛型对象直接决定后参数的参数对象类型  这里有类型推断
		copy(new Date[10], new String[10]);//这里会取两个对象的交集 
		
		GenericDao<RefectPoint> genericDao = new GenericDao<RefectPoint>();
		genericDao.add(new RefectPoint(3,3));
		//String xString = genericDao.getPersionById("23");
		
		//Vector<Date> v1 = new Vector<Date>();
		
		/**
		 * 总结
		 * 以泛型的方式得到参数类型
		 *  单纯通过泛型的对象是无法获取到泛型确切的数据类型
		 * 但是可以通过作为一个方法的参数方式  通过对该方法进行反射获取
		 * 此泛型的确切数据类型
		 * 
		 */
		Method applyMethod = GenericTest.class.getMethod("applyVector",Vector.class );
		Type[] type = applyMethod.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType) type[0];
		System.out.println(pType.getRawType());//这个是一个原始类型
		System.out.println(pType.getActualTypeArguments()[0]);
		
		
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}

/*	
	public static void applyVector(Vector<Date> v1){
		
	}
	public static void applyVector(Vector<Integer> v1){
		
	}
	这不是重载 泛型有去类型化  既在编译之后去泛型化
	*/
	
	public static void printCollection(Collection<?> collection){
		System.out.println(collection.size());
		
		for(Object obj : collection){
			System.out.println(obj);
		}
		
	
	}
	/**
	 * 此泛型的方法接受任意参数  如果两个参数的类型不一样 
	 * 会自动去两个参数类型的交集
	 * @param <T>
	 * @param x
	 * @param y
	 * @return
	 */
	public static <T> T add(T x, T y){
		
		return null;
		
	}
	
	/**
	 * 泛型的类型是对象类型或者引用类型但是int[] 会报错是因为int【】 本身就是一个对象不会进行拆成int基本类型
	 * 
	 * 在返回值之前加个<T>
	 * 
	 * @param <T>
	 * @param a
	 * @param i
	 * @param j
	 */
	public static <T>void swap(T[] a, int i, int j){
		
		T temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		
	}
	
	public static <T> T antoConvert(Object obj){
		return (T)obj;
		
	}
	/**
	 * 打印任意类型的集合
	 * 通配符的方法比泛型夫人方法更有效
	 * @param collection
	 */
	public static <T>void printCollection1(Collection<T> collection,T obj){
		System.out.println(collection.size());
		
		for(Object obj1 : collection){
			System.out.println(obj1);
		}
		collection.add(obj);
		
	
	}
	public static <T> void copy1(Collection<T> c,T[] a){
		
	}
	
	public static <T> void copy(T[] a, T[] b){
		
	}
	

}
