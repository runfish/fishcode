<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/common/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>农大网上商城-综合网购首选，正品行货，机打发票，售后上门取件，省钱又放心 </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/application.css"/>">
	
	

  </head>
  
  <body>
     <div  id=header>
        <div id=productName>农 大 网 上 商 城</div>
     </div>
     <div>
        <div id="navigator">
            <div class="menuitem"> 
            <span>农 大 商 城 服 务</span>
                 <dl>
                    <dt><a href="<c:url value="/goodsMgr?act=showgoods"/>" target="contentFrame">图书音像</a></dt>
                    <dd><a href="<c:url value="#"/>">数字音乐</a></dd>
                    <dd><a href="<c:url value="#"/>">人文社科</a></dd>
                    <dd><a href="<c:url value="#"/>">经营励志</a></dd>
                    <dd><a href="<c:url value="#"/>">生活百科</a></dd>
                    <dd><a href="<c:url value="#"/>">少儿教育</a></dd>
                 
                 </dl>
                 
                  <dl>
                    <dt>电子产品</dt>
                    <dd><a href="<c:url value="#"/>">手机数码</a></dd>
                    <dd><a href="<c:url value="#"/>">电脑</a></dd>
                    <dd><a href="<c:url value="#"/>">办公</a></dd>
                 
                 </dl>
                 
                  <dl>
                    <dt>家用电器</dt>
                    <dd><a href="<c:url value="#"/>">大家电</a></dd>
                    <dd><a href="<c:url value="#"/>">生活家电</a></dd>
                    <dd><a href="<c:url value="#"/>">厨房电器</a></dd>
                 
                 </dl>
                 
                  <dl>
                    <dt>生活用品</dt>
                    <dd><a href="<c:url value="#"/>">家居</a></dd>
                    <dd><a href="<c:url value="#"/>">服饰</a></dd>
                    <dd><a href="<c:url value="#"/>">箱包</a></dd>
                   
                 </dl>
                 
                  <dl>
                    <dt>食品饮料</dt>
                    <dd><a href="<c:url value="#"/>">进口食品</a></dd>
                    <dd><a href="<c:url value="#"/>">地方特产</a></dd>
                    <dd><a href="<c:url value="#"/>">休闲食品</a></dd>
                   
                 </dl>
                 
            </div>
            
        </div> 
        <div id="content">
          <iframe id="contentFrame" width="100%" scrolling="auto" height="480px" frameborder="0" name="contentFrame" allowtransparency="true" src="<c:url value=""/>">              
          </iframe>           
        </div>
      </div>        
  </body>
</html>
