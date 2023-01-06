// Write a program to save name, roll number, address, pone number and age into the file named as info.txt

import java.io.*;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone number: ");
        long phone = sc.nextLong();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.close();
        try {
            FileWriter fw = new FileWriter("info.txt");
            fw.write("Name: " + name + "\nRoll number: " + roll + "\nAddress: " + address + "\nPhone: " + phone + "\nAge: " + age);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
