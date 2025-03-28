package myPackage;

import java.sql.*;

public class EventDAO {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/event_details";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Constructor: Load MySQL driver
    public EventDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading MySQL driver", e);
        }
    }

    // Method to add an event to the database
    public boolean addEvent(String eventName, String description, String eventDate, String location, String category, int totalSeats, int availableSeats) {
        String query = "INSERT INTO events (event_name, description, event_date, location, category, total_seats, available_seats) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, eventName);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, eventDate);
            preparedStatement.setString(4, location);
            preparedStatement.setString(5, category);
            preparedStatement.setInt(6, totalSeats);
            preparedStatement.setInt(7, availableSeats);
            return preparedStatement.executeUpdate() > 0; // Return true if insertion succeeds
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false on error
        }
    }
}
