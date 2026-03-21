<%-- 
    Document   : index
    Created on : Mar 11, 2026, 12:42:40 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Integer users = (Integer) application.getAttribute("users");
    if (users > 3) {
        response.sendRedirect("error.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome User!</h1>
        <h3>Active users: <%= users%></h3>
    </body>
</html>
