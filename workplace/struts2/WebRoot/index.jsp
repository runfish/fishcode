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
  <pre>
<a href="<%=path%>/action_one">1: action 的类型  普通的java类型</a>

<a href="<%=path%>/action_two">2: action 的类型  普通的java类型</a>

<a href="<%=path%>/action_three">3: action 的类型  普通的java类型</a>

方法的分的操作
1：使用method的
<a href="<%=path%>/action_method_save">调用save方法</a>

<a href="<%=path%>/action_method_list">调用list方法</a>

<a href="<%=path%>/action_method_update">调用update方法</a>

<a href="<%=path%>/action_method_delete">调用delete方法</a>



		
2： 使用动态方法调用
<!-- 	<constant name="struts.enable.DynamicMethodInvocation"
		value="true" />  必须开启 -->
<a href="<%=path%>/action_method2!save">调用save方法</a>

<a href="<%=path%>/action_method2!list">调用list方法</a>

<a href="<%=path%>/action_method2!update">调用update方法</a>

<a href="<%=path%>/action_method2!delete">调用delete方法</a>



3：使用通配符的调用
<a href="<%=path%>/action_method3_save">调用save方法</a>

<a href="<%=path%>/action_method3_list">调用list方法</a>

<a href="<%=path%>/action_method3_update">调用update方法</a>

<a href="<%=path%>/action_method3_delete">调用delete方法</a>


struts 如何接收页面传递的值


<a href="01.jsp">1：属性方式设值</a>

Struts 如何获取servlet原生对象


<a href="<%=path%>/actionServlet">1： 使用ServletActionContext对象</a>

<a href="<%=path%>/actionServlet_2">2：使用实现接口拦截器对象</a>

Struts  操作作用域

<a href="<%=path%>/scope_1">1：使用servlet原生對象操作作用域</a>


<a href="<%=path%>/scope_2">2：使用struts 封装的对象操作作用域</a>


</pre>
  </body>
</html>
