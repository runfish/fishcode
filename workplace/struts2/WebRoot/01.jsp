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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   =======================属性驱动方式======================== 
  <pre>
   1；GET请求
    <a href="<%=path%>/actionValue_1?classid=1&classname=小鱼">GET请求</a>
  
  2：post请求
  <form method="post" action="<%=path%>/actionValue_1">
     用户ID<input type="text" name="classid">
    
     用户名称<input type="text" name="classname">
     
     <input type="submit" value="提交数据"> 
  
  </form>
  

  
    1；GET请求
    <a href="<%=path%>/actionValue_2?classBean.classid=1&classBean.classname=小鱼">GET请求</a>
  
  2：post请求
  <form method="post" action="<%=path%>/actionValue_2">
     用户ID<input type="text" name="classBean.classid">
    
     用户名称<input type="text" name="classBean.classname">
     
     <input type="submit" value="提交数据"> 
  
  </form>
  </pre>
  
  =================================模型驱动方式提交===================
  
    <pre>
   1；GET请求
    <a href="<%=path%>/actionValue_3?classid=1&classname=小鱼">GET请求</a>
  
  2：post请求
  <form method="post" action="<%=path%>/actionValue_3">
     用户ID<input type="text" name="classid">
    
     用户名称<input type="text" name="classname">
     
     <input type="submit" value="提交数据"> 
  
  </form>
  </pre>
 
  </body>
</html>
