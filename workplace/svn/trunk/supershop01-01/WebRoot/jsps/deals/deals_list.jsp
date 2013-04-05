<%@ page language="java" import="java.util.*,java.io.File" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>商品订单信息列表</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/date.css"/>">
    <script type="text/javascript" src="<c:url value="/js/common.js"/>"></script> 
    <script type="text/javascript" src="<c:url value="/js/prototype.js"/>"></script>
  
  	<script type="text/javascript">
  	    
  	     //页数控制
	      function doQuery(pageNo)
         {
	           if(pageNo<1 || pageNo>${pagedDeal.totalPageNum})
	           {
	              alert("页号超出范围，有效范围：[1-${pagedDeal.totalPageNum}]!");
	              ${'pageNo'}.select();
	              return;
	           }
	          var f=document.forms[0];
	           f.action=f.action+"&pageno="+pageNo;
	           f.submit();
         }
	    
	 //订单详细信息
	    function getDealItem(dealId)
	    {  
	     	var content=document.getElementById("display");
	    	var showDeal=document.getElementById("showdeal");
	    	var table=document.getElementById("wrapper");
	    	table.style.display="none";
	    	showDeal.style.display="block";
	    	
	     	if(content.hasChildNodes())
	     	{ 
	     	   content.innerHTML="";
	     	}
	     	new Ajax.Request(
	     	 encodeURI("/shop01/action/dealItemMgr?act=loadPageDealItem&rand="+Math.random()+"&dealid="+dealId),
	     	 {
	     	   method:"get",
	     	   onComplete:function(xhr)
	     	   {
	     	     var html=xhr.responseText;
	     	     content.innerHTML=html;
	     	   }
	     	 }
	     	);
	    }
	    //清空订单详细、收货人信息详细的元素节点内的所有内容
	    function cleanChild(object)
	    {  
	       var parentNode=object;
	       var show=parentNode.parentNode;
	       var table=document.getElementById("wrapper");
	       
	        if(parentNode.hasChildNodes())
	        {
	            parentNode.innerHTML="";
	        }
	       table.style.display="block";
	       show.style.display="none";
	    }
	    function onMouseOver(object)
	    {
	       object.style.background="gray";
	    }
	    function noMouseOut(object)
	    {
	       object.style.background="white";
	    }
	</script>
	</head>
  <body onload="getSystemDate();">
    <div id="wrapper">
	     <div id="title">订单信息列表</div>
	     <div>
          <form action="<c:url value="/action/dealMgr?act=loadPageDeal"/>" method="post">
		   <span class="f_row">订单编号</span>
		   <span><input  class="f_row" type="text" name="qurydealid" value="${param.qurydealid }"/></span>
		   <span class="f_row">订单状态</span>
		   <span>
			 <select name="qurydealstatus">
			 <option value="">== 请选择 == </option>
			 <option  value="a" <c:if test="${param.qurydealstatus=='a'}">selected</c:if> >未审核</option>
			 <option  value="b" <c:if test="${param.qurydealstatus=='b'}">selected</c:if> >已审核</option>
			 <option  value="c" <c:if test="${param.qurydealstatus=='c'}">selected</c:if> >审核未通过</option>
		   </select>
		  </span>
		  <span class="f_row">下单日期</span>
          <span><input style="cursor:hand" type="text" id="calendar" class="calendar_input" readonly="readonly" name="qurydealdate" value="${param.qurydealdate}"/></span>
		  <script type="text/javascript" src="<c:url value="/js/date.js"/>" charset="gbk"></script> 
		  <span><input style="cursor:hand;width:80;text-align:center" class="f_row" type="submit" value="查找"/></span>
        </form>
         </div>
	     <div>
	        <table id="listtable" cellpadding="0" cellspacing="0">
	          <tr>
	            <th>订单编号</th>
	            <th>付款方式</th>
	            <th>收货方式</th>
	            <th>收货人信息</th>
	            <th>订单状态</th>
	            <th>审核时间</th>
	            <th>下单时间</th>
	            <th>详细信息</th>
	            <th>管理员</th>                                                         
	          </tr>
	          <c:forEach var="deal" items="${pagedDeal.pageContent}">
		          <tr onmouseover="onMouseOver(this);" onmouseout="noMouseOut(this);">
		            <td>${deal.dealId }</td>
			        <td>
			         <c:choose>
			                <c:when test="${deal.payPattern=='b'}">货到付款</c:when>
			                <c:when test="${deal.payPattern=='c'}">网银支付</c:when>
			          </c:choose>
			        </td>
			        <td>
			           <c:choose>
			                <c:when test="${deal.receivePattern=='b'}">平邮</c:when>
			                <c:when test="${deal.receivePattern=='c'}">快递</c:when>
			                <c:when test="${deal.receivePattern=='d'}">ESM</c:when>
			          </c:choose>
			        </td>
		            <td>
		              <c:if test="${not empty deal.consigneeInfo}">
		                <script type="text/javascript">
		                   var consignee='${deal.consigneeInfo}';
		                   var array=consignee.split(":");
		                   document.write(array[0]);
		                </script>
		              </c:if>
		              <c:if test="${empty deal.consigneeInfo}">
		                 --无收货人信息--
		              </c:if>
		            </td>
		            <td>
		              <c:choose>
			                <c:when test="${deal.dealStatus=='a'}">未审核</c:when>
			                <c:when test="${deal.dealStatus=='b'}">已审核</c:when>
			                <c:when test="${deal.dealStatus=='c'}">审核未通过</c:when>
			          </c:choose>
		            </td>
		            <td>
		              <c:if test="${empty deal.dealExamDate}">----</c:if> 
		              <c:if test="${not empty deal.dealExamDate}">${deal.dealExamDate}</c:if> 
		            </td>
		            <td>${deal.dealDate }</td>
		            <td style="cursor:hand" ondblclick="getDealItem(${deal.dealId});">订单详细</td>
		            <td>${sessionScope.admin.administratorName}</td>                                                        
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
         <div id="pageinfo">
	        共${pagedDeal.totalRecNum}条, 当前显示${pagedDeal.startIndex}-${pagedDeal.endIndex}条, 第${pagedDeal.pageNo}/${pagedDeal.totalPageNum}页
	           |
	           <c:if test="${pagedDeal.pageNo>1}">
	             <span class="linkspan" onclick="javascript:doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.prePage}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.nextPage}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedDeal.pageNo!=pagedDeal.totalPageNum}">
	             <span class="linkspan" onclick="javascript:doQuery(${pagedDeal.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button style="cursor:hand" onclick="javascript:doQuery($('pageNo').value);"> 跳 转 </button>   	           		           	           	              
	     </div>	     	     
     </div>
     <div id="showdeal" style="display:none">
	     <div id="title">订单详细信息</div>
	     <div id="display" style="border:1px solid gray" ondblclick="cleanChild(this);"></div>
	 </div>
     <c:if test="${not empty error}">
      	   <script type="text/javascript">
        	 	alert('${error}');
         	</script>
     </c:if>
  </body>
</html>
