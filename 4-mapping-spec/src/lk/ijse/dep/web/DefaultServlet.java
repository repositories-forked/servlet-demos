package lk.ijse.dep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Empty String Mapping */

/* This is a Default Servlet (Java EE) == Dispatcher Servlet (Spring) */

/*
* http://localhost:8080/myapp/hello - WildCard Servlet
* http://localhost:8080/myapp/customers - Customer Servlet
* http://localhost:8080/myapp/customers/abc - Default Servlet
* http://localhost:8080/myapp/customers/abc.php - Extension Servlet
* http://localhost:8080/myapp/ - Empty String Mapping
* http://localhost:8080/myapp - Empty String Mapping
* http://localhost:8080/myapp/ijse - Default Servlet
*
* */

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(urlPatterns = "/")
public class DefaultServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Default Mapping</h1>");
    }
}
