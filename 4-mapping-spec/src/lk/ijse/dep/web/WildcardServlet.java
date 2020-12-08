package lk.ijse.dep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Wildcard Mapping */

/*
* http://localhost:8080/myapp/hello/abc - YES
* http://localhost:8080/myapp/hello/abc/bcd - YES
* http://localhost:8080/myapp/hello - YES
* http://localhost:8080/myapp/hello/ - YES
* http://localhost:8080/myapp/hello/* - YES
* http://localhost:8080/myapp/hello/*abc - YES
*
* */

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(urlPatterns = "/hello/*")
public class WildcardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Wildcard Servlet</h1>");
    }
}
