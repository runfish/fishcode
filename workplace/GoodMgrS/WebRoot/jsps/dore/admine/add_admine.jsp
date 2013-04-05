<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_admine.jsp' starting page</title>
    
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
                <td width="94%" valign="bottom"><span class="STYLE1">添加管理员</span></td>
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
            <td><div>管理员姓名<input type="text" name="adminename"></div>
                <div>管理员密码<input type="text" name="adminename"></div>
                <div>确认密码<input type="text" name="adminename"></div>
                <div>真实姓名<input type="text" name="adminename"></div>
                <div>性别
                <input type="radio" name="adminesex">男
                <input type="radio" name="adminesex">女
                </div>
                <div>出生日期<input type="text" name="adminename"></div>
                <div>电子邮箱<input type="text" name="adminename"></div>
                <div>电话号码<input type="text" name="adminename"></div>
                <div>地址<input type="text" name="adminename"></div>
                <div>邮编<input type="text" name="adminename"></div>
                <div>
                  <input type="submit" value="确定">
                  <input type="submit" value="返回">
                </div>
            </td>          
      </tr>
     </table>   
  </body>
</html>
