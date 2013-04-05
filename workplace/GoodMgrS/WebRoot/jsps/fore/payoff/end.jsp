<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>电子商务  - 订单提交成功 -</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/shop_main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/head.css"/>">
  
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<style type="text/css">
		  body{
		     background-color:#769b72;
		     width: 960px;
		     text-align:center;
		     
		  }
		  #allcontent{
		     background-color:#ffffff;
		     width: 960px;
		     text-align:center;
		     border:1px solid red;
		     height:300px;
		  }
		  #allcontent div{
		    width:100%;
		    height:130px;
		    border:1px solid blue;
		  }
		  #allcontent span{
		    
		    border:1px solid blue;
		    
		    text-align:center;
		  }

   </style>
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
</head>
<body>
     <%@ include file="/jsps/fore/head.jsp" %>
     <div id="allcontent">
		<div></div>
		
	       <span>
						<a href="<c:url value="/"/>">继续逛逛</a> 
						或者 
						<a href="<c:url value="/jsps/fore/user/user_main.jsp"/>">返回我的xx</a>
	       </span>
     </div>
    <div>
		<%@ include file="/jsps/fore/footer.jsp" %>
	</div>		
</body>
</html>

