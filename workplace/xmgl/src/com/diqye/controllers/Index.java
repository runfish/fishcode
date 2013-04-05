package com.diqye.controllers;

import org.apache.log4j.Logger;


import com.diqye.moudels.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class Index extends Controller {
	Logger log = Logger.getLogger(getClass());
	//登陆页面
	public void index(){
		render("/index.html");
	}
	
	//登陆操作
	public void login(){
		if(!(User.checkLoginName(getPara("username")))){
			setAttr("ok", false);
			setAttr("msg", "用户名不存在");
			renderJson();
			return;
		}
		
		User u = User.Login(getPara("username"),getPara("password"));
		if(u == null){
			setAttr("ok", false);
			setAttr("msg", "密码不存在");
			renderJson();
			return;
		}
		
		log.debug("用户登陆成功:" + u.toJson());
		setSessionAttr("user", u);
		setAttr("ok", true);
		renderJson();
	}
	
	
	//导航
	public void navigation(){
		Object o = getSessionAttr("user");
		if(o == null){
			render("/index.html");
			return;
		}
		render("/pages/navigation.html");
	}
	
	public void welcome(){
		render("/pages/welcome.html");
	}
}
