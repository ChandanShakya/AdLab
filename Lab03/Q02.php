<!-- Write a program to handle form using POST method -->
<html>
<head>
    <title>Form Handling</title>
</head>
<body>
<form action="" method="post">
<table>
    <tr>
        <td>Name:</td>
        <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
        <td><input type="submit" name="submit" value="Submit" /></td>
    </tr>
</table>
<?php
if(isset($_POST['submit']))
{
    $Name=$_POST['Name'];

    if($Name=="")
    {
        echo "<script>alert('Please enter your name')</script>";
    }
    else
    {
        echo "<script>alert('Hello $Name')</script>";
    }
}
?>
</form>
</body>
</html>
