package calculater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class design {
    
    JTextField textfield1, textfield2, textfield_result;
    JFrame jframe = new JFrame();

    public void Jtextfied(String massege, int x, int y, int width, int height, int xx, int yy, int widthx, int heighty) {
        JLabel label = new JLabel();
        label.setText(massege);
        JTextField textfield = new JTextField();
        label.setBounds(xx, yy, widthx, heighty);
        textfield.setBounds(x, y, width, height);

        jframe.add(label);
        jframe.add(textfield);

        jframe.setLayout(null);
        jframe.setSize(500, 400);
        jframe.setVisible(true);

        if (massege.equals("enter first number")) {
            textfield1 = textfield;
        } else if (massege.equals("enter 2nd number")) {
            textfield2 = textfield;
        } else if (massege.equals("your result")) {
            textfield_result = textfield;
        }
    }

    public void button(String symbol, int x, int y, int width, int height) {
        JButton button = new JButton();
        button.setText(symbol);
        button.setBounds(x, y, width, height);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(textfield1.getText());
                    int num1 = Integer.parseInt(textfield2.getText());
                    int result = 0;

                    switch (symbol) {
                        case "+":
                            result = num + num1;
                            break;
                        case "-":
                            result = num - num1;
                            break;
                        case "*":
                            result = num * num1;
                            break;
                        case "/":
                            if (num1 == 0) {
                                textfield_result.setText("Error: Div by 0");
                                return;
                            }
                            result = num / num1;
                            break;
                    }
                    textfield_result.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    textfield_result.setText("Invalid input");
                }
            }
        });

        jframe.add(button);
    }

    public static void main(String[] args) {
        design obj = new design();
        obj.Jtextfied("enter first number", 100, 50, 300, 30, 100, 20, 300, 30);
        obj.Jtextfied("enter 2nd number", 100, 110, 300, 30, 100, 80, 300, 30);
        obj.Jtextfied("your result", 100, 165, 300, 30, 100, 135, 300, 30);

//        obj.button("+", 100, 220, 50, 30);
//        obj.button("-", 170, 220, 50, 30);
//        obj.button("*", 245, 220, 50, 30);
//        obj.button("/", 320, 220, 50, 30);
   }
}
