package com.henme.plugin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.Factory;

import com.jfinal.plugin.IPlugin;

public class ShiroPlugin implements IPlugin{

	public boolean start() {
		//IniShiroFilter i=new IniShiroFilter();	
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");  
		SecurityManager securityManager = factory.getInstance(); 	
		SecurityUtils.setSecurityManager(securityManager);
		return true;
//		i.setServletContext(servletContext);
//		try {
//			i.init();
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
	}

	public boolean stop() {
		return true;
	}
}
