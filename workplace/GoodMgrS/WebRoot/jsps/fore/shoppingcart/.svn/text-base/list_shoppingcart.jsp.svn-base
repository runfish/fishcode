<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>购物车 -</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
		 <link rel="stylesheet" type="text/css"  href="<c:url value="/css/application.css"/>">
        <link rel="stylesheet" type="text/css"  href="<c:url value="/css/head.css"/>">
		<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
		
		
		<script type="text/javascript">
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



      	function onlynumber() {
			if (event.keyCode==13){
				return true;
			}
			if (event.keyCode<48||event.keyCode>57){
				event.keyCode=0;
				event.returnValue=false;
			}
			event.returnValue=true;
		}


//		function setNewItemAmount(bookcode,amount)
//	    {
//       //alert(bookcode+","+amount);
//	       location.href="<c:url value="/workflow?act=setnewitemamount&bookcode="/>"+bookcode+"&newamount="+amount;
//	    }
	    
	    
	    function removeBookFromCart(goodsid,goodsname)
	    {
	      if(confirm("您真的要删除购物车中的商品条目["+goodsname+"]吗?"))
	        location.href="<c:url value="/fshoppingcartmgr?act=del&goodsid="/>"+goodsid;
	    }






		function setNewItemAmount(goodsid,amount)
        {                                    //ajax 更改价格
          
          new Ajax.Request(
    //         "chkLen?friendName="+encodeURI(name),
              "fshoppingcartmgr?act=cartitemnum&goodsid="+goodsid+"&cartitemnum="+amount,
             {
               method:"get",
               onComplete:function(xhr){
                  eval(xhr.responseText); ;
               }
             }
          );    
        }
        
		function updateCartItem(id,price){
			var all_price=$(id);
		    all_price.innerHTML=price;
		}



		function updateCart(allprice){
			var allprice=$('allprice');
			allprice.innerHTML=allprice;
		}
		</script>
	
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
			     
			  }
		      img{
		         width:60px;
		         height:70px; 
		      }
		      .left{
		         text-align:left;
		         margin-left:20px;
		      }
		 
		</style>
	
	
	
		</head>

	<body>
	  <%@ include file="/jsps/fore/head.jsp"%>
	   <div id="allcontent">
	      <table>
	         <tr>
	           <th>商品名称</th><th>商品缩略图</th><th>商品单价</th><th>商品数量</th><th>商品小计</th><th>删除商品</th>
	         </tr>
	         <c:forEach var="cartitem" items="${shoppingcart.items}">
	            <tr>
	              <td>${cartitem.goods.goods_name }</td>
	              <td><img src="<c:url value="/fgoodsmgr?act=showgoodspic&goodsid="/>${cartitem.goods.goods_id }" ></td>
				  <td>${cartitem.goods.goods_price }</td>
				  <td>
				  <input class=del_num name=quantity maxLength=4 size=3
					value=${cartitem.amount } onKeyPress="onlynumber();"
					onblur="setNewItemAmount('${cartitem.goods.goods_id }',this.value)" />
				  </td>
				  <td id="${cartitem.goods.goods_id }">${cartitem.totalPrice }</td>
				  <td><span onclick="removeBookFromCart('${cartitem.goods.goods_id }','${cartitem.goods.goods_name }');">删除</span></td>          
	            </tr>
	         </c:forEach>
	      </table>
	      <div><!-- 总价之类的 -->
	         
		     <div style="border:2px solid blue;">
		         	<div class="left"><span onclick="location.href='<c:url value="/fshoppingcart?act=clear"/>';">清空购物车</span></div>
		         	
		         	<div style="float:right;"><span id="allprice">￥0.0元</span><span onclick="location.href='<c:url value="/fshoppingcart?act=payoff"/>';">结算中心</span></div>
		         	<div class="left"><span onclick="location.href='<c:url value="/fgoodsmgr?act=main"/>'; ">继续购物</span></div>
		     </div> 
	       </div>
	       
	   </div>
	   <div>
			   <%@ include file="/jsps/fore/footer.jsp" %>
	   </div>
	</body>
</html>
