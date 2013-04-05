<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品类别修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" type="text/css" href=" <c:url value="/CSS/application.css"/>">
	<link rel="stylesheet" type="text/css" href=" <c:url value="/CSS/form.css"/>">

  </head>
 <body>
    <div id="wrapper">
	    <div id="f_title">商品类别[${category.ctgName}]信息修改</div>
	    <form action="<c:url value="/categoryMgr?act=update"/>" method="post">
	        <input type="hidden" name="ctgid" value="${category.ctgId}"/>
	        <div class="f_row">
	          <span>商品类别编号:</span>
	          <span>${category.ctgId}</span>
	        </div>	
	           <div class="f_row">
	          <span>新商品类别：</span>
	          <input type="text" name="ctgname" size="50" value="${category.ctgName}"/>          
	        </div>
	        <div>
	        <input type="submit" value="修改"/>
	        </div>
         </form>
    </div>
  </body>
</html>
