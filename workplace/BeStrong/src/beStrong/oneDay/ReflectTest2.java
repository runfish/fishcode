/**
 * 
 */
package beStrong.oneDay;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * @author Administrator
 *
 */
public class ReflectTest2 {

	/**
	 * @param args
	 */
	
	/**
	 * 小框架的讲解应用
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		//一定要记住文件完整的路径 完整的路径不是硬编码 而是计算所得
		//InputStream ips = new FileInputStream("config.properties");//这个是个相对路劲的文件
		//需要文件的绝对路径getRealPath();
		//使用类加载器提供的方法加载普通文件到内存
		//InputStream ips = ReflectTest2.class.getClassLoader().getResourceAsStream("beStrong/oneDay/config.properties");
		                   //这里是获取类加载器                                            //besStrong前不可以加/
		//InputStream ips =ReflectTest2.class.getResourceAsStream("config.properties");
		//InputStream ips =ReflectTest2.class.getResourceAsStream("resource/config.properties");
		
		//如果配置文件与该类同属一个包内 则可以使用相对路径// 若是属于该类包的子包中则需在文件名钱加上子包的路径就ok
		
		InputStream ips =ReflectTest2.class.getResourceAsStream("/beStrong/oneDay/resource/config.properties");
		//绝对路径需要些完整的路径
		
		Properties props = new Properties();
		props.load(ips);
		ips.close();
		/**
		 * ips.close只是释放系统资源 而没有消除对象 ips这个
		 * 对象是由java虚拟机进行统一管理的
		 */
		String className = props.getProperty("className");
		Collection collection = (Collection)Class.forName(className).newInstance();
		
		RefectPoint pt1 = new RefectPoint(3,5);
		RefectPoint pt2 = new RefectPoint(3,3);
		RefectPoint pt3 = new RefectPoint(3,5);
	
		//没有覆盖hashcode的方法的话则运行结果是3也有可能是2
		//前提是哈希集合
		//每一个对象都会有一个相应的哈希code的值 根据不同的值会存在一个局域
		//当一个对象存在哈希集合中就不要修改对象身上参与哈希计算的字段
		collection.add(pt1);
		collection.add(pt2);
		collection.add(pt3);
		collection.add(pt1);
		
	    //pt1.name = 12;
		//collection.remove(pt1);
		/**
		 * 这里会产生内存泄露 如果再存入对象后修改对象参与哈希值计算的字段则会产生内存泄露
		 * 这个对象将会脱离控制  不能删除
		 * 
		 */
		System.out.println(collection.size());

	}

}
