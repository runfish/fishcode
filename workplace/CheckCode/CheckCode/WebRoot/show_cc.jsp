<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_cc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/prototype.js"></script>
	<style>
	   
	   .rightCC{
	     font-size:12px;
	     color:green;
	   }
	   
	   .errCC{
	     font-size:12px;
	     color:red;
	   }
	   
	</style>
	
	<script type="text/javascript">
	
    function reloadVerifyCode(){  
  
           var timenow = new Date().getTime();                          
  
           document.getElementById("checkcode").src="<%=request.getContextPath()%>/genCC?act=generate&d="+timenow;  
  
    }  
    
    function checkCode(){
        //http://localhost:8080/code/genCC?act=checkCode&cc=3h3t
        new Ajax.Request(
            encodeURI("genCC?act=checkCode&seed="+Math.random()+"&cc="+$('cc').value),
            {
              method:'get',
              onComplete:function(xhr){
                 var result=xhr.responseText;
                 //alert(result);
                 if(result=='ok'){
                   $('checkResult').innerText='验证码正确!';
                   $('checkResult').className='rightCC';
                 }
                 else
                 {
                   $('checkResult').innerText='验证码错误!';
                   $('checkResult').className='errCC';                 
                 }
              }
            }
        );
        
    }
	
	
	</script>

  </head>
  
  <body> 
    This is my JSP page. <br>
    
    <image id="checkcode" src="genCC?act=generate&"><br/>
    <a href="javascript:reloadVerifyCode();">换一张</a>
    <br/>
    输入验证码: <input type="text" id="cc"/><button onclick="checkCode();">检测</button><span id="checkResult"></span>
    
  </body>
</html>
