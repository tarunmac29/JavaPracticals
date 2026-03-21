<%-- 
    Document   : login
    Created on : Feb 25, 2026, 12:56:10?PM
    Author     : hp
--%>

<%@page language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Practical 7</h1>
        <form action="authenticate.jsp" method="post">
            Username : <input type="text" name="username"/>
            <br>
            Password:<input type="text" name="password"/>
            <input type="submit" value="submit"/>
        </form>
    </body>
</html>
