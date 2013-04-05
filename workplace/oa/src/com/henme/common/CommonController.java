package com.henme.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.henme.filter.PropertyInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.render.CaptchaRender;

/**
 * CommonController
 */
public class CommonController extends Controller {
	
	

	private static final String RANDOM_CODE_KEY = "1";

	public void index() {
		renderFreeMarker("/index.html");
	}
	
	public void main() {
		renderFreeMarker("/main.html");
	}
	
	public void login(){
		System.out.println("登录了");	
	    Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(this.getPara("username"),this.getPara("password").toCharArray());
            token.setRememberMe(false);
            currentUser.login(token);
        }
        redirect("index");
	}
	

	@Before({ PropertyInterceptor.class })
	public void login1() {
		String inputRandomCode = getPara("inputRandomCode");
//		boolean loginSuccess = CaptchaRender.validate(this, inputRandomCode, RANDOM_CODE_KEY);
//		if (loginSuccess) {
//			render("/common/index.jsp");
//		}else{
//			index();
//		}
		render("/common/index.html");
		
	}

	public void img() {
		CaptchaRender img = new CaptchaRender(RANDOM_CODE_KEY);
		render(img);

	}
	
	
}
