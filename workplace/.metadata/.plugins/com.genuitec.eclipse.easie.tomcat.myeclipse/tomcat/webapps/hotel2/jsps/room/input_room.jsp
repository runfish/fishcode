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
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/form.css"/>"/>

  </head>
  
  <body>
    <div id="wrapper">
	    <div id="f_title">酒店房间登记</div>
	    <form action="<c:url value="/action/roomMgr?act=create"/>" method="post">
	        <div class="f_row">
	          <span>房间编号:</span>
	          <input type="text" name="room_no" size="20"/>
	        </div>
	        <div class="f_row">
	          <span>所属分店:</span>
	          <select name="hotel_id">
	            <option value="0">==请选择==</option>
	            <c:forEach var="hotel" items="${hotelList}">
	            <option value="${hotel.hotelNo}">${hotel.hotelName}</option>
	            </c:forEach>
	          </select>
	        </div>	                
	        <div class="f_row">
	          <span>房间类型:</span>
	           <input type="radio" name="room_type" value="a"/> 普单人间
	           <input type="radio" name="room_type" value="b" checked/> 普双人间
	           <input type="radio" name="room_type" value="c"/> 三人间
	           <input type="radio" name="room_type" value="d"/> 商务套房
	           <input type="radio" name="room_type" value="e"/> 贵宾套房      
	        </div>
	        <div class="f_row">
	          <span>房间设施:</span>
	          <input type="checkbox" name="room_equip" value="a" checked/>平面液晶电视
	          <input type="checkbox" name="room_equip" value="b" checked/>冰箱
	          <input type="checkbox" name="room_equip" value="c" checked/>空调
	          <input type="checkbox" name="room_equip" value="d"/>卫星电视
	          <input type="checkbox" name="room_equip" value="e"/>互联网接入
	          <input type="checkbox" name="room_equip" value="f"/>冲浪浴缸
	          <input type="checkbox" name="room_equip" value="g"/>观海景         
	        </div>
	        <div class="f_row">
	          <span>房间状态:</span>
	          <select name="room_status">
	           <option  value="a"> 未入住</option>
	           <option  value="b"> 有住客</option>
	           <option  value="c"> 已预订</option>
	           <option  value="d"> 保洁中</option>
	           <option  value="e"> 已退房未保洁</option>    
	           <option  value="f"> 维护中 </option>	   
	          </select>          
	        </div>
	        <div class="f_row">
	          <span>备注说明:</span>
	          <textarea rows="8" cols="60" name="room_memo"></textarea>
	        </div>	        	         
	        <div class="f_row">
	          <input type="submit" value="保存信息"/>      
	        </div>                        
	    </form>
    </div>
  </body>
</html>
