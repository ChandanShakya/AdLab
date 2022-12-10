<!-- Write a program to store page views count in SESSION, increment the count on each refresh, and show the count on webpage -->
<?php
session_start();
if(!isset($_SESSION['count']))
{
$_SESSION['count']=0;
}
$_SESSION['count']++;
echo "Page views count: ".$_SESSION['count'];
?>

