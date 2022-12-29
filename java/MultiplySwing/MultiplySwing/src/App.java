/* Write a program using swing components to multiply two numbers. Use text fields for inputs
and output. Your program should display the result when the user presses a button. */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// create a main class
public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Multiplier");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);

        JLabel resultLabel = new JLabel("Result: ");

        JButton multiplyButton = new JButton("Multiply");

        frame.add(num1Field);
        frame.add(num2Field);
        frame.add(multiplyButton);
        frame.add(resultLabel);

        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the input numbers from the text fields
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                // Calculate the result of the multiplication
                int result = num1 * num2;

                // Set the result label to display the result
                resultLabel.setText("Result: " + result);
            }
        });

        frame.setVisible(true);

    }
}
