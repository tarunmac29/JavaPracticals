import java.io.*;
import java.sql.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse
response)
 throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 try {
 // Load JDBC Driver
 Class.forName("com.mysql.cj.jdbc.Driver");
 // Create Connection
 Connection con = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/practical_4",
 "root", ""
 );
 // SQL Query
 PreparedStatement ps = con.prepareStatement(
 "SELECT * FROM user WHERE username=? AND password=?"
 );
 ps.setString(1, username);
 ps.setString(2, password);
 ResultSet rs = ps.executeQuery();
 // Authentication Logic
 if (rs.next()) {
 out.println("<h2>Login Successful</h2>");
 } else {
 out.println("<h2>Invalid Username or Password</h2>");
 }
 // Request Headers
 out.println("<h3>Request Header Values</h3>");
 Enumeration<String> reqHeaders = request.getHeaderNames();
 while (reqHeaders.hasMoreElements()) {
     String h = reqHeaders.nextElement();
 out.println(h + " : " + request.getHeader(h) + "<br>");
 }
 // Response Headers
 out.println("<h3>Response Header Values</h3>");
 response.setHeader("Application", "Practical_4");
 for (String h : response.getHeaderNames()) {
 out.println(h + " : " + response.getHeader(h) + "<br>");
 }
 // Close Resources
 rs.close();
 ps.close();
 con.close();
 } catch (ClassNotFoundException e) {
 out.println("Error: JDBC Driver not found<br>");
 out.println(e);
 } catch (SQLException e) {
 out.println("Error: Database problem<br>");
 out.println(e);
 }
 }
}

 