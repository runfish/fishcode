package com.diqye.error.process;

import com.diqye.error.XmglException;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.util.Ext;

public class ErrorInter implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		try{
			ai.invoke();
		}catch (XmglException e) {
			e.printStackTrace();
			ai.getController().renderJson(Ext.ok(false, e.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			ai.getController().renderJson(Ext.ok(false, "系统出错"));
		}
	}

}
