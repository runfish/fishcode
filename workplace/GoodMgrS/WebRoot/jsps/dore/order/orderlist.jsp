<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'orderlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
   <body>
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">管理人员基本信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
              <input type="text" name="adminesearch" id="checkbox11" />
              <input type="submit" value="查询"/>
              <input type="submit" value="添加"/>
              </span>
              </div>
              </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
         <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">商品名</span></div></td>
         <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">所属大类</span></div></td>
         <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">所属小类</span></div></td>
          <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">商品价格</span></div></td>
          <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">描述</span></div></td>
          <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">是否缺货</span></div></td>
      </tr>
      <c:if test="${goodslist!=null}">
      <c:forEach items="${goodslist}" var="goods">
         <tr>
	        <td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.goods_name}</span></div></td>
	       	<td width="8%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.bigcategory.b_ctg_name}</span></div></td>
	        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.s_ctg_name}</span></div></td>
	        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.goods_price}</span></div></td>
	        <td width="25%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.goods_desc }</span></div></td>
	        <td width="5%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">${goods.goods_store }</span></div></td>
	        <td width="18%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">
	        <input type="submit" value="修改">
	        <input type="submit" value="删除">
	        </span></div></td>
         </tr>   
      </c:forEach>
      </c:if>
      <c:if test="${listadmine==null}">
          <tr>
             <td>无商品信息！</td>
           </tr>  
      </c:if>
      </table>
      </td>
      </tr>
    </table>
  </body>
</html>
