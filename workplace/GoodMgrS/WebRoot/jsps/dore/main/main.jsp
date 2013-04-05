
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理工作平台</title>
	</head>
	<frameset rows="127,*,11" frameborder="no" border="0" framespacing="0">
		<frame src="jsps/dore/main/main_top.jsp" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" />
		<frame src="jsps/dore/main/main_center.jsp" name="mainFrame" id="mainFrame" />
		<frame src="jsps/dore/main/main_down.jsp" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" />
	 </frameset>
	 <noframes>
		<body>
		</body>
	</noframes>
</html>
