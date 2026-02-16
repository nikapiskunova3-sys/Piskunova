import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator {
    private JFrame calcFrame;
    private JTextField display;
    private double firstOperand = 0;
    private String currentOperator = "";
    private boolean startNewNumber = true;

    public SimpleCalculator() {
        calcFrame = new JFrame("Калькулятор");
        calcFrame.setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Monospaced", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        calcFrame.add(display, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 3, 3));

        String[] buttonLabels = {
                "C", "⌫", "%", "÷",
                "7", "8", "9", "×",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "±", "0", ".", "="
        };

        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.PLAIN, 18));
            btn.addActionListener(new ButtonAction());
            buttonsPanel.add(btn);
        }

        calcFrame.add(buttonsPanel, BorderLayout.CENTER);
        calcFrame.setSize(350, 450);
        calcFrame.setVisible(true);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if ("0123456789".contains(cmd)) {
                if (startNewNumber) {
                    display.setText(cmd);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + cmd);
                }
            }
            else if (".".equals(cmd)) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                    startNewNumber = false;
                }
            }
            else if ("C".equals(cmd)) {
                display.setText("0");
                firstOperand = 0;
                currentOperator = "";
                startNewNumber = true;
            }
            else if ("⌫".equals(cmd)) {
                String text = display.getText();
                if (text.length() > 1) {
                    display.setText(text.substring(0, text.length() - 1));
                } else {
                    display.setText("0");
                    startNewNumber = true;
                }
            }
            else if ("±".equals(cmd)) {
                double val = Double.parseDouble(display.getText());
                display.setText(String.valueOf(-val));
            }
            else if ("+-×÷".contains(cmd)) {
                firstOperand = Double.parseDouble(display.getText());
                currentOperator = cmd;
                startNewNumber = true;
            }
            else if ("=".equals(cmd)) {
                double secondOperand = Double.parseDouble(display.getText());
                double result = 0;

                switch (currentOperator) {
                    case "+": result = firstOperand + secondOperand; break;
                    case "-": result = firstOperand - secondOperand; break;
                    case "×": result = firstOperand * secondOperand; break;
                    case "÷":
                        if (secondOperand != 0) {
                            result = firstOperand / secondOperand;
                        } else {
                            display.setText("Ошибка");
                            return;
                        }
                        break;
                }

                display.setText(String.valueOf(result));
                currentOperator = "";
                startNewNumber = true;
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
