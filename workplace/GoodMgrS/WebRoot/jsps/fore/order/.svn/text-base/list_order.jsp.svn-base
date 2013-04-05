<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订单信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		      <span>订单信息列表</span>  
		      <form action="<c:url value="/fordermgr?act=list"/>" method="post">
		         <div>
		            <span>订单时间</span>
		            <input type="text" name="qrydate" value="${param.qrydate }">
		         
		            <span>订单状态</span>
		            <select name="qrystatus">
		              <option value="a" <c:if test="${param.qrystatus=='a'}">selected</c:if>>未审核</option>
		              <option value="b" <c:if test="${param.qrystatus=='b'}">selected</c:if>>审核未通过</option>
		              <option value="c" <c:if test="${param.qrystatus=='c'}">selected</c:if>>审核已通过</option>
		            </select>
		         
		         <input type="submit" value=" 查 询 ">
		      </form>  
		    </div>
		    <div>
		      <table>
		        <tr><th>订单号</th><th>收货人</th><th>付款方式</th><th>订单总金额</th><th>订单状态</th><th>下单时间</th><th>操作</th></tr>
		      	<c:forEach var="order" items="${page.pageContent}">
		      		<tr>
		      		  <td>${order.order_id }</td>
		      		  <td>${order.receive_name }</td>
		      		  <td>${order.pay_mode }</td>
		      		  <td>${order.order_account }</td>
		      		  <td>${order.receive_status }</td>
		      		  <td>${order.order_time }</td>
		      		  <td><a href="<c:url value="/forderitemmgr?act=list&orderid=${order.order_id  }"/>">详细信息</a></td>
		      		</tr>      	
		      	</c:forEach>
		      </table>
		    </div>
		   </div> 
		    <div>
			   <%@ include file="/jsps/fore/footer.jsp" %>
			</div>
  </body>
</html>
