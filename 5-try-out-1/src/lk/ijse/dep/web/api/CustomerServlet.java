package lk.ijse.dep.web.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.dep.web.model.Customer;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Ranjith Suranga <suranga@ijse.lk>
 * @since : 12/8/20
 **/
@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.addHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jsonb jsonb = JsonbBuilder.create();
        Customer customer = jsonb.fromJson(req.getReader(), Customer.class);

        resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setContentType("application/json");
        BasicDataSource cp = (BasicDataSource) getServletContext().getAttribute("cp");
        try {
            Connection connection = cp.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?)");
            pstm.setString(1, customer.getId());
            pstm.setString(2, customer.getName());
            pstm.setString(3, customer.getAddress());
            boolean success = pstm.executeUpdate()>0;

            if (success){
                resp.getWriter().println(jsonb.toJson(true));
            }else{
                resp.getWriter().println(jsonb.toJson(false));
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.getWriter().println(jsonb.toJson(false));
        }

    }

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

                List<Customer> customersList = new ArrayList<>();

                while (rst.next()) {
                    String id = rst.getString(1);
                    String name = rst.getString(2);
                    String address = rst.getString(3);
                    customersList.add(new Customer(id, name, address));
                }

                Jsonb jsonb = JsonbBuilder.create();
                out.println(jsonb.toJson(customersList));
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
