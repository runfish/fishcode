<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css"  href="<c:url value="/css/application.css"/>">
     <link rel="stylesheet" type="text/css"  href="<c:url value="/css/head.css"/>">

     	
		<script type="text/javascript">
       function register()
		{
		   
		   location.href="<c:url value="/fsecurity?act=toreg"/>";
		}
		
		function logout()
		{
		   if(confirm("确实离开，下次再继续购物吗?"))
		       location.href="<c:url value="/fsecurity?act=logout"/>";
		}		
		
		function login()
		{
		   var oldAddr=location.href;
		   location.href="<c:url value="/fsecurity?act=tologin&preurl="/>"+oldAddr.replace('&','!');
		}

      
		</script>
	
	<style type="text/css">
		       body{
			     background-color:#769b72;
			     width: 960px;
			     text-align:center;
			     
			  }
			  #allcontent{
			     width: 960px;
			     text-align:center;
			     border:1px solid red;
			     
			  }
		      
		      #allcontent div{
		         float:left;
		      
		      }
		 
		</style>
	
  </head>
  
  <body>
     <%@ include file="/jsps/fore/head.jsp"%>
	   <div id="allcontent">
	    	<div><!-- 左边导航 -->
	    	     <ul>
	    	        <li><a href="<c:url value="/fusermgr?act=showuser"/>" target="contentFrame">基本资料</a></li>
	    	        <li><a href="<c:url value="/fusermgr?act=formodyfiuser"/>" target="contentFrame">资料修改</a></li>
	    	        <li><a href="<c:url value="/fusermgr?act=formodyfipwd"/>" target="contentFrame">密码修改</a></li>
	    	        <li><a href="<c:url value="/fordermgr?act=list"/>" target="contentFrame">订单信息</a></li>
	    	     </ul>
	    	</div>
	        <div id="content">
				<iframe id="contentFrame" width="100%" scrolling="no" height="480px"
					frameborder="0" name="contentFrame" allowtransparency="true"
					src="<c:url value="/fusermgr?act=showuser"/>">
				</iframe>
			</div>
	    </div>
  </body>
</html>
