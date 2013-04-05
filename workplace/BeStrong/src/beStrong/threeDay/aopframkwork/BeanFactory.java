package beStrong.threeDay.aopframkwork;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import beStrong.threeDay.Advice;



public class BeanFactory  {

	
	Properties properties = new Properties();
	public BeanFactory(InputStream ips){

		try {
			properties.load(ips);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object getBean(String name)throws Exception{
		String className = properties.getProperty(name);
		Class clazz = Class.forName(className); 
		Object bean =clazz.newInstance();
		if(bean instanceof ProxyFactoryBean){
			
			Object proxy = null;
			ProxyFactoryBean proxyFactoryBean =(ProxyFactoryBean) bean;
			Advice advice = (Advice)Class.forName(properties.getProperty(name+".advice")).newInstance();
			Object target = Class.forName(properties.getProperty(name+".target")).newInstance();
		    proxyFactoryBean.setAdvice(advice);
		    proxyFactoryBean.setTagert(target);
		    proxy = proxyFactoryBean.getProxy();
			return proxy;
		}
		return bean;
		
		
	}
}
