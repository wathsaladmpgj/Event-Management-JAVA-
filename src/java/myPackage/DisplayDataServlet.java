package myPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/DisplayDataServlet")
public class DisplayDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/event_details"; // Change 'mydb' to your database name
        String user = "root"; // Change this to your MySQL username
        String password = ""; // Change this to your MySQL password

        ArrayList<String[]> events = new ArrayList<>();
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM events";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                // Store user data in an array
                String[] eventData = { 
                    rs.getString("event_id"), 
                    rs.getString("event_name"), 
                    rs.getString("description") 
                };
                events.add(eventData);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Pass data to JSP page
        request.setAttribute("userList", events);
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayData.jsp");
        dispatcher.forward(request, response);
    }
}
