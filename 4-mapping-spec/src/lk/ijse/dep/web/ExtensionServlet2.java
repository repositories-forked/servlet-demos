package lk.ijse.dep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Extension Mapping */

/*
* http://localhost:8080/myapp/index.php - YES
* http://localhost:8080/myapp/manage-customers.php - YES
* http://localhost:8080/myapp/customers/manage-customers.php - YES
* http://localhost:8080/myapp/abc/customers/manage-customers.php - YES
*
* */

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(urlPatterns = "*.php")
public class ExtensionServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Extension Mapping</h1>");
    }
}
