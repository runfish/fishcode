<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>订单信息填写</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>

  </head>
  
  <body style="text-align:center">
  <form action="#" method="post">
   <div style="background:green;width:1000px;border:2px solid black;">
    <div style="color:white;font-size:20;text-align:left;border-bottom:1px solid black;">
      填写提交订单
    </div>
    <form action="<c:url value="dealMgr?act=add"/>" method="post">
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
      填写收货地址（温馨提示：请您认真详细填写收货姓名和地址，否则，您不能按时收到货！）
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     收货人名：
    <input type="text" name="consignee_name" value="${param.consigneeName}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     收货地址：
    <input type="text" name="address" value="${param.address}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     邮政编码：
    <input type="text" name="post_code" value="${param.postCode}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     联系方式：
    <input type="text" name="tel" value="${param.tel}">
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     电子邮箱：
    <input type="text" name="email" value="${param.email}">
    </div>
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
        付款、发货
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
        付款方式：
    <select name="pay_pattern">
     <option value="a" <c:if test="${param.payPattern=='a'}">selected</c:if>>==请选择==</option>
     <option value="b" <c:if test="${param.payPattern=='b'}">selected</c:if>>货到付款</option>
     <option value="c" <c:if test="${param.payPattern=='c'}">selected</c:if>>网银支付</option>
    </select>
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
     发货方式：
    <select name="receive_pattern">
     <option value="a" <c:if test="${param.payPattern=='a'}">selected</c:if>>==请选择==</option>
     <option value="b" <c:if test="${param.payPattern=='b'}">selected</c:if>>平邮</option>
     <option value="c" <c:if test="${param.payPattern=='c'}">selected</c:if>>快递</option>
     <option value="d" <c:if test="${param.payPattern=='d'}">selected</c:if>>ESM</option>
    </select>
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
       ※发货/运费<br>
    运输：由铁路、公路、航空运输(液体制剂不能走航空),直接发货给买家，买家如在一定时间内收不到货，请速与平台再联系。<br>
    时间：（如果选择网上支付）确认到款一天,备货一天，发货3-5天，1000公里以上要加2-3天<br>
    运费：全国免运费
    </div>
    <div style="background:#98FB98;color:green;text-align:left;border-bottom:1px solid black;">
    商品清单
    </div>
    <div style="background:#F0E68C;text-align:left;border-bottom:1px solid black;">
    <table id="listtable" cellpadding="0" cellspacing="0" style="margin-top:0px;">
     <tr>
      <th>编号</th>
      <th>名称</th>
      <th>类型</th>
      <th>价格</th>
      <th>数量</th>
      <th>小计</th>
    </tr>
    <tr>
      <c:forEach var="cartItem" varStatus="status" items="${cart.cartList}">
       <td>${status.count}</td>
       <c:forEach var="goods" items="${goodslist}">
         <td><c:if test="${cartItem.goodsId==goods.goodsId}">${goods.goodsName}</c:if></td>
       </c:forEach>
       <c:forEach var="smallCtg" items="${ctglist}">
         <td><c:if test="${cartItem.goodsCtgId==smallCtg.smallCtgId}">${smallCtg.smallCtgName}</c:if></td>
       </c:forEach>
       <td>${cartItem.goodsPrice}</td>
       <td>${cartItem.goodsQty}</td>
       <td>${cartItem.goodsPrice*cartItem.goodsQty}</td>
      </c:forEach>
    </tr>
    </table>
    </div>
    <div><input type="submit" value="确认我的订单信息"></div>
   </div>  
  </form>
  </body>
</html>
