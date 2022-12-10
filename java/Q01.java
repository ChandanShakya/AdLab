// Create class Number with only one private instance variable as double primitive type.
// To include the following methods:
// 1. A constructor to initialize the instance variable.
// isZero() to check whether the number is zero or not.
// isPositive() to check whether the number is positive or not.
// isNegative() to check whether the number is negative or not.
// isOdd() to check whether the number is odd or not.
// isEven() to check whether the number is even or not.
// isPrime() to check whether the number is prime or not.
// isArmstrong() to check whether the number is Armstrong or not.

// return boolean primitive type.

// getFactorial() to return the factorial of the number.
// getSqrt() to return the square root of the number.
// getSqr() to return the square of the number.
// sumDigits() to return the sum of the digits of the number.
// getReverse() to return the reverse of the number.

// returns double primitive type.

// void listFactors() to list the factors of the number.
// void dispBinary() to display the binary equivalent of the number.


import java.util.Scanner;

class Number {
    private double num;

    Number(double num) {
        this.num = num;
    }

    boolean isZero() {
        return num == 0;
    }

    boolean isPositive() {
        return num > 0;
    }

    boolean isNegative() {
        return num < 0;
    }

    boolean isOdd() {
        return num % 2 != 0;
    }

    boolean isEven() {
        return num % 2 == 0;
    }

    boolean isPrime() {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    boolean isArmstrong() {
        int sum = 0;
        int temp = (int) num;
        while (temp != 0) {
            int digit = temp % 10;
            sum += digit * digit * digit;
            temp /= 10;
        }
        return sum == num;
    }

    double getFactorial() {
        double fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    double getSqrt() {
        return Math.sqrt(num);
    }

    double getSqr() {
        return num * num;
    }

    int sumDigits() {
        int sum = 0;
        int temp = (int) num;
        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        return sum;
    }

    int getReverse() {
        int rev = 0;
        int temp = (int) num;
        while (temp != 0) {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp /= 10;
        }
        return rev;
    }

    void listFactors() {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    void dispBinary() {
        int temp = (int) num;
        String bin = "";
        while (temp != 0) {
            int digit = temp % 2;
            bin = digit + bin;
            temp /= 2;
        }
        System.out.println(bin);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        Number n = new Number(num);
        System.out.println("Is zero: " + n.isZero());
        System.out.println("Is positive: " + n.isPositive());
        System.out.println("Is negative: " + n.isNegative());
        System.out.println("Is odd: " + n.isOdd());
        System.out.println("Is even: " + n.isEven());
        System.out.println("Is prime: " + n.isPrime());
        System.out.println("Is Armstrong: " + n.isArmstrong());
        System.out.println("Factorial: " + n.getFactorial());
        System.out.println("Square root: " + n.getSqrt());
        System.out.println("Square: " + n.getSqr());
        System.out.println("Sum of digits: " + n.sumDigits());
        System.out.println("Reverse: " + n.getReverse());
        System.out.print("Factors: ");
        n.listFactors();
        System.out.print("Binary: ");
        n.dispBinary();
    }
}

