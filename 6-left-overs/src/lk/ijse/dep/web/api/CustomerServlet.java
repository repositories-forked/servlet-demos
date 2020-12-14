package lk.ijse.dep.web.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/14/20
 **/
@WebServlet(name = "CustomerServlet", urlPatterns = "/customers",loadOnStartup = 5)
public class CustomerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Customer Servlet is loading...!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContentType());
        response.getWriter().println("<h1>Customers Servlet</h1>");
    }
}
