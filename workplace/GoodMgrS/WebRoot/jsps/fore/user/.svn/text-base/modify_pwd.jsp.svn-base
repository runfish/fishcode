<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>

		<script type="text/javascript">
		
		function $(id){
        	return document.getElementById(id);
        };
        function $F(id){
	        var o=$(id);
	        return o.value;
        };
		
		
		
	
		
		
		/*原始密码*/
		function oldcheck(){
		    var oldpwd = $F('oldpwd');
		   
		    
		    if(oldpwd=='')
		    {
		        alert('密码必填');
		         $('oldpwd').focus();
		        return false;
		    }
		    
		    if(oldpwd.length<3||oldpwd.length>15){
		        alert('密码为3-15位');
		         $('oldpwd').select();
		        return false;    
		    }
		        
		   if(${logineduser.user_pwd}==oldpwd){
		         alert('原始密码有误');
		          $('oldpwd').select();
		         return false;    
		    }
	    
		    return true;
		    
		}
		
		/*新密码*/
		
		function newcheck(){
		    var newpwd = $F('newpwd');
		    
		    if(newpwd=='')
		    {
		        alert('密码必填');
		         $('newpwd').focus();
		        return false;
		    }
		    
		    if(newpwd.length<3||newpwd.length>15){
		        alert('密码为3-15位');
		         $('newpwd').select();
		        return false;      
		    }
		        
		    	    
		    return true;
		    
		}
		/*确认密码*/
		
	   function recheck(){
		    var repwd = $F('repwd');
		   
		    if(repwd=='')
		    {
		      alert('请确认密码');
		         $('repwd').focus();
		        return false;
		    }
		    
		    if(repwd!=$F('newpwd'))
		    {
		        alert('两次密码不同，请重新输入');
		         $('repwd').select();
		        return false;
		    }
		    return true;
		}
		
		function allcheck(){
		   if(oldcheck && newcheck && recheck){
		   document.forms[0].submit();
		   
		   }
		}
		
		
		</script>
		
		
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
  			<form  action="<c:url value="/fusermgr?act=modyfipwd&newpwd=newpwd"/>" >
  			  <div><span>原始密码：</span><span><input type="text" name="oldpwd" id="oldpwd"/></span></div>
  			  <div><span>新密码：</span><span><input type="text" name="newpwd" id="newpwd"/></span></div>
  			  <div><span>确认密码：</span><span><input type="text" name="repwd" id="repwd"/></span></div>
  			  <div><input type="button" value=" 提 交 " onclick="allcheck();"></div>
  			</form>
  		</div>
  </body>
</html>
