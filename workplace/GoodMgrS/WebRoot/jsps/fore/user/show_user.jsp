<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c">

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户基本资料显示</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" type="text/css"  href="<c:url value="/css/application.css"/>">
  
	<style type="text/css">
		       
			  #content{
			     text-align:center;
			     border:1px solid red;
			     float:left;
			  }
			  #blank{
			     float:left;
			     width:230px;
			     height:300px;
			     border:1px solid red;
			  }
		      #content div{
		         float:left;
		         margin-top:20px;
		         width:600px;;
		         border:1px solid red;
		      }
		      #content span{
		         width:150px;
		         float:left;
		         border:1px solid red;
		         text-align:right;
		      }
		     
		</style>
  </head>
  
  <body>
        <div id="blank">
        </div>
	    <div id="content">
	        	   <div><span class="usercontent">用户名：</span><span>${logineduser.user_name }</span></div>
	        	   <div><span class="usercontent">用户性别：</span><span>${logineduser.user_sex }</span></div>
	        	   <div><span class="usercontent">用户生日：</span><span>${logineduser.user_date }</span></div>
	        	   <div><span class="usercontent">用户email：</span><span>${logineduser.user_email }</span></div>
	        	   <div><span class="usercontent">用户电话号码：</span><span>${logineduser.user_phone }</span></div>
	        	   <div><span class="usercontent">用户地址：</span><span>${logineduser.user_addr }</span></div>
	        	   <div><span class="usercontent">用户邮编：</span><span>${logineduser.user_postcode }</span></div>
	     </div>
  </body>
</html>
