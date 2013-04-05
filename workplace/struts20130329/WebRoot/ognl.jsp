<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<s:debug></s:debug>

		<pre>
		
		1:访问action中的属性
		
		name=<s:property value="name"/><a>
	  age=<s:property value="age"/><a>
		dog=<s:property value="dog"/><a>
		
		2:调成员方法
		
		add方法：<s:property value="add()"/>
		set方法：<s:property value="setName('xiaoyuer')"/>
		name<s:property value="name"/>
		
		3: 调静态方法
		
	静态变量  <s:property value="@net.dfrz.test.Global@Global_pagesize"/>
	静态方法=  <s:property value="@net.dfrz.test.Global@getSysTime('yyyy年-MM月-dd日')"/>
		
		4：访问请求中的数据
		
		<s:property value="#parameters.name"/>
		<s:property value="#parameters.age"/>
		<s:property value="#parameters['dog.name']"/><!-- 这里需要当成一个字符串来处理 ，不能当成一个对象处理-->
		<s:property value="#parameters['dog.age']"/>
		
		
		5：访问集合里面的数据
		
		strlist=<s:property value="strList"/>
		strListSize = <s:property value="strList.size()"/>
		strListadd = <s:property value="strList.add('小鱼')"/>
		strLis = <s:property value="strList"/>
		getValue = <s:property value="strList.get(1)"/>
		dogList = <s:property value="dogList"/>
		dogList[2] = <s:property value="dogList.get(1).name"/>
		map = <s:property value="map"/>
		
		输出第一天个key
		<s:property value="map.get('key_1')"/>
		<s:property value="map.key_1"/>
		<s:property value="map['key_1']"/>
		
		
		
		
		
		
 
 </pre>

	</body>
</html>
