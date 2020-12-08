package lk.ijse.dep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(name = "MyServlet", urlPatterns = "/hello")
public class MyServlet extends HttpServlet {

    public MyServlet() {
        System.out.println("Thaama mama nikan object ekak hodea!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Onna mama servlet ekak dn hodea...!");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("Mama ithin methana thamai jeewath wennea hodea...!");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Hello Servlet!</h1>");
        }
//        int i = 0;
//        while(true){
//            System.out.println(i++);
//        }
    }

    @Override
    public void destroy() {
        System.out.println("Mama yanna hadannea hodea...!");
    }
}
