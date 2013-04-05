<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>分店信息录入</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>">
	
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	
	<script type="text/javascript">
	  
	    function removeHotel(no,name){
	      
	      if(confirm("您确认要删除分店["+name+"]的信息吗?")){
	         location.href='<c:url value="/action/hotelMgr?act=delete"/>&hotelno='+no;
	      }
	      
	    }
	    
	    function updateHotel(no){
	         location.href='<c:url value="/action/hotelMgr?act=forUpdate"/>&hotelno='+no;
	    }
	    
	    function doQuery(pageno)
         {
           if(pageno<1 || pageno>${pagedHotel.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedHotel.totalPageNum}]!");
              ${'pageNo'}.select();
              return;
           }
           
           var f=document.forms[0];
           f.action=f.action+"&pageNo="+pageno;
           f.submit();

         }
	
	</script>

  </head>
  
  <body>
	<div id="wrapper">
		     <div id="title">分店信息列表</div>
			 <div id="qryarea">
				<form action="<c:url value="/action/hotelMgr?act=loadPagedHotel"/>" method="post">
					<span>拥有房间数量:</span>
					<input type="text" class="text" name="minRoomCount" size=4 value="${param.minRoomCount}"/> - 
					<input type="text" class="text" name="maxRoomCount" size=4 value="${param.maxRoomCount}"/>&nbsp;
					<input type="submit" value=" 查 询 "/>	
				</form>               
		     <div>
		        <table id="listtable" cellpadding="0" cellspacing="0">
		          <tr>
		            <th>编号</th>
		            <th>分店名称</th>
		            <th>分店地址</th>
		            <th>联络电话</th>
		            <th>房间总数</th>
		            <th>操作</th>                                                            
		          </tr>
		          <c:forEach var="hotel" items="${pagedHotel.pageContent}">
			          <tr>
			            <td>${hotel.hotelNo}</td>
			            <td>
			              ${hotel.hotelName}
			              <img src="<c:url value="/action/hotelMgr?act=getpic"/>&hotelno=${hotel.hotelNo}" width="100px" height="80px"/>
			            </td>
			            <td>${hotel.hotelAddr}</td>
			            <td>${hotel.hotelPhone}</td>
			            <td>${hotel.hotelRoomCount}</td>
			            <td>
			               <button onclick="javascript:updateHotel(${hotel.hotelNo});"> 修 改 </button>
			               <button onclick="javascript:removeHotel(${hotel.hotelNo},'${hotel.hotelName}');"> 删 除 </button>
			            </td>                                                            
			          </tr>          
		          </c:forEach>
		        </table>
		     </div>
		     <div id="pageinfo">
	            共${pagedHotel.totalRecNum}条, 当前显示${pagedHotel.startIndex}-${pagedHotel.endIndex}条, 第${pagedHotel.pageNo}/${pagedHotel.totalPageNum}页
	           |
	           <c:if test="${pagedHotel.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedHotel.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedHotel.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedHotel.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedHotel.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedHotel.pageNo!=pagedHotel.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedHotel.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	        </div>
	     </div>
  </body>
</html>
