package beStrong.threeDay.aopframkwork;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import beStrong.threeDay.Advice;

public class ProxyFactoryBean {

	private Advice advice;
	private Object target;
	
	
	public Advice getAdvice() {
		return advice;
	}


	public void setAdvice(Advice advice) {
		this.advice = advice;
	}


	public Object getTagert() {
		return target;
	}


	public void setTagert(Object tagert) {
		this.target = tagert;
	}


	public Object getProxy() {
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
