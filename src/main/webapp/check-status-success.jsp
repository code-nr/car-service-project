<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String serviceStatus=(String)session.getAttribute("sserviceStatus");
out.println(serviceStatus);
 %>
</body>
</html>