<%@ page import="ir.maktabsharif.dto.user.UserResponseDto" %><%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 10/17/2026
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<%
    UserResponseDto userResponseDto = (UserResponseDto) request.getSession().getAttribute("user");
%>

<h1>profile</h1>

<h2>id = <%=userResponseDto.getId()%></h2>
<h2>username = <%=userResponseDto.getUsername()%></h2>
<h2>fullName = <%=userResponseDto.getFullName()%></h2>
<h2>phonNumber = <%=userResponseDto.getPhonNumber()%></h2>



</body>
</html>
