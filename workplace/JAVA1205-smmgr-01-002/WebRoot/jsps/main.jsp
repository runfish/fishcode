<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>超市商品管理系统</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value="/CSS/application.css"/>">
<script type="text/javascript">

    var seed= Math.random();

</script>
  </head>
  
  <body>
     <div id="header">
        <div id="productName">超市商品管理系统</div>
        <div></div>
        <div></div>
     </div>
     <div>
        <div id="navigator">
            <div class="menuitem">
               <a href="<c:url value="/categoryMgr?act=input"/>" target="contentFrame">增加类别</a>
            </div>
            <div class="menuitem">
               <a href="<c:url value="/categoryMgr?act=loadall"/>"  target="contentFrame">类别管理</a>
            </div>
            <div class="seperator"></div>
            <div class="menuitem">
               <a href="<c:url value="/goodsMgr?act=input"/>"  target="contentFrame">新增商品</a>
            </div>
            <div class="menuitem">
               <a href="<c:url value="/goodsMgr?act=loadPageGoods"/>"   target="contentFrame">商品查询</a>
            </div>                        
        </div>
       <div id="content">
          <iframe id="contentFrame" width="100%" scrolling="no" height="480px" frameborder="0" name="contentFrame" allowtransparency="true" src="<c:url value="/welcome.jsp"/>">              
          </iframe>           
        </div>
     </div>
  </body>
</html>
