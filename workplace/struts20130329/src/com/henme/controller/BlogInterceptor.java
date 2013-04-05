package com.henme.controller;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * BlogInterceptor
 */
public class BlogInterceptor implements Interceptor {
	
	public void intercept(ActionInvocation ai) {
		System.out.println("Before invoking evilpaw" + ai.getActionKey());
	
		ai.invoke();
		System.out.println("After invoking " + ai.getActionKey());
	}
}
