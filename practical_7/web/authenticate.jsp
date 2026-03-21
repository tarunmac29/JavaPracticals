<%-- 
    Document   : authenticate
    Created on : Feb 25, 2026, 12:59:49?PM
    Author     : hp
--%>

<%@page import="java.sql.*"%>


<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db", "root", "");

        PreparedStatement ps = con.prepareStatement("select * from users where username=? AND password = ?");

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            session.setAttribute("username", username);
            response.sendRedirect("welcome.jsp");
        }else{
            response.sendRedirect("error.jsp");
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException e) {
        out.println("Error : " + e);
    }catch (ClassNotFoundException e) {
        out.println("Error : " + e);
    }

%>
