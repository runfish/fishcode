<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>酒店管理系统</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">

	<script type="text/javascript">
	      function logout(){
	         if(confirm('尊敬的${loginedUser.userName},您真的要离开系统吗？')){
	            location.href="<c:url value="/action/securityMgr?act=logOut"/>";
	         }
	      }
	</script>	

  </head>
  
  <body>
     <div id="header">
        <div id="productName">酒店管理系统</div>
        <div></div>
        <div style="float:right; margin:10px;">
               操作员:${loginedUser.userName}&nbsp;
             <span class="linkspan" onclick="logout();" title="点击离开系统">离开系统</span>
        </div>
     </div>
     <div>
        <div id="navigator">
            <div class="menuitem">
               <a href="<c:url value="/action/hotelMgr?act=input"/>" target="contentFrame">开设分店</a>
            </div>
            <div class="menuitem">
               <a href="<c:url value="/action/hotelMgr?act=loadPagedHotel"/>"  target="contentFrame">分店管理</a>
            </div>
            <div class="seperator"></div>
            <div class="menuitem">
               <a href="<c:url value="/action/roomMgr?act=input"/>"  target="contentFrame">开设房间</a>
            </div>
            <div class="menuitem">
               <a href="<c:url value="/action/roomMgr?act=loadPagedRooms"/>"   target="contentFrame">房间查询</a>
            </div>                        
        </div>
        <div id="content">
          <!-- 嵌入式框架  inner frame (window) -->
          <iframe id="contentFrame" width="100%" scrolling="no" height="480px" frameborder="0" name="contentFrame" allowtransparency="true" src="<c:url value="/welcome.jsp"/>">              
          </iframe>           
        </div>
     </div>
  </body>
</html>
