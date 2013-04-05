<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>商品总汇</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	
		<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
		
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
		  #list{
		    border:1px solid red;
		    float:left;
		    width:200px;
		    height: 100%;
		  }
		  #content{
		     border:1px solid red;
		     float:left;
		     width:755px;
		  
		  }
		  
		  #content form{
		     margin-bottom:50px;
		  }
		  #content form select{
		     width:150px;
		  }
		  
		  .goods{
		    border:1px solid red;
			float:left;
			width:240px;
			margin-left:7px;
					        
		  }
		  
		  #allgoods{
		    border:1px dotted blue;
		    float:left;
		    width:755px;
		  }
		 
		  
		
		</style>
		
		
		
		
		
		<style type="text/css">
			ul,li,dl,dd {
			padding:0;
			margin:0;
			list-style-type:none;
			}
			.menu1{
			width:182px;
			border:1px solid #feb951;
			background:#fef4ea;
			padding-top:3px;
			font-size:12px;
			}
			.area li{
			height:22px;
			line-height:22px;
			text-align:left;
			position:relative;
			}
			.area li a {
			display:block;
			padding-left:20px;
			}
			.area li dl {
			width:180px;
			overflow:hidden;
			display:none;
			position:absolute;
			top:-1px;
			right:-182px;
			z-index:35533;
			border:1px solid #feb951;
			background:#fef4ea;
			padding:5px 0;
			}
			.area li dl a:hover {
			border:1px solid #feb951;
			background:#fff;
			margin:0 5px;
			padding-left:14px;
			}
			.area li.lion {
			height:20px;
			line-height:20px;
			text-align:left;
			border-top:1px solid #ffb850;
			border-bottom:1px solid #ffb850;
			background:#ffe7cc;
			}
			.area li.lion dl {display:block;}
		</style>


		<script type="text/javascript">
		
		function doQuery(pageno){
		   if(pageno<1 || pageno>${page.totalPageNum}){
		   
		        alert("页号超出范围，有效范围：[1-${page.totalPageNum}]!");
		        $('pageNo').select();
		        return;
		   }
		   
		   var f=document.forms[0];
		   f.action=f.action+"&pageNo"+pageno;
		   f.submit();
		
		}
		
		
		function qrysctg(){
		    
		    new Ajax.Request(
            encodeURI("fgoodsmgr?smallajax="+document.forms[0].qrybctg.options[qrybctg.selectedIndex].value),
            {
              method:"get",
              onComplete:function(xhr){
                 // alert(xhr.responseText);
                  $("small").innerHTML=xhr.responseText;
              }
            }  
         );
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
			<div  id="list">
				<!-- 列表 -->
				<div id="rtab2_box" class="menu1">
					<ul id="area" class="area">
						<c:forEach var="bl" items="${biglist}">
							<li><a href="<c:url value="/fgoodsmgr?act=main&qrybctg=${bl.b_ctg_id }"/>">${bl.b_ctg_name }</a>
								<dl>
								    <c:forEach var="sl" items="${smalllist}">
									    <c:if test="${bl.smallCategory.s_ctg_id==sl.s_ctg_id}">
									       <dd><a href="<c:url value="fgoodsmgr?act=main&qrybctg=${bl.b_ctg_id }&qrysctg=${sl.s_ctg_id }"/>">${sl.s_ctg_name }</a></dd>
									    </c:if>   
									</c:forEach>    
								</dl>
							</li>
						</c:forEach>
					</ul>
				</div>
				
					<script type=text/javascript>
						function onload() {
						    try{
								var lies = document.getElementById("area").getElementsByTagName("li");
								for (var i=0; i< lies.length; i++) {
									lies[i].onmouseover= function() {
										this.className="lion";
								    }
									lies[i].onmouseout= function() {
										this.className="";
									}
								}
							}catch(e){}
						}
						
						
					    onload();
					</script>





			</div>
			<div id="content">
				<!-- 右边内容 -->
				<div>
					<form action="fgoodsmgr?act=main" method="post">
						<div>
								<span>商品大类：</span>
								<select name="qrybctg" onblur="qrysctg();">
									<option value="">
										==请选择==
									</option>
									<c:forEach var="blist" items="${biglist}">
										<option value="${blist.b_ctg_id }"
											<c:if test="${blist.b_ctg_id==param.qrybctg }">selected</c:if>>
											${blist.b_ctg_name }
										</option>
									</c:forEach>
								</select>
							
								<span>商品小类：</span>
								<select name="qrysctg" onmouseover="qrysctg();" style="">
									<option value="">
										==请选择==
									</option>
								</select>
							
							
								<span>商品名称：</span>
								<input type="text" size="14">
							
							    <input type="submit" value="查 询">
						</div>
					</form>
			</div>
			

			<div >
				<!-- 详细的很多商品 -->
			  <div id=allgoods;>
				<c:forEach var="goods" items="${page.pageContent}">
				 
					<div class="goods">
						<span> <a
							href="<c:url value="/fgoodsmgr?act=showgoods&goodsid=${goods.goods_id }"/>">
								<img style="width: 130px; height: 150px;"
									src="<c:url value="/fgoodsmgr?act=showgoodspic&goodsid=${goods.goods_id }" />">
						</a> <br /> </span>


						<h2>
							<a
								href="<c:url value="/fgoodsmgr?act=showgoods&goodsid=${goods.goods_id }"/>">${book.goods_name}</a>
						</h2>
						
						<h4>
							￥${book.goods_price}元
						</h4>


						<span> <a target="_blank"
							href="<c:url value="/fgoodsmgr?act=showgoods&goodsid=${goods.goods_id }"/>">详细信息</a>
						</span>
						<span> <a target="_blank"
							href="<c:url value="/fshoppingcartmgr?act=buy&goodsid=${goods.goods_id }"/>">购买</a>
						</span>
					</div>
					
				   </c:forEach>
				   	 <c:if test="${empty page.pageContent}">
					           <div >
					               <span> 没有符合条件的商品信息被找到!</span>
					           </div>
			         </c:if>
                  </div>
 				<div id="page">
 				       共${page.totalRecNum}条, 当前显示${page.startIndex}-${page.endIndex}条, 第${page.pageNo}/${page.totalPageNum}页
	          			 |
			           <c:if test="${page.pageNo>1}">
			             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
			           </c:if>
			           <c:if test="${page.prePage}">
			             <span class="linkspan" onclick="doQuery(${page.pageNo-1})">上一页</span>&nbsp;
			           </c:if>
			           <c:if test="${page.nextPage}">
			             <span class="linkspan" onclick="doQuery(${page.pageNo+1})">下一页</span>&nbsp;
			           </c:if>
			           <c:if test="${page.pageNo!=page.totalPageNum}">
			             <span class="linkspan" onclick="doQuery(${page.totalPageNum})">末页</span>&nbsp;
			           </c:if>
			           |
			            到<input type="text" id="pageNo" style="text-align:right;" onkeypress="onlynumber();" size="4"/> 页
			           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>
			 	</div>
				 	
			 </div>
			
		   </div>
	     </div> 
	     
	        
			<div>
			   <%@ include file="/jsps/fore/footer.jsp" %>
			</div>
       
	</body>
</html>
