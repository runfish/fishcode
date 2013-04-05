<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>商品信息录入</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/application.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/form.css"/>"/>

  </head>
  
  <body>
     <div id="f_title">商品信息登记</div>
     <form action="goodsMgr?act=create" method="post">
	    <div class="f_row">
	          <span>商品名称:</span>
	          <input type="text" name="goods_name" size="20"/>
	    </div>
	    <div class="f_row">
	          <span>商品单价:</span>
	          <input type="text" name="goods_price" size="20"/>
	    </div>
	    <div class="f_row">
	          <span>商品所属类别:</span>
	          <select name="goods_ctg_id">
	            <option value="0">==请选择==</option>
                  <c:forEach var="category" items="${categoryList}">
		             <option value="${category.ctgId}" <c:if test="${param.goods_ctg_id==category.ctgId}">selected</c:if> >${category.ctgName}</option>
		          </c:forEach>	          
	          </select>
	    </div>
	    <div class="f_row">
	          <span>商品来源:</span>	          
	          <input type="radio" name="goods_src"  value="a"/>自产
	          <input type="radio" name="goods_src"  value="b"/>代售
	          <input type="radio" name="goods_src"  value="c"/>厂家直销
	          <input type="radio" name="goods_src"  value="d"/>自营	    
	    </div>
	    <div class="f_row">
	          <span>商品储存条件:</span>	          
	          <input type="checkbox" name="goods_store_condition" value="a"/>冷藏
	          <input type="checkbox" name="goods_store_condition" value="b"/>保险剂
	          <input type="checkbox" name="goods_store_condition" value="c"/>保鲜薄膜
	          <input type="checkbox" name="goods_store_condition" value="d"/>定期整理
	    </div>
	    <div class="f_row">
	          <span>商品状态:</span>	          
	          <select name="goods_status">
	           <option  value="a"> 上 架 </option>
	           <option  value="b"> 未上架</option>   
	          </select>          	       
	    </div>
	  	<div class="f_row">
	          <input type="submit" value="保存信息"/>        	       
	    </div>
     </form>
  </body>
</html>
