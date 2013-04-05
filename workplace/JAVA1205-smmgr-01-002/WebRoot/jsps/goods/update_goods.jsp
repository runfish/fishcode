<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ include file="/jsps/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品信息修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/application.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/form.css"/>"/>

  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">商品[${goods.goodsName}]信息修改</div>
	    <form action="<c:url value="/goodsMgr?act=update"/>" method="post">
	        <input type="hidden" name="goodsid" value="${goods.goodsId}"/>
	   	 	<div class="f_row">
	          <span>商品名称:</span>
	          <input type="text" name="goodsname" value="${goods.goodsName}" size="20"/>
	    	</div>
	   		<div class="f_row">
	          <span>商品单价:</span>
	          <input type="text" name="goodsprice" value="${goods.goodsPrice}" size="20"/>
	    	</div>
	    	<div class="f_row">
	          <span>商品所属类别:</span>
	          <select name="goodsctgid" >
	            <option value="0">==请选择==</option>
                  <c:forEach var="category" items="${ctglist}">
		             <option value="${category.ctgId}" <c:if test="${goods.ctgId==category.ctgId}">selected</c:if> >${category.ctgName}</option>
		          </c:forEach>	          
	          </select>
	    	</div>
	        <div class="f_row">
	          <span>商品来源:</span>
	           <input type="radio" name="goodssrc" value="a" <c:if test="${goods.src=='a'}">checked</c:if>/> 自产
	           <input type="radio" name="goodssrc" value="b" <c:if test="${goods.src=='b'}">checked</c:if>/> 代售
	           <input type="radio" name="goodssrc" value="c" <c:if test="${goods.src=='c'}">checked</c:if>/> 厂家直销
	           <input type="radio" name="goodssrc" value="d" <c:if test="${goods.src=='d'}">checked</c:if>/> 自营	              
	        </div>
	        <div class="f_row">
	          <span>商品储存条件:</span>
	          <input type="checkbox" name="goodsstorecondition" value="a"
	            <c:forEach var="condition" items="${goods.goodsStoreCondition}">
	               <c:if test="${condition=='a'}">checked</c:if>
	            </c:forEach>
	          />冷藏
	          <input type="checkbox" name="goodsstorecondition" value="b"
	            <c:forEach var="condition" items="${goods.goodsStoreCondition}">
	               <c:if test="${condition=='b'}">checked</c:if>
	            </c:forEach>
	          />保险剂
	          <input type="checkbox" name="goodsstorecondition" value="c"
	            <c:forEach var="condition" items="${goods.goodsStoreCondition}">
	               <c:if test="${condition=='c'}">checked</c:if>
	            </c:forEach>
	          />保鲜薄膜
	          <input type="checkbox" name="goodsstorecondition" value="d"
	            <c:forEach var="condition" items="${goods.goodsStoreCondition}">
	               <c:if test="${condition=='d'}">checked</c:if>
	            </c:forEach>
	          />定期整理
	        </div>
	        <div class="f_row">
	          <span>商品状态:</span>
	          <select name="goodsstatus">
	           <option  value="a" <c:if test="${goods.status=='a'}">selected</c:if>> 上 架 </option>
	           <option  value="b" <c:if test="${room.status=='b'}">selected</c:if>> 未上 架 </option>
	          </select>          
	        </div>  	         
	        <div class="f_row">
	          <input type="submit" value="信息修改"/>      
	        </div>                        
	    </form>
    </div>
  </body>
</html>