/**
 * 
 */
package beStrong.twoDay;

import java.util.Date;



/**
 * @author Administrator
 *
 */
public class ClassLoderTest {

	/**
	 * @param args
	 */
	/**
	 * 类加载器
	 * 1.bootStrap    加载的类是jre地下的tr.jar
	 * 2.ExtClassLoder 加载的类是JRE/lib/ext/*.jar
	 * 3.AppClassLoder 加载的类是classPath指定的所有jar或目录
	 * 
	 * 
	 * 类加载器的委托机制
	 * 子类加载器先请求父类的加载器加载 知道顶级加载器  如果加载不到 在往子类加载器推
	 * 如果推到发起者还没有找到类，就不会再继续找了直接抛出异常
	 * 
	 * 自己写类加载器的预备知识
	 * 自己写的类加载器需要继承ClassLoder  每个类加载器都有一个父类 才能挂到java虚拟机类加载器的树上
	 * findClass（）方法父类没找到类就直接调用自己写的类加载类的findClass
	 * 所以只要凭覆盖findClass（） 就行 这个方法就是自己做的方法
	 * 总体的流程又父类定义！细节可能又自己实现  
	 * 不能覆盖loadClass()的方法 因为父类的这个方法包含了控制流程
	 * 父类-》classLoad-》findClass-》得到class文件的转化为字节码--》definClass()
	 * 
	 */
	
	/**
	 * 
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ClassLoderTest.class.getClassLoader().getClass().getName());
		System.out.println(System.class.getClass().getName());//这里的getClassLoder为null  但不代表他没有类加载器 只是这是一个特殊的类加载器
        //System这个类是有bootstrop类加载器加载的
		
		ClassLoader classLoader = ClassLoderTest.class.getClassLoader();
		while(classLoader !=null){
			System.out.println(classLoader.getClass().getName());
			classLoader = classLoader.getParent();
		}
		System.out.println(classLoader);
		
		//System.out.println(new ClassLoaderAtt().toString());
		
       Class clazz = new MyClassLoderTest("xiaoyulib").loadClass("ClassLoaderAtt");
       Date d1 =(Date)clazz.newInstance();
       System.out.println(d1);
		
	}

}
