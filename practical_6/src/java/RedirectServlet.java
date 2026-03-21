
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author hp
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String prefix ="https://www.";
            String url = request.getParameter("location");
            String newurl=prefix.concat(url);
            if(newurl!= null && !newurl.isEmpty()){
                response.sendRedirect(newurl);
            }else{
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h3>Please enter a valid URL</h3>");
            }
        
    }

   
}
