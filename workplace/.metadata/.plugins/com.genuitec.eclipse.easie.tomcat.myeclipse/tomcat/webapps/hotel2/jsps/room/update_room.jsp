<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>房间信息修改</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>"/>

  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">房间[${room.hotel.hotelName}-${room.roomNo}房]信息修改</div>
	    <form action="<c:url value="/action/roomMgr?act=update"/>" method="post">
	        <input type="hidden" name="room_id" value="${room.roomId}"/>
	        <div class="f_row">
	          <span>房间编号:</span>
	          <input type="text" name="room_no" size="20" value="${room.roomNo}"/>
	        </div>
	        <div class="f_row">
	          <span>所属分店:</span>
	          <select name="hotel_id">
	            <option value="0">==请选择==</option>
	            <c:forEach var="hotel" items="${hotelList}">
	            <option value="${hotel.hotelNo}" 
	                   <c:if test="${hotel.hotelNo==room.hotel.hotelNo}">selected</c:if>
	            >${hotel.hotelName}</option>
	            </c:forEach>
	          </select>
	        </div>	                
	        <div class="f_row">
	          <span>房间类型:</span>
	           <input type="radio" name="room_type" value="a" <c:if test="${room.roomType=='a'}">checked</c:if>/> 普单人间
	           <input type="radio" name="room_type" value="b" <c:if test="${room.roomType=='b'}">checked</c:if>/> 普双人间
	           <input type="radio" name="room_type" value="c" <c:if test="${room.roomType=='c'}">checked</c:if>/> 三人间
	           <input type="radio" name="room_type" value="d" <c:if test="${room.roomType=='d'}">checked</c:if>/> 商务套房
	           <input type="radio" name="room_type" value="e" <c:if test="${room.roomType=='e'}">checked</c:if>/> 贵宾套房      
	        </div>
	        <div class="f_row">
	          <span>房间设施:</span>
	          <input type="checkbox" name="room_equip" value="a"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='a'}">checked</c:if>
	            </c:forEach>
	          />平面液晶电视
	          <input type="checkbox" name="room_equip" value="b"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='b'}">checked</c:if>
	            </c:forEach>	          
	          />冰箱
	          <input type="checkbox" name="room_equip" value="c"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='c'}">checked</c:if>
	            </c:forEach>	          
	          />空调
	          <input type="checkbox" name="room_equip" value="d"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='d'}">checked</c:if>
	            </c:forEach>	          
	          />卫星电视
	          <input type="checkbox" name="room_equip" value="e"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='e'}">checked</c:if>
	            </c:forEach>	          
	          />互联网接入
	          <input type="checkbox" name="room_equip" value="f"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='f'}">checked</c:if>
	            </c:forEach>	          
	          />冲浪浴缸
	          <input type="checkbox" name="room_equip" value="g"
	            <c:forEach var="equip" items="${room.roomEquip}">
	               <c:if test="${equip=='g'}">checked</c:if>
	            </c:forEach>	          
	          />观海景         
	        </div>
	        <div class="f_row">
	          <span>房间状态:</span>
	          <select name="room_status">
	           <option  value="a" <c:if test="${room.roomStatus=='a'}">selected</c:if>> 未入住</option>
	           <option  value="b" <c:if test="${room.roomStatus=='b'}">selected</c:if>> 有住客</option>
	           <option  value="c" <c:if test="${room.roomStatus=='c'}">selected</c:if>> 已预订</option>
	           <option  value="d" <c:if test="${room.roomStatus=='d'}">selected</c:if>> 保洁中</option>
	           <option  value="e" <c:if test="${room.roomStatus=='e'}">selected</c:if>> 已退房未保洁</option>    
	           <option  value="f" <c:if test="${room.roomStatus=='f'}">selected</c:if>> 维护中 </option>	   
	          </select>          
	        </div>
	        <div class="f_row">
	          <span>备注说明:</span>
	          <textarea rows="8" cols="60" name="room_memo">${room.roomMemo}</textarea>
	        </div>	        	         
	        <div class="f_row">
	          <input type="submit" value="信息修改"/>      
	        </div>                        
	    </form>
    </div>
  </body>
</html>
