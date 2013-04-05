<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/chili-1.7.pack.js"></script>
		<script type="text/javascript" src="js/jquery.easing.js"></script>
		<script type="text/javascript" src="js/jquery.dimensions.js"></script>
		<script type="text/javascript" src="js/jquery.accordion.js"></script>
		<script language="javascript">
	jQuery().ready(function(){
		jQuery('#navigation').accordion({
			header: '.head',
			navigation1: true, 
			event: 'click',
			fillSpace: true,
			animated: 'bounceslide'
		});
	});
</script>
		<style type="text/css">
<!--
body {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
}

#navigation {
	margin: 0px;
	padding: 0px;
	width: 147px;
}

#navigation a.head {
	cursor: pointer;
	background: url(pic/main_34.gif) no-repeat scroll;
	display: block;
	font-weight: bold;
	margin: 0px;
	padding: 5px 0 5px;
	text-align: center;
	font-size: 12px;
	text-decoration: none;
}

#navigation ul {
	border-width: 0px;
	margin: 0px;
	padding: 0px;
	text-indent: 0px;
}

#navigation li {
	list-style: none;
	display: inline;
}

#navigation li li a {
	display: block;
	font-size: 12px;
	text-decoration: none;
	text-align: center;
	padding: 3px;
}

#navigation li li a:hover {
	background: url(pic/tab_bg.gif) repeat-x;
	border: solid 1px #adb9c2;
}
-->
</style>
	</head>
	<body>
		<div style="height: 100%;">
			<ul id="navigation">
				<li>
					<a class="head">个人资料</a>
					<ul>
						<li>
							<a href=<c:url value="/goodsmgr?act=updateuser"/> target="rightFrame">修改个人资料</a>
						</li>
						<li>
							<a href=<c:url value="/goodsmgr?act=updatepwd"/> target="rightFrame">修改个人密码</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="head">管理员管理</a>
					<ul>
						<li>
							<a  href="<c:url value="/goodsmgr?act=addadmine" />" target="rightFrame">添加管理员</a>
						</li>
						<li>
							<a  href=<c:url value="/goodsmgr?act=listadmine"/> target="rightFrame">查看/修改/删除管理员</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="head">用户管理</a>
					<ul>
						<li>
							<a href=<c:url value="/goodsmgr?act=adduser"/> target="rightFrame">注册用户管理</a>
						</li>
						<li>
							<a href=<c:url value="/goodsmgr?act=frozenuser"/> target="rightFrame">冻结与解冻用户</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="head">商品管理</a>
					<ul>
						<li>
							<a href=<c:url value="/goodsmgr?act=categorymanage"/> target="rightFrame">商品类别管理</a>
						</li>
						<li>
							<a href=<c:url value="/goodsmgr?act=addgoods"/> target="rightFrame">添加商品</a>
						</li>
						<li>
							<a href=<c:url value="/goodsmgr?act=loadgoods"/> target="rightFrame">查看/删除/修改商品</a>
						</li>
						<li>
							<a href=<c:url value="/goodsmgr?act=goodmessage"/> target="rightFrame">商品信息管理</a>
						</li>
					</ul>
				</li>
				<li>
					<a class="head">订单管理</a>
					<ul>
						<li>
							<a href=<c:url value="/goodsmgr?act=loadorder"/> target="rightFrame">查询订单</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</body>
</html>
