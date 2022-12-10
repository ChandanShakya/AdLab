<!-- Write a program to handle arithmetic exception : Divide by Zero -->

<?php
$dividend = 10;
$divisor = 0;
try {
    if ($divisor == 0) {
        throw new Exception("Division by zero");
    }
    $quotient = $dividend / $divisor;
    echo "Quotient = $quotient";
} catch (Exception $e) {
    echo "Message: " . $e->getMessage();
}
?>
