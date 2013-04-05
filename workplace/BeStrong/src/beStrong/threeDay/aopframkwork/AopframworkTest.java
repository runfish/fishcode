package beStrong.threeDay.aopframkwork;

import java.io.InputStream;
import java.util.Collection;

public class AopframworkTest {
	
	public static void main(String[] args)throws Exception {
		
		InputStream ips =AopframworkTest.class.getResourceAsStream("config.properties");
		
	
		Collection bean = (Collection)new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());
		bean.add("123");
		
	}

}
