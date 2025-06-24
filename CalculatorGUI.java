package calculater;

import javax.swing.*;
import java.awt.event.*;

public class CalculatorGUI {
    JFrame frame;
    JTextField textField;
    String input = "";

    public CalculatorGUI() {
        frame = new JFrame("Simple Calculator");
        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setBounds(30, 30, 320, 50);
        frame.add(textField);

        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        int x = 30, y = 100;
        for (int i = 0; i < buttons.length; i++) {
            JButton btn = new JButton(buttons[i]);
            btn.setBounds(x, y, 70, 50);
            frame.add(btn);

            btn.addActionListener(new ButtonClick());
            
            x += 80;
            if ((i + 1) % 4 == 0) {
                x = 30;
                y += 60;
            }
        }

        frame.setVisible(true);
    }

    class ButtonClick implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String value = ((JButton)e.getSource()).getText();

            if (value.equals("=")) {
                try {
                    input = textField.getText();
                    int result = evaluate(input);
                    textField.setText(String.valueOf(result));
                } catch (Exception ex) {
                    textField.setText("Error");
                }
            } else if (value.equals("C")) {
                input = "";
                textField.setText("");
            } else {
                input += value;
                textField.setText(input);
            }
        }
    }

    // Simple expression evaluator (only works with +, -, *, /)
    public int evaluate(String expr) {
        String[] tokens;
        if (expr.contains("+")) {
            tokens = expr.split("\\+");
            return Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[1]);
        } else if (expr.contains("-")) {
            tokens = expr.split("-");
            return Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[1]);
        } else if (expr.contains("*")) {
            tokens = expr.split("\\*");
            return Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[1]);
        } else if (expr.contains("/")) {
            tokens = expr.split("/");
            int divisor = Integer.parseInt(tokens[1]);
            if (divisor == 0) throw new ArithmeticException();
            return Integer.parseInt(tokens[0]) / divisor;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
