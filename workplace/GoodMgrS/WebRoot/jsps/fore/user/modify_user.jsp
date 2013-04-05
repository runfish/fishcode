<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>用户信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/register.css"/>">

		<script type="text/javascript">
      
		
		function $(id){
        	return document.getElementById(id);
        };
        function $F(id){
	        var o=$(id);
	        return o.value;
        };
        
        var msg=new Array();
		msg[0]="此邮箱将是您登录当当网的帐号、并将用来接收验证邮件。";
		msg[1]="此项为必填项，请输入您的Email地址。";
		msg[2]="Email格式错误，请重新填写。";
		msg[3]="此<span class=\"f_Arial\">Email</span>已被注册，请重新填写。";
		msg[4]="此项为必填项，请输入您的昵称。";
		msg[5]="格式错误，必须是英文字母或数字, 长度3-15。";
		msg[6]="此昵称已有人使用，请重新填写。";
		msg[7]="密码必填； 且长度3-15。";
		msg[8]="此项为必填项，请设置您的密码。";
		msg[9]="密码格式错误，请用大小写英文字母、数字，长度3-15个字符。";
		msg[10]="此项为必填项，请再次输入您的密码。";
		msg[11]="两次密码输入不一致，请重新填写。";
		msg[12]="请输入图片中的四个字母。";
		msg[13]="此项必填。";
		msg[14]="验证码输入错误，请重新填写。";
		msg[15]="必填. 且必须是英文字母或数字, 长度3-15.";
		msg[16]="不区别大小写";
		msg[17]="验证码过期，请重新填写。";
	    msg[18]="必填； 中文，2-10个字符。"
		
		
		
		
		/*设置昵称*/
		function check_nickname_focus(){
			$('nickname_ok').style.display="none";
		    $('nickNameValidMsg').className="notice_1";
		    $('nickNameValidMsg').style.display="inline";
		    $('nickNameValidMsg').innerHTML=msg[15];
		}
        
        function txtNickName_check(){
		    var nickname = $F('username');
		    $('nickNameValidMsg').style.display="inline";
		    $('nickname_ok').style.display="none";
            
            var length=nickname.length;
            
		    if(nickname=='')
		    {
		        $('nickNameValidMsg').className="notice_error";
		        $('nickNameValidMsg').innerHTML=msg[4];
		        $('txtNickName').className="input_text_error";
		        
		        return false;
		    }
		    /*alert(isNaN(nickname)==false);*/
		    if(length<3||length>15){
		        $('nickNameValidMsg').className="notice_error";
		        $('nickNameValidMsg').innerHTML=msg[5];
		        $('txtNickName').className="input_text_error";
		        
		        return false;
		    }
		    
		    for(var i=0;i<length;i++){
            	if(nickname.charCodeAt(i)<48 || (nickname.charCodeAt(i)>57 && nickname.charCodeAt(i)<65) || (nickname.charCodeAt(i)>90 && nickname.charCodeAt(i)<97) || nickname.charCodeAt(i)>122){
            	    $('nickNameValidMsg').innerHTML=msg[5];
            	    return false;
            	}           	
            }
		    
		    
		    
		    
		    $('nickNameValidMsg').style.display="none";    
		    $('nickNameValidMsg').innerHTML='';
		    $('nickname_ok').style.display="inline";
   
		    return true;
		}
		
		/*设置密码*/
		function check_password_focus(){
		    $('password_ok').style.display="none";
		    $('passwordValidMsg').className="notice_1";
		    $('passwordValidMsg').style.display="inline";
		    $('passwordValidMsg').innerHTML=msg[7];
		
		}
		function txtPassword_check(){
		    var password = $F('userpwd');
		    $('passwordValidMsg').style.display="inline";
		    $('passwordValidMsg').innerHTML=msg[7];
		    $('password_ok').style.display="none";
		    
		    if(password=='')
		    {
		        $('passwordValidMsg').className="notice_error";
		        $('passwordValidMsg').innerHTML=msg[8];
		        $('txtPassword').className="input_text_error";
		        return false;
		    }
		    
		    if(password.length<3||password.length>15){
		        $('passwordValidMsg').className="notice_error";
		        $('passwordValidMsg').innerHTML=msg[9];
		        $('txtPassword').className="input_text_error";
		        return false;    
		    }
		        
		    $('passwordValidMsg').style.display="none";    
		    $('passwordValidMsg').innerHTML='';
		    $('password_ok').style.display="inline";
	    
		    return true;
		    
		}
		/*再次填写密码*/
		function check_repassword_focus(){
		    $('repassword_ok').style.display="none";
		    $('repeatPassValidMsg').style.display="none";
		}
		
	   function txtRepeatPass_check(){
		    var rep_password = $F('userpwd1');
		    $('repeatPassValidMsg').style.display="inline";
		    $('repeatPassValidMsg').innerHTML='';
		     $('repassword_ok').style.display="none";
		   
		    if(rep_password=='')
		    {
		        $('repeatPassValidMsg').style.display="inline";
		        $('repeatPassValidMsg').className="notice_error";    
		        $('repeatPassValidMsg').innerHTML=msg[10];
		        $('txtRepeatPass').className="input_text_error";
		        return false;
		    }
		    
		    if(rep_password!=$F('userpwd'))
		    {
		        $('repeatPassValidMsg').style.display="inline";
		        $('repeatPassValidMsg').className="notice_error";
		        $('repeatPassValidMsg').innerHTML=msg[11];
		        $('txtRepeatPass').className="input_text_error";
		        return false;
		    }
		    
		    
			    $('repeatPassValidMsg').style.display="none";    
			    $('repeatPassValidMsg').innerHTML='';
			    $('repassword_ok').style.display="inline";
			
		    
		    return true;
		}
		
		/*设置真实姓名*/
		function check_realname_focus(){
			$('realname_ok').style.display="none";
		    $('realNameValidMsg').className="notice_1";
		    $('realNameValidMsg').style.display="inline";
		    $('realNameValidMsg').innerHTML=msg[18];
		}
        
        function txtRealName_check(){
		    var realname = $F('userrealname');
		    $('realNameValidMsg').style.display="inline";
		    $('realname_ok').style.display="none";
            /*alert(nickname.charCodeAt(0));*/
            var length=realname.length;
            for(var i=0;i<length;i++){
            	if(realname.charCodeAt(i)>127 || realname.charCodeAt(i)==94){
            	    length+=1;
            	   /*alert(length);*/
            	}           	
            }
		    if(realname=='')
		    {
		        $('realNameValidMsg').className="notice_error";
		        $('realNameValidMsg').innerHTML=msg[4];
		        
		        return false;
		    }
		    /*alert(isNaN(nickname)==false);*/
		    if(length<4||length>20 ||isNaN(realname)==false){
		        $('realNameValidMsg').className="notice_error";
		        $('realNameValidMsg').innerHTML=msg[5];
		        
		        return false;
		    }
		    $('realNameValidMsg').style.display="none";    
		    $('realNameValidMsg').innerHTML='';
		    $('nickname_ok').style.display="inline";
   
		    return true;
		}
		
		/*设置出生日期*/
		function check_date_focus(){
			$('date_ok').style.display="none";
		    $('dateValidMsg').className="notice_1";
		    $('dateValidMsg').style.display="inline";
		    $('dateValidMsg').innerHTML=msg[15];
		}
        
        function txtDate_check(){
		    var date = $F('userdate');
		    $('dateValidMsg').style.display="inline";
		    $('date_ok').style.display="none";
            /*alert(nickname.charCodeAt(0));*/
            

			 var reg =/((^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(10|12|0?[13578])([-\/\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(11|0?[469])([-\/\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))([-\/\._])(0?2)([-\/\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([3579][26]00)([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][0][48])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][2468][048])([-\/\._])(0?2)([-\/\._])(29)$)|(^([1][89][13579][26])([-\/\._])(0?2)([-\/\._])(29)$)|(^([2-9][0-9][13579][26])([-\/\._])(0?2)([-\/\._])(29)$))/ig
			 if (!reg.test(date)){
			   $('realNameValidMsg').className="notice_error";
		       $('realNameValidMsg').innerHTML='日期有错 ，格式yyyy-mm-dd';
		       //后台验证是否大于10岁
			   return false;
			 }

		    $('dateValidMsg').style.display="none";    
		    $('dateValidMsg').innerHTML='';
		    $('date_ok').style.display="inline";
   
		    return true;
		}
		
		
		
		
		
		
		/** 获得填写邮箱地址的焦点*/
		function check_email_focus(){
		    $('email_ok').style.display="none";
		    $('emailValidMsg').className="notice_1";
		    $('emailValidMsg').style.display="inline";
		    $('emailValidMsg').innerHTML=msg[0];
		
		}
		/*验证填写邮箱地址*/
		function txtEmail_check(){
		    var email=$F('useremail');
		    var a=$('emailValidMsg');
		    var b=$('useremail');
		    /*判断是否为空*/
		    if(email==''){
		    	a.className='notice_error';
		    	a.innerText=msg[1];
		    	b.className='input_text_error';
		    	return false;
		    }
		    /*alert(email.indexOf('.'));*/
		    
		    /*判断邮箱的有效性*/
		    if(email.length>30 || email.indexOf('@')==-1 ||email.indexOf('.')==-1 ||email.indexOf('.')+1==email.length ||email.indexOf('.')<=email.indexOf('@')+1){
		      	a.className='notice_error';
		    	a.innerText=msg[2];
		    	b.className='input_text_error';
		    	return false;
		    }
		    /*验证通过后成功标志*/
		    a.style.display="none";
		    $('email_ok').style.display="inline";
		    return true;
		}	
		
		
		
		/*设置电话号码*/
		function check_phone_focus(){
			$('phone_ok').style.display="none";
		    $('phoneValidMsg').className="notice_1";
		    $('phoneValidMsg').style.display="inline";
		    $('phoneValidMsg').innerHTML=msg[15];
		}
        
        function txtPhone_check(){
		    var phone = $F('userphone');
		    $('phoneValidMsg').style.display="inline";
		    $('phone_ok').style.display="none";
            /*alert(phone.charCodeAt(0));*/
            
		    if(phone=='')
		    {
		        $('phoneValidMsg').className="notice_error";
		        $('phoneValidMsg').innerHTML="电话号码必填";
		        
		        return false;
		    }
		    /*alert(isNaN(phone)==false);*/
		    if(isNaN(phone)){
		        $('phoneValidMsg').className="notice_error";
		        $('phoneValidMsg').innerHTML="必须是数字";
		        
		        return false;
		    }
		    $('phoneValidMsg').style.display="none";    
		    $('phoneValidMsg').innerHTML='';
		    $('phone_ok').style.display="inline";
   
		    return true;
		}
		
		
		
		/*设置地址*/
		function check_addr_focus(){
			$('addr_ok').style.display="none";
		    $('addrValidMsg').className="notice_1";
		    $('addrValidMsg').style.display="inline";
		    $('addrValidMsg').innerHTML=msg[15];
		}
        
        function txtAddr_check(){
		    var nickname = $F('useraddr');
		    $('addrValidMsg').style.display="inline";
		    $('addr_ok').style.display="none";
            /*alert(nickname.charCodeAt(0));*/
            var length=nickname.length;
            
		    if(nickname=='')
		    {
		        $('addrValidMsg').className="notice_error";
		        $('addrValidMsg').innerHTML="地址必填";
		        
		        return false;
		    }
		    /*alert(isNaN(nickname)==false);*/
		    if(length>100){
		        $('addrValidMsg').className="notice_error";
		        $('addrValidMsg').innerHTML="";
		        
		        return false;
		    }
		    $('addrValidMsg').style.display="none";    
		    $('addrValidMsg').innerHTML='长度不能大于100；';
		    $('addr_ok').style.display="inline";
   
		    return true;
		}
		
		
		/*设置邮编*/
		function check_postcode_focus(){
			$('postcode_ok').style.display="none";
		    $('postcodeValidMsg').className="notice_1";
		    $('postcodeValidMsg').style.display="inline";
		    $('postcodeValidMsg').innerHTML='必填, 且是6位数字；';
		}
        
        function txtPostcode_check(){
		    var postcode = $F('userpostcode');
		    $('postcodeValidMsg').style.display="inline";
		    $('postcode_ok').style.display="none";
            /*alert(postcode.charCodeAt(0));*/
            var length=postcode.length;
            
		    if(postcode=='')
		    {
		        $('postcodeValidMsg').className="notice_error";
		        $('postcodeValidMsg').innerHTML='必填';
		        
		        return false;
		    }
		    /*alert(isNaN(postcode)==false);*/
		    if(length!=6){
		        $('postcodeValidMsg').className="notice_error";
		        $('postcodeValidMsg').innerHTML='必须是6位；';
		        
		        return false;
		    }
		    
		    if(length==6){
		        var reg=/\d{6}/;
		        if(reg.test(postcode)){
		        
			        $('postcodeValidMsg').className="notice_error";
			        $('postcodeValidMsg').innerHTML='必须是6位数字；';
			        return false;
		        }
		    }
		    $('postcodeValidMsg').style.display="none";    
		    $('postcodeValidMsg').innerHTML='';
		    $('postcode_ok').style.display="inline";
   
		    return true;
		}
		
		function check(){
		   if(
			  txtDate_check()==false || 
			  txtEmail_check()==false || 
			  txtPhone_check()==false || 
			  txtAddr_check()==false || 
			  txtPostcode_check()==false){
		      return false;
		   }
		   return true;
		}
		
		

      
		</script>
  </head>
  
  <body> 
     
     <div>
        <form action="<c:url value="/fsecuritymgr?act=reg"/>" method="post" onsubmit="return check();">
			<div class=login_frame>
			   <div class=login_area style="margin-left:5px;">  
				  <div class=login_true>   
				     <div>
				       <ul class=login_ul>
				         <li>
				            <span class=span_n>用户性别：</span>
				            <input type="radio" name="usersex" value="a" 
				             <c:if test="${logineduser.user_sex=='a' }">checked</c:if>
				            /> 男
				            <input type="radio" name="usersex" value="b" 
				             <c:if test="${logineduser.user_sex=='b' }">checked</c:if>
				            /> 女
				         </li>
				      	 <li>
				            <span class=span_n>出生日期：</span>
				            <input type="text" id="userdate" name="userdate" value="${logineduser.user_date }"
								class=input_text 
					            onblur="this.className='input_text';txtDate_check()"
								onfocus="this.className='input_text input_text_over';check_date_focus()">
				            <p id=dateValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=date_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				      	 <li>
				            <span class=span_n>电子邮箱：</span>
				            <input type="text" id="useremail" name="useremail"  value="${logineduser.user_email }"
				            	class=input_text 
					            onblur="this.className='input_text';txtEmail_check()"
								onfocus="this.className='input_text input_text_over';check_email_focus()">
				            <p id=emailValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=email_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				      	 <li>
				            <span class=span_n>电话号码：</span>
				            <input type="text" id="userphone" name="userphone" value="${logineduser.user_phone }"
								class=input_text 
					            onblur="this.className='input_text';txtPhone_check()"
								onfocus="this.className='input_text input_text_over';check_phone_focus()">
				            <p id=phoneValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=phone_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				      	 <li>
				            <span class=span_n>地址：</span>
				            <input type="text" id="useraddr" name="useraddr" value="${logineduser.user_addr }"
								class=input_text 
					            onblur="this.className='input_text';txtAddr_check()"
								onfocus="this.className='input_text input_text_over';check_addr_focus()">
				            <p id=addrValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=addr_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">		
				         </li>
				      	 <li>
				            <span class=span_n>邮编：</span>
				            <input type="text" id="userpostcode" name="userpostcode" value="${logineduser.user_postcode }"
								class=input_text 
					            onblur="this.className='input_text';txtPostcode_check()"
								onfocus="this.className='input_text input_text_over';check_postcode_focus()">
				            <p id=postcodeValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=postcode_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				      	 <ul>
				            <input type="submit" value=" 注 册 ">
				            <input type="reset" value=" 重 置 ">
				         </div>
				 	</div>
				</div>
			 </div>         
	      </form>
     
     
     </div>
  </body>
</html>
