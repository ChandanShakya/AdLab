// Write a program to implement insert, delete, update and view data operation in JDBC

import java.sql.*;
import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        System.out.println("1. Insert");
        System.out.println("2. Delete");
        System.out.println("3. Update");
        System.out.println("4. View");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                insert();
                break;
            case 2:
                delete();
                break;
            case 3:
                update();
                break;
            case 4:
                view();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void insert() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee");
            PreparedStatement ps = con.prepareStatement("insert into employees values(?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, address);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Data not inserted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee");
            PreparedStatement ps = con.prepareStatement("delete from employee where name = ?");
            ps.setString(1, name);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data deleted successfully");
            } else {
                System.out.println("Data not deleted");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee");
            PreparedStatement ps = con.prepareStatement("update employee set age = ?, address = ? where name = ?");
            ps.setInt(1, age);
            ps.setString(2, address);
            ps.setString(3, name);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("Data not updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void view() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next()) {
                System.out.println("Name: " + rs.getString(1));
                System.out.println("Age: " + rs.getInt(2));
                System.out.println("Address: " + rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}