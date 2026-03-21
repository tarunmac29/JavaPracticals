
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author hp
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String dept = request.getParameter("dept");

        HttpSession session = request.getSession();

        session.setAttribute("name", name);
        session.setAttribute("id", id);
        session.setAttribute("dept", dept);

        out.println("<h1>Welcome, " + name + "</h1>");
        out.println("<form action='MarksServlet' method='post'>");
        out.println("<label>Subject1:</label> <input type='number' name='m1'><br>");
        out.println("<label>Subject2:</label> <input type='number' name='m2'><br>");
        out.println("<label>Subject3:</label> <input type='number' name='m3'><br>");
        out.println("<label>Subject4:</label> <input type='number' name='m4'><br>");
        out.println("<label>Subject5:</label> <input type='number' name='m5'><br>");
        out.println("<label>Subject6:</label> <input type='number' name='m6'><br>");

        out.println("<input type='submit' value='Generate Result'>");
        out.println("</form>");

    }

}
