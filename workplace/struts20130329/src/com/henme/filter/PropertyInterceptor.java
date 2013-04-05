package com.henme.filter;

import java.util.Enumeration;

import com.jfinal.aop.PrototypeInterceptor;
import com.jfinal.core.ActionInvocation;

public class PropertyInterceptor extends PrototypeInterceptor {

	
	@Override
	public void doIntercept(ActionInvocation ai) {
		System.out.println(ai.getController());

		Enumeration<String> ss=ai.getController().getAttrNames();
		//ai.getController().getAttrNames();
		
		while(ss.hasMoreElements()){
			System.out.println("键："+ss.nextElement()+"值:"+ai.getController().getPara(ss.nextElement()));
		}
		ai.invoke();
	}

}
