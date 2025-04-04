<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Event</title>
    <link rel="stylesheet" href="./form.css"/>
</head>

<body>
    <h2>Add Event Information</h2>
    <form action="addEvent" method="post">
        <label>Event Name:</label>
        <input type="text" name="event_name" required><br><br>

        <label>Description:</label>
        <textarea name="description" required></textarea><br><br>

        <label>Event Date:</label>
        <input type="date" name="event_date" required><br><br>

        <label>Location:</label>
        <input type="text" name="location" required><br><br>

        <label>Category:</label>
        <input type="text" name="category" required><br><br>

        <label>Total Seats:</label>
        <input type="number" name="total_seats" required><br><br>

        <label>Available Seats:</label>
        <input type="number" name="available_seats" required><br><br>

        <button type="submit">Submit</button>
    </form>
</body>

</html>
