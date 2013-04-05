<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>
<%@page import="net.dfrz.demo.Student"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<%
	Student student = new Student();
    student.setSname("xiaoyu");
    request.setAttribute("student",student);
%>

<%
  String [] username={"xiaoyu","lh","ly"};
  request.setAttribute("username",username);
  
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<bean:write  scope="request" name="student" property="sname"/>
<table border="1px">
<tr>
  <td colspan="2">
    <bean:message bundle="myKey" key="greeting"/>
  </td>
</tr>
<tr>
  <td colspan="2">
    <bean:message bundle="myKey" key="sname"/>
  </td>
</tr>
<tr>
  <td colspan="2">
    <bean:message bundle="myKey" key="sex"/>
  </td>
</tr>
<tr>
  <td colspan="2">
  <input type="submit" value="<bean:message bundle="myKey" key="login"/>">
</td>
</tr>
</table>
outputEveryName:<br>
<logic:iterate id="name"  scope="request" name="username">
    ${name}
    <bean:write name="username" scope="request"/>
</logic:iterate>
</body>
</html>