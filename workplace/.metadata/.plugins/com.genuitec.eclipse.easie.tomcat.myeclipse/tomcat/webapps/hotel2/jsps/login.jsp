<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"></c:url>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"></c:url>">
    
    <style>
      .error{
        border:1px solid yellow;
        color:red;
        width:230px;
        padding:8px;
        margin:5px;
      }  
    </style>
    
    <script type="text/javascript">
    
       function validateEntry(loginFrm){
         
           with(loginFrm){
             
              if(userno.value==""){
                 alert("用户编号必须填写!");
                 userno.select();
                 return false;
              }
              
              if(userno.value.length!=6){
                 alert("用户编号必须是6位!");
                 userno.select();
                 return false;
              }
              
              if(isNaN(userno.value)){
                 alert("用户编号必须是6位数字!");
                 userno.select();
                 return false;
              }              
              
              if(userpwd.value==""){
                alert("登陆密码必须填写!");
                userpwd.select();
                return false;
              }
               
           }
           
           return true;
         
       }
    
    </script>
    
  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">用户登录</div>
	    <form action="<c:url value="/action/securityMgr?act=login"/>" method="post" onSubmit="return validateEntry(this);">
	        <div class="f_row">
	          <span>用户编号:</span>
	          <input type="text" name="userno" value="${param.userno==null?'001001':param.userno}"/>
	        </div>
	        <div class="f_row">
	          <span>登录密码:</span>
	          <input type="password" name="userpwd" value="123456"/>        
	        </div>
	        <c:if test="${not empty error}">
		        <div class="error">
		            ${error}
		        </div>
	        </c:if>
	        <div class="f_row">
	          <input type="submit" value=" 登 录 "/>      
	        </div>                        
	    </form>
    </div>
    <%@ include file="/jsps/common/footer.jsp"%>
  </body>
</html>