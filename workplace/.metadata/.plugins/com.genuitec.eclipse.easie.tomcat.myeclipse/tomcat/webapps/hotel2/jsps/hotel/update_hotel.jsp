<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分店信息修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	
	<style>
	   #oldpic{
	     position:absolute;
	     right:30px;
	     top:40px;
	   }
	</style>

  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">分店[${hotel.hotelName}]信息修改</div>
	    <img id="oldpic" src="<c:url value="/action/hotelMgr?act=getpic"/>&hotelno=${hotel.hotelNo}"/>
	    <form action="<c:url value="/action/hotelMgr"/>" method="post"  enctype="multipart/form-data">
	        <input type="hidden" name="act" value="update"/>
	        <input type="hidden" name="hotelno" value="${hotel.hotelNo}"/>
	        <input type="hidden" name="hotelRoomCount" value="${hotel.hotelRoomCount}"/>
	        <div class="f_row">
	          <span>分店编号:</span>
	          <span>${hotel.hotelNo}</span>
	        </div>	    
	        <div class="f_row">
	          <span>分店名称:</span>
	          <input type="text" name="hotelname" size="20" value="${hotel.hotelName}"/>
	        </div>
	        <div class="f_row">
	          <span>分店图片:</span>
	          <input type="file" id="hotelpic" name="hotelpic" size="50"/>
	        </div>
	        <div class="f_row">
	          <span>分店地址:</span>
	          <input type="text" name="hoteladdr"  size="50" value="${hotel.hotelAddr}"/>        
	        </div>
	        <div class="f_row">
	          <span>联络电话:</span>
	          <input type="text" name="hotelphone" size="50" value="${hotel.hotelPhone}"/>          
	        </div> 
	        <div class="f_row">
	          <input type="submit" value="信息修改"/>      
	        </div>                        
	    </form>
    </div>
  </body>
</html>
