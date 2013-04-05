<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'input_order.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
		   if(txtNickName_check()==false || 
			  txtEmail_check()==false || 
			  txtPhone_check()==false || 
			  txtAddr_check()==false || 
			  txtPostcode_check()==false){
		      return false;
		   }
		   return true;
		}
	
	
	
	
	</script>
	
	
	
	
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
		     height:300px;
		  }
		  #allcontent div{
		    width:100%;
		    height:130px;
		    border:1px solid blue;
		  }
		  #allcontent span{
		    
		    border:1px solid blue;
		    
		    text-align:center;
		  }
	
   </style>

  </head>
  
  <body> 
    <%@ include file="/jsps/fore/head.jsp" %>
     <div id="allcontent">
       <div><!-- 付款方式；收货方式；
      及收货人相关信息(收货人姓名、收货人地址、收货人邮编、收货人电话、收货人email)；
        -->
        <form action="<c:url value="/fordermgr?act=add"/>" method="post" style="border:1px solid blue;">  
          <div>
			   <ul class=login_ul>
			             <li>
				            <span class=span_n>付款方式：</span>
				            <input type="radio" name="paymode" value="a"/>邮局汇款 
				            <input type="radio" name="paymode" value="b"/>银行汇款 
				         </li>
			   			 <li>
				            <span class=span_n>收货方式：</span>
				            <input type="radio" name="receivemode" value="a"/>A类
				            <input type="radio" name="receivemode" value="v"/>A类
				         </li>
						 <li>
				            <span class=span_n>收货人姓名：</span>
				            <input type="text" id="username" name="receivername" value="${logineduser.user_name }"
				            	class=input_text 
					            onblur="this.className='input_text';txtNickName_check()"
								onfocus="this.className='input_text input_text_over';check_nickname_focus()">
				            <p id=nickNameValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=nickname_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				      	 <li>
				            <span class=span_n>收货人地址：</span>
				            <input type="text" id="useraddr" name="receiveraddr" value="${logineduser.user_addr }"
								class=input_text 
					            onblur="this.className='input_text';txtAddr_check()"
								onfocus="this.className='input_text input_text_over';check_addr_focus()">
				            <p id=addrValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=addr_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">		
				         </li>
				      	 <li>
				            <span class=span_n>收货人邮编：</span>
				            <input type="text" id="userpostcode" name="receivepostcode" value="${logineduser.user_postcode }"
								class=input_text 
					            onblur="this.className='input_text';txtPostcode_check()"
								onfocus="this.className='input_text input_text_over';check_postcode_focus()">
				            <p id=postcodeValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=postcode_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				         <li>
				            <span class=span_n>收货人电话：</span>
				            <input type="text" id="userphone" name="receiverphone" value="${logineduser.user_phone }"
								class=input_text 
					            onblur="this.className='input_text';txtPhone_check()"
								onfocus="this.className='input_text input_text_over';check_phone_focus()">
				            <p id=phoneValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=phone_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				         <li>
				            <span class=span_n>收货人email：</span>
				            <input type="text" id="useremail" name="receiveremail"  value="${logineduser.user_email }"
				            	class=input_text 
					            onblur="this.className='input_text';txtEmail_check()"
								onfocus="this.className='input_text input_text_over';check_email_focus()">
				            <p id=emailValidMsg style="font-size:13px;"></p>
							<img class=notice_ok id=email_ok title=填写正确 src="<c:url value="/pic/write_ok.gif"/>">
				         </li>
				  <ul>
				  
				  <div><!-- 订单项  价格总计    -->
       					<table>
       					   <tr><th>商品名称</th><th>商品价格</th><th>商品数量</th><th>小计</th></tr>
       					   <c:forEach var="cartitem" items="${shoppingcart.items}">
					            <tr>
					              <td>${cartitem.goods.goods_name }</td>
								  <td>￥${cartitem.goods.goods_price }</td>
					              <td>${cartitem.amount }</td>
								  <td>￥${cartitem.totalPrice }</td>          
					            </tr>
					         </c:forEach>
       					</table>
       					<div style="float:right;"><span>商品金额总计：￥${shoppingcart.cartAmount }</span></div>
			       </div>
			       
			       <div style="width:100%"></div>
			       <div style="float:right;"><!-- 按钮类 -->
			          <input type="submit" value=" 注 册 " >
			       </div>
			       
			</div>
          </form>
       
       
       </div>
       
    </div>
    <div>
		<%@ include file="/jsps/fore/footer.jsp" %>
	</div>
  </body>
</html>
