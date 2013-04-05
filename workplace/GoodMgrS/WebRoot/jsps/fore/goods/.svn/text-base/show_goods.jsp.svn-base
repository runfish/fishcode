<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>${goods.goods_name } - 商品信息 </title>
    
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
		     height:650px;
		     width: 960px;
		     text-align:center;
		     border:1px solid red;
		     
		  }
		  
		  #image{
		     margin-left:50px;
		  }
		  #image img{
		     float:left;
		     height:330px;
		     width:300px;
		  }
		  #content{
		    padding:20px 30px 30px 30px;
		    float:left;
		    border:1px solid red;
		    font-size:25px;		    
		  }
		  #detail{
		     width:400px;
		     border:1px solid blue;
		     float:left;
		     
		  }
		  #detail div{
		     border:1px solid blue;
		     text-align:left;
		     margin-top:20px;
		     word-wrap: break-word; 
             word-break: normal; 
		       
		  }
	      #detail span{
	         border:1px solid blue;
	         text-align:right;
	      }
	      
	      #url{
	         
	         margin-top:20px;
	         border:1px solid red;
	         
	      }
	      .linkspan{
	         border:1px solid blue;
	         margin-top:30px;
	         width:150px;
	      }
	
	</style>


	<script type="text/javascript">
	
	    function buy(){
	    
	    	location.href="<c:url value="/fshoppingcartmgr?act=buy&goodsid=${goods.goods_id }"/>";
	    }
	
		
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
		
		
	</script>
  </head>
  
  <body>
    <%@ include file="/jsps/fore/head.jsp" %>
    <div id="allcontent">
       <div id="image"><!-- 放图 -->
           <a title="点图片查看大图" href="<c:url value="/fgoodsmgr?act=showgoodspic&goodsid=${goods.goods_id}"/>">
           	<img  src="<c:url value="/fgoodsmgr?act=showgoodspic&goodsid=${goods.goods_id}"/>">
           </a>
       </div>
       <div id="content">
          <div id="detail"><!-- 信息   a)	详细信息包含商品名称、价格、是否缺货、描述、图片等。 -->
               <div><span>商品名称：</span> ${goods.goods_name }</div>
               <div><span>商品价格：</span> ${goods.goods_price }</div>
               <div><span>是否缺货：</span> 否</div>
               <div><span>商品描述：</span> ${goods.goods_desc }</div>
          </div>
          <div id="url"><!-- 按钮或连接 购买 返回 -->
               <span class="linkspan" onclick="buy();">购买</span>
               <span class="linkspan" onclick="history.go(-1);">返回</span>
          </div>
       </div>
       
    </div>
  </body>
</html>
