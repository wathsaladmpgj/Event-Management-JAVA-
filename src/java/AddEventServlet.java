package myPackage;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet {

    private EventDAO eventDAO;

    @Override
    public void init() throws ServletException {
        eventDAO = new EventDAO(); // Initialize the DAO object
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        // Collect form data
        String eventName = request.getParameter("event_name");
        String description = request.getParameter("description");
        String eventDate = request.getParameter("event_date");
        String location = request.getParameter("location");
        String category = request.getParameter("category");
        int totalSeats = Integer.parseInt(request.getParameter("total_seats"));
        int availableSeats = Integer.parseInt(request.getParameter("available_seats"));

        // Insert event using DAO class
        boolean isInserted = eventDAO.addEvent(eventName, description, eventDate, location, category, totalSeats, availableSeats);

        // Display message based on result
        response.getWriter().println(isInserted ? "<h3>Event added successfully!</h3>" : "<h3>Failed to add the event.</h3>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Use the form to submit an event.</h1>");
    }
}
