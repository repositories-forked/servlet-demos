package lk.ijse.dep.web.api;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BasicDataSource cp = (BasicDataSource) getServletContext().getAttribute("cp");

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setContentType("application/json");
        try (PrintWriter out = resp.getWriter()) {
            try {
                Connection connection = cp.getConnection();
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

                String json = ("[");
                while (rst.next()) {
                    String id = rst.getString(1);
                    String name = rst.getString(2);
                    String address = rst.getString(3);
                    json += ("{" +
                            "\"id\":\""+ id +"\"," +
                            "\"name\":\"" + name + "\"," +
                            "\"address\":\"" + address + "\"" +
                            "},");
                }
                json = json.substring(0, json.length() - 1);
                json += ("]");
                out.println(json);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
