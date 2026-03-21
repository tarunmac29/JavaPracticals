<%-- 
    Document   : index
    Created on : Mar 13, 2026, 9:39:39 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="st" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sort 10 numbers (comma seperated): </h1>
        <form method="post">
            <input type="text" name="nums" size="40" required="">
            <input type="submit" value="Sort">
        </form>
        <%
            String numbers = request.getParameter("nums");
            if (numbers != null) {


        %>
        <st:sort numbers="<%= numbers%>"/>
        <%
            }
        %>
        
    </body>
</html>
