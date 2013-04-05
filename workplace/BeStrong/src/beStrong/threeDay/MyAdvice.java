package beStrong.threeDay;

import java.lang.reflect.Method;

public class MyAdvice implements Advice {
	long beginTime ;
	@Override
	public void after(Method method) {
		// TODO Auto-generated method stub
	
		long endTime = System.currentTimeMillis();
		System.out.println(method.getName()+"running time"+(endTime - beginTime) );
		System.out.println("over");
	}

	@Override
	public void before(Method method) {
		// TODO Auto-generated method stub
		System.out.println("start");
		beginTime= System.currentTimeMillis();
	}

}
