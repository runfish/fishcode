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
    
    <title>My JSP 'add_category.jsp' starting page</title>
    
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
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=basePath %>pic/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">添加商品类别</span></td>
              </tr>
            </table></td>
            <td><div align="right">
              </div>
              </td>
          </tr> 
         </table></td>
        </tr>
        </table></td>
      </tr>
      <tr>
            <td><div>商品类别名<input type="text" name="categoryname"></div>
		        <div>
			       <span>所属大类:</span>
			          <select name="bctg_id">
			            <option value="0">无</option>
			            <c:forEach var="bctg" items="${bctglist}">
			                <option value="${bctg.b_ctg_id}">${bctg.b_ctg_name}</option>
			            </c:forEach>
			          </select>
			        </div>
                <div>
                  <input type="submit" value="确定">
                  <input type="submit" value="返回">
                </div>
            </td>          
      </tr>
     </table>   
  </body>
</html>
