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
@WebServlet(name = "ItemServlet", urlPatterns = "/items")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BasicDataSource cp = (BasicDataSource) getServletContext().getAttribute("cp");

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setContentType("application/xml");
        try (PrintWriter out = resp.getWriter()) {
            try {
                Connection connection = cp.getConnection();
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT * FROM Item");

                out.println("<items>");
                while (rst.next()) {
                    String code = rst.getString(1);
                    String description = rst.getString(2);
                    String unitPrice = rst.getBigDecimal(3).setScale(2).toPlainString();
                    int qtyOnHand = rst.getInt(4);
                    out.println("<item>" +
                                    "<code>" + code + "</code>" +
                                    "<description>" + description + "</description>" +
                                    "<unit-price>" + unitPrice + "</unit-price>" +
                                    "<qty-on-hand>" + qtyOnHand + "</qty-on-hand>" +
                                "</item>");
                }
                out.println("</items>");
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
