<!-- Write a server-side script from implementing login with username and password an redirect to welcome page if validated otherwise print an error -->

<?php
if(isset($_POST['submit']))
{
    $username = $_POST['username'];
    $password = $_POST['password'];
    if($username == "admin" && $password == "admin")
    {
        header("Location: Q04welcome.php");
    }
    else
    {
        echo "<script>alert('Invalid username or password');</script>";
    }
}
?>

<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form method="post">
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="submit" value="Login" /></td>
                </tr>
            </table>
        </form>
</html>
