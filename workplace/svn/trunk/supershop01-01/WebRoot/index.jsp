<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>农大网上商城-综合网购首选，正品行货，机打发票，售后上门取件，省钱又放心 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>">
	<script type="text/javascript" src="<c:url value="/js/boxOver.js"/>"></script>
	
</head>
  <body>

  <div class="main_container">
     <div class="header">
         <div class="login"></div>
         <div class="logo"></div>
     </div>
     
     <div class="main_content">
         <div class="menu_tab"></div> 
         
         <div class="left_content">
            <div class="natigation"></div>
         </div>
         
         <div class="center_content">
            <iframe id="contentFrame" width="100%" scrolling="auto" height="480px" frameborder="0" name="contentFrame" allowtransparency="true" src="<c:url value="/welcome.jsp"/>">              
            </iframe>
         </div>
     
     </div>
      
     <div class="footer"></div>
  
  
  </div>
   <jsp:forward page="/jsps/deals/consignee_info.jsp"></jsp:forward>
</body>
</html>