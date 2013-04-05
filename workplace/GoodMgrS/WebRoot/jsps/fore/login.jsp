<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录 － 电子商务网</title>    
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
		     width: 960px;
		     text-align:center;
		     border:1px solid red;
		     backgroun-image:url(<c:url value="/pic/"/>);
		  }
		  
		  #form{
		      background-color:white;
		      font-size:20px;
		      float:right;
		      border:2px solid gray;
		      height:360px;
		      width:320px;
		      margin-right:50px;
		  
		  }
		    #form_1{
		       padding:20px 10px 20px 10px;
		       border-bottom:1px dotted black;
		    }
		    #form_2{
		       margin:20x 10px 20px 10px;
		    }
		    
		    #form_2 div{
		       border:1px solid red;
		       margin:15px;
		    }
		    
		     #form_2 span{
		        font-size:18px;
		        margin:0px;
		        border:1px solid red;
		        width:90px;
		        text-align:right;
		     }
		     #form_2 input{
		        width:160px;
		     }
		     #form_2 span input{
		        width:80px;
		        margin:0px;
		     }
		     
		    
		    #form_3{
		       padding:20px 10px 20px 10px;
		       border-top:1px dotted black;
		    }
		    
		    
		  
    </style>
    
  </head>
  
  <body>
     <div style="height:60px;"></div>
     <div id="allcontent">
     	  
          <div id="form">
                 <div id="form_1">
                    <span>请登入</span>
                 </div>
          
                 <form  id="form_2" action="<c:url value="/fsecuritymgr?act=login"/>" method="post">
					<div>
						 <span>电子邮箱:</span>
						 <input type="text" name="useremail" value="${param.useremail}">
					 </div>
					 <div>
						 <span>密码:</span>
						 <input type="password" name="userpwd">
					 </div>
					 <div align="right">
					    <span><input type="submit" value=" 登 入 "></span>
					 </div>
			    </form>
			    <div id="form_3">
			       <span><a href="<c:url value="/fsecurity?act=toreg"/>">快速注册</a></span>
			    </div>
			    
   		 </div>
    
         <div>
		    <c:if test="${not empty error}">
			    <script type="text/javascript">
			       alert('${error}');
			    </script>
		    </c:if>
	     </div>    
    <div>
		<%@ include file="/jsps/fore/footer.jsp" %>
	</div>
    
  </body>
</html>
