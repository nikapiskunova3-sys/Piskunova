import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MathSolverGUI {
    public static void main(String[] args) {
        JFrame window = new JFrame("Арифметические операции");
        window.setLayout(new GridLayout(5, 2, 10, 10));
        window.setSize(350, 250);

        JLabel label1 = new JLabel("Первое число:");
        JTextField field1 = new JTextField();
        JLabel label2 = new JLabel("Второе число:");
        JTextField field2 = new JTextField();

        JButton plusBtn = new JButton("Сложение (+)");
        JButton minusBtn = new JButton("Вычитание (-)");
        JButton multBtn = new JButton("Умножение (×)");
        JButton divBtn = new JButton("Деление (÷)");
        JLabel resultLabel = new JLabel("Результат: ");

        window.add(label1);
        window.add(field1);
        window.add(label2);
        window.add(field2);
        window.add(plusBtn);
        window.add(minusBtn);
        window.add(multBtn);
        window.add(divBtn);
        window.add(new JLabel(""));
        window.add(resultLabel);

        ActionListener calcHandler = new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    double a = Double.parseDouble(field1.getText());
                    double b = Double.parseDouble(field2.getText());
                    double res = 0;
                    String op = "";

                    if (ev.getSource() == plusBtn) {
                        res = a + b;
                        op = "Сумма";
                    } else if (ev.getSource() == minusBtn) {
                        res = a - b;
                        op = "Разность";
                    } else if (ev.getSource() == multBtn) {
                        res = a * b;
                        op = "Произведение";
                    } else if (ev.getSource() == divBtn) {
                        if (b == 0) throw new ArithmeticException();
                        res = a / b;
                        op = "Частное";
                    }

                    resultLabel.setText(String.format("%s = %.2f", op, res));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(window, "Ошибка ввода чисел", "Ошибка", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(window, "Деление на ноль невозможно", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        };

        plusBtn.addActionListener(calcHandler);
        minusBtn.addActionListener(calcHandler);
        multBtn.addActionListener(calcHandler);
        divBtn.addActionListener(calcHandler);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}