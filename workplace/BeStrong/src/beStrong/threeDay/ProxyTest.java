/**
 * 
 */
package beStrong.threeDay;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.istack.internal.FinalArrayList;

/**
 * @author Administrator
 *
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		/**
		 * 运用java虚拟机动态创建类
		 */
		
		/**
		 * Stringbuffer与 StringBuilt的区别
		 * 单线程的情况下StringBuilt的效率高
		 * 多线程的情况下StringBuffer的效率高
		 * 
		 */
		Class clazzProxy = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);

		System.out.println(clazzProxy.getName());
		System.out.println("begin constructor list");
		Constructor[] constructors = clazzProxy.getConstructors();
		for(Constructor constructor : constructors){
			String name = constructor.getName();
			StringBuilder s = new StringBuilder(name);
			s.append("(");
			Class[] clazzParames = constructor.getParameterTypes();
			for(Class clazzParame:clazzParames){
				s.append(clazzParame.getName()).append(",");
				
			}
			if(clazzParames!=null && clazzParames.length!=0)
			    s.deleteCharAt(s.length()-1);
			s.append(")");
		System.out.println(s.toString());
		}
		
		/**
		 * 使用反射方式得到一个类的字节码对象 如果这个类身上有一个不带参的构造方法
		 * 则可以直接用这个字节码对象创建这个类的对象 如果没有则不行创建对象
		 * 此时需要获取这个类带参的构造方法  通过构造放放进行创建类的实例对象
		 */
		Constructor constructor = clazzProxy.getConstructor(InvocationHandler.class);
		Collection proxyCollection = (Collection)constructor.newInstance(new Myinvocationhandler());
		
		System.out.println(proxyCollection);
		
		Collection proxyCollection1 = (Collection)constructor.newInstance(new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		/**
		 * ，面向切面编程就是把所要执行的代码封装为一个个对象
		 * 的方法 你执行对象的方法就是执行外部传递过去的代码
		 */
		
	 ArrayList target = new ArrayList();
		Collection proxy = (Collection)getProxy(target,new MyAdvice());
		
		
		proxy.add("xiaoyu");
		proxy.add("lh");
		proxy.add("ly");
		System.out.println(proxy.size());
	}

	/**
	 * 代理简要说明
	 * 代理需要两个条件
	 * 一就是需要目标
	 * 二是 系统功能
	 * 这两者都需要封装为一个对象传递进 
	 * @param target
	 * @param advice
	 * @return
	 */
	private static Object getProxy(final Object target,final Advice advice) {
	    Object proxy= (Object)Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(),
				    new InvocationHandler(){
			           
						@Override
						public Object invoke(Object proxy, Method method,
								Object[] args) throws Throwable {
							// TODO Auto-generated method stub
						
							advice.before(method);
							//long beginTime = System.currentTimeMillis();
							Object relValue = method.invoke(target, args);
							advice.after(method);
							//long endTime = System.currentTimeMillis();
							//System.out.println(method.getName()+"running time"+(endTime - beginTime) );
							return relValue;
						}
						
		} );
	  return proxy;
	}

}

class Myinvocationhandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}
