package com.diqye;

import com.diqye.controllers.Index;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.kit.JsonKit;

public class LoginCheck implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		if(ai.getController() instanceof Index){
			System.out.println("index");
			ai.invoke();
			return;
		}
		
		Object o = ai.getController().getSessionAttr("user");
		if(o == null){
			ai.getController().render("/index.html");
			return;
		}
		
		System.out.println(JsonKit.toJson(o));
		ai.invoke();
	}

}
