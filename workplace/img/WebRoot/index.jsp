<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>
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
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery.jqzoom.css"/>">
	<script type="text/javascript" src="<c:url value="/js/jquery-1.6.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.jqzoom-core.js"/>"></script>
	<script type="text/javascript">

		$(document).ready(function() {
			$('.jqzoom').jqzoom({
		            zoomType: 'reverse',
		            lens:true,
		            preloadImages: false,
		            alwaysOn:false
		        });
			//$('.jqzoom').jqzoom();
		});


</script>

  </head>
<body>
<div class="clearfix" id="content" style="margin-top:100px;margin-left:350px; height:500px;width:500px;" >
    <div class="clearfix">
        <a href="imgProd/triumph_big1.jpg" class="jqzoom" rel='gal1'  title="triumph" >
            <img src="imgProd/triumph_small1.jpg"  title="triumph"  style="border: 4px solid #666;">
        </a>
 </div>

</div>
</body>
</html>
