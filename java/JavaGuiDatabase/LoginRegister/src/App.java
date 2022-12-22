// Creating a java app that uses swing to create a GUI
// IT should contain registration form with the following fields
// First Name, Last Name, Email, Password
// It should also have a button to submit the form and login button that redirects to the login page
// When the form is submitted, it should display a message
// "Registration Successful"
// The form should be validated before submission
// The form should not be submitted if any of the fields is empty
// The form should not be submitted if the email is not valid
// The form should not be submitted if the password is less than 8 characters
// It should redirect to a login page when the form is submitted successfully

// The login page should have a form with the following fields
// Email, Password
// It should have a button to submit the form and register button that redirects to the registration page
// When the form is submitted, it should display a message
// "Login Successful"
// The form should be validated before submission
// The form should not be submitted if any of the fields is empty
// The form should not be submitted if the email is not valid
// The form should not be submitted if the password is less than 8 characters

// Database connection
// Database name: swing
// Table name: users
// Table fields: id, first_name, last_name, email, password

// The form should be submitted to the database when the form is submitted successfully

// The login form should be validated against the database when the form is submitted

// Code Starts Here

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.mysql.jdbc.Driver;

public class App extends JFrame implements ActionListener {
    // Declaring the variables
    private Container container;
    private JLabel title;
    private JLabel firstName;
    private JTextField firstNameField;
    private JLabel lastName;
    private JTextField lastNameField;
    private JLabel email;
    private JTextField emailField;
    private JLabel password;
    private JPasswordField passwordField;
    private JButton register;
    private JButton login;
    private JLabel success;
    // mode = 0 for registration
    // mode = 1 for login
    private int mode = 0;

    // Creating a constructor
    public App() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);

        firstName = new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 20));
        firstName.setSize(100, 20);

        firstNameField = new JTextField();
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        firstNameField.setSize(190, 20);

        lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Arial", Font.PLAIN, 20));
        lastName.setSize(100, 20);

        lastNameField = new JTextField();
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 15));
        lastNameField.setSize(190, 20);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailField.setSize(190, 20);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(190, 20);

        register = new JButton("Register");
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(100, 20);
        register.addActionListener(this);
        container.add(register);

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(100, 20);
        login.addActionListener(this);

        success = new JLabel("");
        success.setFont(new Font("Arial", Font.PLAIN, 20));
        success.setSize(500, 25);

        showRegister();
        setVisible(true);
    }

    // Creating a method to connect to the database
    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing", "root", "");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Creating a method to insert data into the database
    public void insert() {
        String query = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?)";
        Connection connection = getConnection();
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, firstNameField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, emailField.getText());
            statement.setString(4, passwordField.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registration Successful");
            showRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // For Registration validation
    public boolean validateRegistration() {
        if (firstNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "First Name is required");
            return false;
        } else if (lastNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Last Name is required");
            return false;
        } else if (emailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Email is required");
            return false;
        } else if (passwordField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password is required");
            return false;
        }else if (!emailField.getText().contains("@") || !emailField.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Email is not valid");
            return false;
        } else if (passwordField.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters");
            return false;
        } else {
            return true;
        }
    }

    // For Login validation
    public boolean validateLogin() {
        if (emailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Email is required");
            return false;
        } else if (passwordField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password is required");
            return false;
        } else {
            return true;
        }
    }

    // Creating a method to login
    public void login() {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        Connection connection = getConnection();
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, emailField.getText());
            statement.setString(2, passwordField.getText());
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                success.setText("Login Successful. Welcome " + firstNameField.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showRegister() {
        container.removeAll();
        setTitle("Registration Form");

        mode = 0;
        title.setText("Registration Form");
        title.setLocation(300, 100);


        // Reshow the first name and last name fields
        firstName.setLocation(250, 200);
        firstNameField.setLocation(400, 200);
        lastName.setLocation(250, 250);
        lastNameField.setLocation(400, 250);
        // move the email and password fields down
        email.setLocation(250, 300);
        emailField.setLocation(400, 300);
        password.setLocation(250, 350);
        passwordField.setLocation(400, 350);
        // move the register and login buttons down
        register.setLocation(360, 400);
        login.setLocation(780, 0);
        // change the text of the buttons
        register.setText("Register");
        login.setText("Login");
        // Set all fields to empty
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        // revalidate the container
        // Add the components to the container
        container.add(title);
        container.add(firstName);
        container.add(firstNameField);
        container.add(lastName);
        container.add(lastNameField);
        container.add(email);
        container.add(emailField);
        container.add(password);
        container.add(passwordField);
        container.add(register);
        container.add(login);
        container.add(success);
        container.revalidate();
        container.repaint();

    }

    public void showLogin() {
        container.removeAll();
        setTitle("Login Form");

        mode = 1;
        title.setText("Login Form");
        title.setLocation(350, 100);


        // move the email and password fields up
        email.setLocation(250, 200);
        emailField.setLocation(400, 200);
        password.setLocation(250, 250);
        passwordField.setLocation(400, 250);
        // move the register and login buttons up
        login.setLocation(360, 300);
        register.setLocation(780, 0);
        // change the text of the buttons
        register.setText("Back");
        login.setText("Login");
        // Clear the email and password fields
        emailField.setText("");
        passwordField.setText("");
        // revalidate the container
        // Add the components to the container
        container.add(title);
        container.add(email);
        container.add(emailField);
        container.add(password);
        container.add(passwordField);
        container.add(register);
        container.add(login);
        container.add(success);

        container.revalidate();
        container.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // If clicked register when in registration mode
        // register the user
        // If clicked register when in login mode
        // show the first name and last name fields
        // and validate the registration

        // If clicked login when in registration mode
        // hide the first name and last name fields
        // and validate the login
        // If clicked login when in login mode
        // validate the login

        if (e.getSource() == register) {
            if (mode == 0) {
                if (validateRegistration()) {
                    insert();
                }
            } else {
                showRegister();
            }
        } else if (e.getSource() == login) {
            if (mode == 0) {
                showLogin();
            } else {
                if (validateLogin()) {
                    login();
                }
            }
        }
    }
}