<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>订单明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
		     height:800px;
		  }
		  table td{
		     border-bottom:1px dotted gray;
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
   	  <div>
   	    <span>订单明细</span> 
   	  </div>
   	  <div>
   	    <table>
   	       <tr><th>订单编号</th><th>明细编号</th><th>商品名称</th><th>商品单价</th><th>商品数量</th></tr>
   	       <c:forEach var="orderitem" items="${order}">
   	         <tr>
   	           <td>${order.order_id }</td> 
   	           <td>${orderitem.item_id }</td> 
   	           <td>${orderitem.goods.goods_name }</td> 
   	           <td>${orderitem.goods.goods_price }</td> 
   	           <td>${orderitem.item_amount }</td> 
   	         </tr>
   	       </c:forEach>
   	    </table>
   	    <div style="float:right;"><span class="linkspan" onclick="history.go(-1);">返回</span></div>
   	  </div>
   	 </div>
   	 <div>
		<%@ include file="/jsps/fore/footer.jsp" %>
	</div>
  </body>
</html>
