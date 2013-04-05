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
	 * java����ķ����Ǹ�javac���� Ŀ���Ǹ��߱������������ֻ��װĳ������
	 * ͨ������ķ�ʽ������һ���Ѿ�ָ�����͵�
	 * �����������ǲ����Ǽ̳й�ϵ��
	 * 
	 * �����е��ʺ��ǣ���ͨ��� ��ʾ��ƥ����������
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
	//	printCollection(collection2);����ᱨ������൱��Collection<Object> collection = new ArrayList<Integer>(); ���ǲ������

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
		
		copy1(new Vector<String>(),new String[10] );//����֮ǰ�ļ��Ϸ��Ͷ���ֱ�Ӿ���������Ĳ�����������  �����������ƶ�
		copy(new Date[10], new String[10]);//�����ȡ��������Ľ��� 
		
		GenericDao<RefectPoint> genericDao = new GenericDao<RefectPoint>();
		genericDao.add(new RefectPoint(3,3));
		//String xString = genericDao.getPersionById("23");
		
		//Vector<Date> v1 = new Vector<Date>();
		
		/**
		 * �ܽ�
		 * �Է��͵ķ�ʽ�õ���������
		 *  ����ͨ�����͵Ķ������޷���ȡ������ȷ�е���������
		 * ���ǿ���ͨ����Ϊһ�������Ĳ�����ʽ  ͨ���Ը÷������з����ȡ
		 * �˷��͵�ȷ����������
		 * 
		 */
		Method applyMethod = GenericTest.class.getMethod("applyVector",Vector.class );
		Type[] type = applyMethod.getGenericParameterTypes();
		ParameterizedType pType = (ParameterizedType) type[0];
		System.out.println(pType.getRawType());//�����һ��ԭʼ����
		System.out.println(pType.getActualTypeArguments()[0]);
		
		
	}
	
	public static void applyVector(Vector<Date> v1){
		
	}

/*	
	public static void applyVector(Vector<Date> v1){
		
	}
	public static void applyVector(Vector<Integer> v1){
		
	}
	�ⲻ������ ������ȥ���ͻ�  ���ڱ���֮��ȥ���ͻ�
	*/
	
	public static void printCollection(Collection<?> collection){
		System.out.println(collection.size());
		
		for(Object obj : collection){
			System.out.println(obj);
		}
		
	
	}
	/**
	 * �˷��͵ķ��������������  ����������������Ͳ�һ�� 
	 * ���Զ�ȥ�����������͵Ľ���
	 * @param <T>
	 * @param x
	 * @param y
	 * @return
	 */
	public static <T> T add(T x, T y){
		
		return null;
		
	}
	
	/**
	 * ���͵������Ƕ������ͻ����������͵���int[] �ᱨ������Ϊint���� �������һ�����󲻻���в��int��������
	 * 
	 * �ڷ���ֵ֮ǰ�Ӹ�<T>
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
	 * ��ӡ�������͵ļ���
	 * ͨ����ķ����ȷ��ͷ��˷�������Ч
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
