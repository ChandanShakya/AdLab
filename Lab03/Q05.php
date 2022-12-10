<!-- Create a form to collect student details such as name, address, phone, age, gender and store into the database. -->

<?php

// Connect to the database
$connection = mysqli_connect("localhost", "root", "", "student");

// Check connection
if ($connection->connect_error) {
    die("Connection failed: " . $connection->connect_error);
}

// Get the form data
$name = $_POST['name'];
$address = $_POST['address'];
$phone = $_POST['phone'];
$age = $_POST['age'];
$gender = $_POST['gender'];

// Insert the data into the database
$sql = "INSERT INTO student (name, address, phone, age, gender) VALUES ('$name', '$address', '$phone', '$age', '$gender')";
if ($connection -> query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $connection -> error;
}

// Close the connection
$connection -> close();

?>

<html>
    <head>
        <title>Student Details</title>
    </head>
    <body>
        <h1>Student Details</h1>
        <form action="Q05.php" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="text" name="age" required></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td><input type="text" name="gender" required></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
