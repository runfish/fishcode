<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>房间信息列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/list.css"/>">
	<script type="text/javascript" src="<c:url value="/js/common.js"/>"></script>
	
	<script type="text/javascript">
	    
	    function forUpdate(no){
	      location.href="<c:url value="/action/roomMgr?act=forUpdate"/>&roomid="+no;
	    }
	    
	    function doQuery(pageno)
         {
           if(pageno<1 || pageno>${pagedRooms.totalPageNum})
           {
              alert("页号超出范围，有效范围：[1-${pagedRooms.totalPageNum}]!");
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
	     <div id="title">房间信息列表</div>
	     <div id="qryarea">
		     <form action="<c:url value="/action/roomMgr?act=loadPagedRooms"/>" method="post">
		        <span>分店名称</span>
		        <select name="qryhotelno">
		          <option value="">== 请选择 == </option>
		          <c:forEach var="hotel" items="${hotelList}">
		             <option value="${hotel.hotelNo}" <c:if test="${param.qryhotelno==hotel.hotelNo}">selected</c:if> >${hotel.hotelName}</option>
		          </c:forEach>	          
		        </select>
		        <span>房间类型</span>
		        <select name="qryroomtype">
		           <option value="">== 请选择 == </option>
		           <option value="a" <c:if test="${param.qryroomtype=='a'}">selected</c:if> > 普单人间 </option>
		           <option value="b" <c:if test="${param.qryroomtype=='b'}">selected</c:if> > 普双人间 </option>
		           <option value="c" <c:if test="${param.qryroomtype=='c'}">selected</c:if> > 三人间   </option>
		           <option value="d" <c:if test="${param.qryroomtype=='d'}">selected</c:if> > 商务套房 </option>
		           <option value="e" <c:if test="${param.qryroomtype=='e'}">selected</c:if> > 贵宾套房 </option>  
		        </select>
		        <span>房间状态</span>
		        <select name="qryroomstatus">
		           <option value="">== 请选择 == </option>
		           <option  value="a" <c:if test="${param.qryroomstatus=='a'}">selected</c:if> > 未入住</option>
		           <option  value="b" <c:if test="${param.qryroomstatus=='b'}">selected</c:if> > 有住客</option>
		           <option  value="c" <c:if test="${param.qryroomstatus=='c'}">selected</c:if> > 已预订</option>
		           <option  value="d" <c:if test="${param.qryroomstatus=='d'}">selected</c:if> > 保洁中</option>
		           <option  value="e" <c:if test="${param.qryroomstatus=='e'}">selected</c:if> > 已退房未保洁</option>    
		           <option  value="f" <c:if test="${param.qryroomstatus=='f'}">selected</c:if> > 维护中 </option>	   
		         </select>
		         <input type="submit" value=" 查 询 "/>	
		       </form>          
	     </div>
	     <div>
	        <table id="listtable" cellpadding="0" cellspacing="0">
	          <tr>
	            <th>序号</th>
	            <th>所属酒店</th>
	            <th>房号</th>
	            <th>类型</th>
	            <th>设施</th>
	            <th>状态</th>
	            <th>操作</th>                                                            
	          </tr>
	          <c:forEach var="room" items="${pagedRooms.pageContent}">
		          <tr>
		            <td>${room.roomId}</td>
		            <td>${room.hotel.hotelName}</td>
		            <td>${room.roomNo}</td>
		            <td>
		              <c:choose>
		                <c:when test="${room.roomType=='a'}">普单人间</c:when>
		                <c:when test="${room.roomType=='b'}">普双人间</c:when>
		                <c:when test="${room.roomType=='c'}">三人间</c:when>
		                <c:when test="${room.roomType=='d'}">商务套房</c:when>
		                <c:when test="${room.roomType=='e'}">贵宾套房</c:when>
		              </c:choose>
		            </td>
		            <td>
		              <c:forEach var="equip" items="${room.roomEquip}">
			              <c:choose>
			                <c:when test="${equip=='a'}">平面液晶电视</c:when>
			                <c:when test="${equip=='b'}">冰箱</c:when>
			                <c:when test="${equip=='c'}">空调</c:when>
			                <c:when test="${equip=='d'}">卫星电视</c:when>
			                <c:when test="${equip=='e'}">互联网接入</c:when>
			                <c:when test="${equip=='f'}">冲浪浴缸</c:when>
			                <c:when test="${equip=='g'}">观海景</c:when>
			              </c:choose>
		              </c:forEach>
		            </td>
		            <td>
		              <c:choose>
		                <c:when test="${room.roomStatus=='a'}">未入住</c:when>
		                <c:when test="${room.roomStatus=='b'}">有住客</c:when>
		                <c:when test="${room.roomStatus=='c'}">已预订</c:when>
		                <c:when test="${room.roomStatus=='d'}">保洁中</c:when>
		                <c:when test="${room.roomStatus=='e'}">已退房未保洁</c:when>
		                <c:when test="${room.roomStatus=='f'}">维护</c:when>
		              </c:choose>		            
		            </td>
		            <td>
		               <button onclick="javascript:forUpdate(${room.roomId});"> 修 改 </button>
		               <button> 删 除 </button>
		            </td>                                                            
		          </tr>          
	          </c:forEach>
	        </table>
	     </div>
         <div id="pageinfo">
	            共${pagedRooms.totalRecNum}条, 当前显示${pagedRooms.startIndex}-${pagedRooms.endIndex}条, 第${pagedRooms.pageNo}/${pagedRooms.totalPageNum}页
	           |
	           <c:if test="${pagedRooms.pageNo>1}">
	             <span class="linkspan" onclick="doQuery(1)">首页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedRooms.prePage}">
	             <span class="linkspan" onclick="doQuery(${pagedRooms.pageNo-1})">上一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedRooms.nextPage}">
	             <span class="linkspan" onclick="doQuery(${pagedRooms.pageNo+1})">下一页</span>&nbsp;
	           </c:if>
	           <c:if test="${pagedRooms.pageNo!=pagedRooms.totalPageNum}">
	             <span class="linkspan" onclick="doQuery(${pagedRooms.totalPageNum})">末页</span>&nbsp;
	           </c:if>
	           |
	            到<input type="text" id="pageNo" size=4 style="text-align:right;" onkeypress="onlynumber();"/> 页
	           <button onclick="doQuery($('pageNo').value);"> 跳 转 </button>		           		           	           	              
	        </div>	     
     </div>
  </body>
</html>
