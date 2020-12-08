package lk.ijse.dep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Empty String Mapping */

/*
* http://localhost:8080/myapp/hello - NO
* http://localhost:8080/myapp/customers - NO
* http://localhost:8080/myapp/customers/abc - NO
* http://localhost:8080/myapp/customers/abc.php - NO
* http://localhost:8080/myapp/ - YES
* http://localhost:8080/myapp - YES
*
* */

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(urlPatterns = "")
public class EmptyStringServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Empty String Mapping</h1>");
    }
}
