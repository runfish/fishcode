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
		 * ����java�������̬������
		 */
		
		/**
		 * Stringbuffer�� StringBuilt������
		 * ���̵߳������StringBuilt��Ч�ʸ�
		 * ���̵߳������StringBuffer��Ч�ʸ�
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
		 * ʹ�÷��䷽ʽ�õ�һ������ֽ������ ��������������һ�������εĹ��췽��
		 * �����ֱ��������ֽ�����󴴽������Ķ��� ���û�����д�������
		 * ��ʱ��Ҫ��ȡ�������εĹ��췽��  ͨ������ŷŽ��д������ʵ������
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
		 * �����������̾��ǰ���Ҫִ�еĴ����װΪһ��������
		 * �ķ��� ��ִ�ж���ķ�������ִ���ⲿ���ݹ�ȥ�Ĵ���
		 */
		
	 ArrayList target = new ArrayList();
		Collection proxy = (Collection)getProxy(target,new MyAdvice());
		
		
		proxy.add("xiaoyu");
		proxy.add("lh");
		proxy.add("ly");
		System.out.println(proxy.size());
	}

	/**
	 * �����Ҫ˵��
	 * ������Ҫ��������
	 * һ������ҪĿ��
	 * ���� ϵͳ����
	 * �����߶���Ҫ��װΪһ�����󴫵ݽ� 
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
