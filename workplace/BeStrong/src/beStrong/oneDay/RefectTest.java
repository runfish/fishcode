/**
 * 
 */
package beStrong.oneDay;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author Administrator
 *
 */
public class RefectTest {

	private static final String Object = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String str = "abc";
		Class class1 = str.getClass();
		Class class2 = String.class;
		Class class3 = Class.forName("java.lang.String");
		System.out.println(class1==class2);
		System.out.println(class2==class3);
		System.out.println(class1==class3);
		
		System.out.println(class1.isPrimitive());//判断此份字节码是否为原始类型
		System.out.println(int.class.isPrimitive());
		System.out.println(Integer.class.isPrimitive());
		System.out.println(int.class == Integer.class);
		System.out.println(int.class == Integer.TYPE);//integet.type 表示此包装类型所包装的那个基本类型的字节码
		System.out.println(int[].class.isPrimitive());
		System.out.println(int[].class.isArray());//数组类型的实例对象所用的方法是 isArray
		//总之只要是在源程序中出现的类型都有各自的class实例对象 eg  ： int【】  void 等
		
		// 反射就是把一个java类上的所有成分映射成一个个java类
		//new String(new StringBuffer());
		Constructor constructor = String.class.getConstructor(StringBuffer.class);//获得某一构造方法是要用到类型对象
		                                                           
		
		String string = (String)constructor.newInstance(new StringBuffer("abc"));//newInstance 返回的是一个object的对象 需要对其进行强制类型装换
		//严格区分变异与运行的不同
		
		//若要new一个不带参数的构造方法的对象 直接就可以Class.newInstance
		String.class.newInstance();
		

		System.out.println(string.charAt(2));
		
		
//		//RefectPoint pt1 = new RefectPoint("red","xiaoyu");
//	    Field field = pt1.getClass().getField("name");//name 字段属性是公有的 public
//	    System.out.println( field.get(pt1));
//	    Field field2 = pt1.getClass().getDeclaredField("color");//这里的color属性 为私有  
//	    field2.setAccessible(true);//这里要进行抢值  设置为可以访问  号称暴力反射
//	    System.out.println( field2.get(pt1));
//	    
//	    changeStringvalue( pt1);
	    
	    Method methodCharAtMethod = String.class.getMethod("charAt", int.class);
	    System.out.println(methodCharAtMethod.invoke(str, 2));//如果调用的是静态方法
	    //则str则可以写成nulll；
	    System.out.println(methodCharAtMethod.invoke(str, new Object []{2}));
	    
	    //TextArguments.main(new String[]{"123","xiaoyu","hehe"});
	    //为什么 要用反射的方式调用
	    
	    String  className = args[0];
	    Method mainMethod = Class.forName(className).getMethod("main", String[].class);
	    mainMethod.invoke(null, new Object[]{new String[]{"123","2345","xiaoyu"}});//这里先会拆包  如果直接是字符串数组的话就会认为传递了n个参数  所以先要打包为一个object类型的对象
	    //传进去 接着会自动拆包  这里有第二种方法 就是直接把字符串对象的类型强制类型转化为object类型就ok
	    
	    int [] a1 = new int[]{1,2};
	    int [] a2 = new int[3];
	    int [][] a3 = new int [2][3];
	    String [] a4 = new String[]{"zx","asd","sdsd"};
	    System.out.println(a1.getClass()==a2.getClass());//注意这里比较的是两个对象所所对应的字节码  而不是对象
	    System.out.println(a1.getClass()==a3.getClass());
	    System.out.println(a1.getClass()==a4.getClass());
	    System.out.println(a1.getClass().getName());
	    System.out.println(a3.getClass().getName());
	    System.out.println(a1.getClass().getSuperclass().getName());
	    System.out.println(a4.getClass().getSuperclass().getName());
	    
	    Object object1 = a1;//基本类型不是object的类型 object里面装的是int类型的数组
	    Object object2 = a2;
	    Object object3[] = a3;//int[]类型是object类型
	    Object object4 = a4; //String 也是object的类型
	    System.out.println(a1);
	    System.out.println(a4);//这样打印出的结果只是对象的哈希code
	    System.out.println(Arrays.asList(a1));//Arrays是一个工具类接收的是一个object的数组
	    //String类型的数组按jdk1.4的方式处理等效于多个元素 
	    //a1是不是object的数组 所以就按jdk1.5的方法进行处理 单做一个元素处理
	    System.out.println(Arrays.asList(a4));
	    
	    //接下来对数组进行反射
	    
	    printObject(a4);
	    printObject(a1);
	
	}

	private static void printObject(Object obj) {
		// TODO Auto-generated method stub
		Class  clazz = obj.getClass();
		if(clazz.isArray()){
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++){
				System.out.println(Array.get(obj, i));
				System.out.println(Array.get(obj, i).getClass().getName());
			}
			
		}
		else{
			System.out.println(obj);
		}
		
	}

	private static void changeStringvalue(Object obj)throws Exception {
		// TODO Auto-generated method stub
		Field field[] = obj.getClass().getFields();
		
		for(Field f : field){
			if(f.getType() == String.class){//这里都只是一份字节码 所以用等号
				String oldValue = (String)f.get(obj);
				
				String newValue = oldValue.replace('a', 'b');
				f.set(obj, newValue );//腰包修改后的字段重新设置到字段中
				System.out.println(f.get(obj));
			}
		}
		
	}
	
}

class TextArguments{
	
	public static void main(String [] agrs){
		for(String agr : agrs){
			System.out.println(agr);
		}
	}
}
