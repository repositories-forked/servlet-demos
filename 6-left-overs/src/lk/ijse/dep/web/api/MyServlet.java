package lk.ijse.dep.web.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/14/20
 **/
@WebServlet(name = "MyServlet", urlPatterns = "/hello/*", loadOnStartup = 1)
public class MyServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet is loading...!");
        System.out.println("---------------------");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Context Path: " + request.getContextPath());
        System.out.println("Servlet Path: " + request.getServletPath());
        System.out.println("Path Info: " + request.getPathInfo());
        System.out.println("Path Translated: " + request.getPathTranslated());
        System.out.println("QueryString: " + request.getQueryString());
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("RealPath: " + getServletContext().getRealPath("abc"));
//        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.setContentType("image/jpeg");
        String imgPath = request.getPathTranslated() + File.separator + "profile-pic.jpeg";
        byte[] imgBytes = Files.readAllBytes(Paths.get(imgPath));
        response.getOutputStream().write(imgBytes);
    }
}
