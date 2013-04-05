<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/js/prototype.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	     function reloadVerifycode(){
	       var timenow =new Date().getTime();
	       $('checkcode').src="<%=request.getContextPath()%>/checkcode?act=generate&d="+timenow;
	     }
	
	</script>
	
  </head>
  
  <body>
    <image id="checkcode" src="checkcode?act=generate"/><br/>
     <a href="javascript:reloadVerifyCode();">换一张</a>
    <br/>
    输入验证码: <input type="text" id="cc"/><button onclick="checkCode();">检测</button><span id="checkResult"></span>
    
  </body>
</html>
