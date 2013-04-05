<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>





<div style="width:960px;text-align:center;border:1px solid red;">
     
	  <div style="float:left;border:1px solid blue;">
	        <c:if test="${not empty logineduser}">
	           <span>
	              您好，${logineduser.user_name }
	              <span onclick="logout();" class="linkspan">退出系统</span>
	           </span>        
	        </c:if>
	        <c:if test="${empty logineduser}">
	            <span onclick="register();" class="linkspan">注册新用户</span>
	            <span onclick="login();" class="linkspan">登入系统</span>
	        </c:if>
	     </div>
	     <div style="float:right;border:1px solid blue;">
	        <a href="<c:url value="/fshoppingcartmgr?act=listcart"/>">购物车</a>
	        <a href="<c:url value="/fusermgr?act=showuser"/>">会员中心</a>
	        <a href="<c:url value="#"/>">后台登入</a>
	     </div>
        <div style="width:100%;"></div>
	     
   
     <div style="border:1px solid red;float:left;width:100%">
		    <div style="backgrouond-image:url(<c:url value="/pic/titanic.jpg"/>);">
		    	<div style="text-align:right;"><a>返回主页</a></div>
		    </div>
			
						
			<div style="border:1px solid red;width:100%">
					<img src="<c:url value="/pic/head-servicejif"/>">
			</div>
	  </div>
 </div>

