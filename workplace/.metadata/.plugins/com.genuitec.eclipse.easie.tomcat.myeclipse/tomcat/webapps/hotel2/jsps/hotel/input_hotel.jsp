<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分店信息录入</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	
	<script type="text/javascript">
	   
	    function previewPic(picUrl){
           picUrl.select();
           var realpath = document.selection.createRange().text;
           alert(realpath);
           alert($('hotelview').src);
           $('hotelview').src=realpath;
	    }
	
	</script>
	
  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">开设分店</div>
	    <form action="<c:url value="/action/hotelMgr"/>" method="post"  enctype="multipart/form-data">
	        <input type="hidden" name="act" value="create"/>
	        <div class="f_row">
	          <span>分店名称:</span>
	          <input type="text" name="hotelname" size="20" value="${param.hotelname}"/>
	        </div>
	        <div class="f_row">
	          <span>分店地址:</span>
	          <input type="text" name="hoteladdr"  size="50" value="${param.hoteladdr}"/>        
	        </div>
	        <div class="f_row">
	          <span style="margin-left:55px;">
	          <image id="hotelview" width="200px" height="160px" src="<c:url value="/pics/default_hotel_pic.jpg"/>"/></span><br/>
	          <span>分店图片:</span>
	          <input type="file" id="hotelpic" name="hotelpic" size="80" onchange="previewPic(this);"/>
	        </div>
	        <div class="f_row">
	          <span>联络电话:</span>
	          <input type="text" name="hotelphone" size="50" value="${param.hotelphone}"/>          
	        </div> 
	        <div class="f_row">
	          <input type="submit" value="保存信息"/>      
	        </div>                        
	    </form>
    </div>
    <c:if test="${not empty err}">
       <script type="text/javascript">
         alert('${err}');
         document.forms[0].hotelname.select();
       </script>
    </c:if>
  </body>
</html>
