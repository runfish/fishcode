<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<form action="<%=path%>/userAction!save" method="post">
			<div>
				<span>用户ID</span>
				<input type="text" name="user.userid" value="${user.userid}" />
			</div>
			<div>
				<span>用户姓名</span>
				<input type="text" name="user.username" value="${user.username}" />
			</div>
			<div>
				<span>用户真实姓名</span>
				<input type="text" name="user.userrealname"
					value="${user.userrealname}" />
			</div>
			<div>
				<span>用户密码</span>
				<input type="text" name="user.password" value="${user.password}">
			</div>
			<div>
				<span>用户性别</span>
				<select name="user.usersex">
					<option value="男" <c:if test="${user.usersex=='男'}">selected</c:if>>
						男
					</option>
					<option value="女" <c:if test="${user.usersex=='女'}">selected</c:if>>
						女
					</option>
				</select>
			</div>

			<div>
				<span>用户电话</span>
				<input type="text" name="user.tel" value="${user.tel}">
			</div>

			<div>
				<span>用户手机</span>
				<input type="text" name="user.phone" value="${user.phone }">
			</div>

			<div>
				<span>用户邮箱</span>
				<input type="text" name="user.mail" value="${user.mail }">
			</div>
			<div>
				<span>用户籍贯</span>
				<input type="text" name="user.origin" value="${user.origin }">

			</div>
			<div>
				<span>用户身份证号码</span>
				<input type="text" name="user.idcard" value="${user.idcard }">

			</div>
			<div>

				<span>用户地址</span>
				<input type="text" name="user.address" value="${ user.address}">
			</div>

			<div>
				<span>是否婚否</span>
				<select name="user.marry">
					<option value="0" <c:if test="${user.marry==0}">select</c:if>>
						否
					</option>
					<option value="1" <c:if test="${user.marry==1}">select</c:if>>
						是
					</option>

				</select>
			</div>

			<div>
				<input type="submit" value="提交数据">
			</div>
		</form>


	</body>
</html>
