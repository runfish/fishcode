package com.henme.shiro;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;


public class MyShiroRealm extends AuthorizingRealm{

	   
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		System.out.println("登录：+"+token.getUsername()+" 密码:"+token.getPassword().toString());
		if(token.getUsername()==null){
			return null;
		}else{
			  return new SimpleAuthenticationInfo(token.getUsername(),token.getPassword(),token.getUsername());
		}		
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行了回调函数");
		String username = principals.asList().get(0).toString();
		if("admin".equals(username)){
			Set<String> permissions = new HashSet<String>();
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			permissions.add("blog:list");//admin 可以查看
			permissions.add("menu:list");
			info.setStringPermissions(permissions);
			return info;
		}
		return null;
	}
	
	
	
	
}