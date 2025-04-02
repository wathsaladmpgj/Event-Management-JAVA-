<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>User List</title>
    <style>
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            padding: 20px;
        }
        .card {
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 2px 2px 12px rgba(0,0,0,0.1);
            padding: 15px;
            background-color: #fff;
        }
        .card h3 {
            margin: 0;
            color: #333;
        }
        .card p {
            margin: 8px 0;
            color: #555;
        }
    </style>
</head>
<body>
    <h2>Event List</h2>
    <div class="card-container">
        <%
            ArrayList<String[]> events = (ArrayList<String[]>) request.getAttribute("userList");
            if (events != null && !events.isEmpty()) {
                for (String[] event : events) {
        %>
                    <div class="card">
                        <h3>ID: <%= event[0] %></h3>
                        <p><strong>Event Name:</strong> <%= event[1] %></p>
                        <p><strong>Description:</strong> <%= event[2] %></p>
                    </div>
        <%
                }
            } else {
        %>
            <p>No Event found</p>
        <%
            }
        %>
    </div>
</body>
</html>
