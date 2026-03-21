<%-- 
    Document   : welcome
    Created on : Feb 27, 2026, 9:46:59 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    
    String action = request.getParameter("do");
    
    if("logout".equals(action)){
        session.invalidate();
        response.sendRedirect("login.jsp");
        return;
    }
    
    String username = (String)session.getAttribute("username");
    
    if(username == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
    </head>
    <body>
        <h2>Welcome, <%= username %>!</h2>

        
        <a href="welcome.jsp?do=logout">
            <button type="button">Logout</button>
        </a>
    </body>
</html>
