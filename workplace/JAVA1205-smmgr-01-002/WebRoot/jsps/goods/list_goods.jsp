<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品信息列表</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/form.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
  
  	<script type="text/javascript">
	    
	    function doQuery(pageno)
         {
           if(pageno<1 || pageno>${pagedGoods.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedGoods.totalPageNum}]!");
              ${'pageNo'}.select();
              return;
           }
           
           var f=document.forms[0];
           f.action=f.action+"&pageNo="+pageno;
           f.submit();
           //location.href="<c:url value="/goodsMgr?act=loadall"/>&pageNo="+pageno;
         }
	    function forUqdate(goodsId)
	    {
	       location.href="<c:url value="/goodsMgr?act=forUpdate"/>&goodsid="+goodsId;
	    }
	    
	    function removeGoods(goodsId,goodsName)
	    {
	        if(confirm("确认要删除商品["+goodsName+"]的信息吗?"))
	        {
				location.href="goodsMgr?act=del&goodsid="+goodsId;
	        }
	    }
	</script>
	</head>
  <body>
   <div class="f_row">
     <form action="goodsMgr?act=loadall" method="post">
     <div>
      <span>商品名称：</span>
      <input type="text" name="qurygoodsname" value="${param.qurygoodsname}"/>
      <span>商品类别：</span>
      <select name="quryctgid">
      <option value="gctgempty" <c:if test="${param.qurygoodssrc=='gctgempty'}">selected</c:if>>---请选择---</option>
      <c:forEach var="ctg" items="${ctglist}">
      <option value="${ctg.ctgId}" <c:if test="${param.quryctgid==ctg.ctgId}">selected</c:if>>${ctg.ctgName}</option>
      </c:forEach>
      </select>
      <span>商品来源：</span>
      <select name="qurygoodssrc">
       <option value="gsrcempty" <c:if test="${param.qurygoodssrc=='gsrcempty'}">selected</c:if>>---请选择---</option>
       <option value="a" <c:if test="${param.qurygoodssrc=='a'}">selected</c:if>>自产</option>
       <option value="b" <c:if test="${param.qurygoodssrc=='b'}">selected</c:if>>代售</option>
       <option value="c" <c:if test="${param.qurygoodssrc=='c'}">selected</c:if>>厂家直销</option>
       <option value="d" <c:if test="${param.qurygoodssrc=='d'}">selected</c:if>>自营</option>
      </select>
	    <input type="submit" value="查找"/>        	       
   </div>
   </form>
   </div>
    <div id="wrapper">
	     <div id="title">商品信息列表</div>
	     <div>
	        <table id="listtable" cellpadding="0" cellspacing="0">
	          <tr>
	            <th>商品编号</th>
	            <th>商品名称</th>
	            <th>商品价格</th>
	            <th>商品所属类型</th>
	            <th>商品来源</th>
	            <th>商品存储条件</th>
	            <th>商品状态 </th>
	            <th>操作</th>                                                            
	          </tr>
	          <c:forEach var="goods" items="${pagedGoods.pageContent}">
		          <tr>
		            <td>${goods.goodsId }</td>
		            <td>${goods.goodsName}</td>
		            <td>${goods.goodsPrice}</td>
		            <td>
		              <c:forEach var="ctg" items="${ctglist}">
                        <c:if test="${ctg.ctgId==goods.ctgId}">${ctg.ctgName}</c:if>
                      </c:forEach>
                    </td>
		            <td>
		              <c:choose>
		                <c:when test="${goods.src=='a'}">自产</c:when>
		                <c:when test="${goods.src=='b'}">代售</c:when>
		                <c:when test="${goods.src=='c'}">厂家直销</c:when>
		                <c:when test="${goods.src=='d'}">自营</c:when>
		              </c:choose>
		            </td>
		            <td>
		              <c:forEach var="goodsStoreCondition" items="${goods.goodsStoreCondition}">
			              <c:choose>
			                <c:when test="${goodsStoreCondition=='a'}">冷藏*</c:when>
			                <c:when test="${goodsStoreCondition=='b'}">保险剂</c:when>
			                <c:when test="${goodsStoreCondition=='c'}">保鲜薄膜</c:when>
			                <c:when test="${goodsStoreCondition=='d'}">定期整理*</c:when>
			               
			              </c:choose>
			              &nbsp;
		              </c:forEach>
		            </td>
		            <td>
		              <c:choose>
		                <c:when test="${goods.status=='a'}">已上架</c:when>
		                <c:when test="${goods.status=='b'}">未上架</c:when>
		              </c:choose>		            
		            </td>
		            <td>
		               <button onclick="javascript:forUqdate(${goods.goodsId});"> 修 改 </button>
		               <button onclick="javascript:removeGoods(${goods.goodsId},'${goods.goodsName}');"> 删 除 </button>
		            </td>                                                            
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
         <div id="pageinfo">
	            共${pagedGoods.totalRecNum}条, 当前显示${pagedGoods.startIndex}-${pagedGoods.endIndex}条, 第${pagedGoods.pageNo}/${pagedGoods.totalPageNum}页
	           |
	           <c:if test="${pagedGoods.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedGoods.pageNo!=pagedGoods.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedGoods.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	      </div>	     	     
     </div>
  </body>
</html>
