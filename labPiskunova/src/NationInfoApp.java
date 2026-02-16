import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NationInfoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Информация о странах");
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 250);

        String[] nations = {"Выберите страну", "Россия", "США", "Германия", "Япония", "Франция"};
        JComboBox<String> selector = new JComboBox<>(nations);

        JTextPane infoPane = new JTextPane();
        infoPane.setEditable(false);
        infoPane.setContentType("text/html");

        frame.add(selector, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoPane), BorderLayout.CENTER);

        selector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = (String) selector.getSelectedItem();
                String info = "<html><body style='padding:10px;'>";

                switch (choice) {
                    case "Россия":
                        info += "<h3>Россия</h3>Столица: Москва<br>Население: ~146 млн<br>Язык: русский";
                        break;
                    case "США":
                        info += "<h3>США</h3>Столица: Вашингтон<br>Население: ~331 млн<br>Язык: английский";
                        break;
                    case "Германия":
                        info += "<h3>Германия</h3>Столица: Берлин<br>Население: ~83 млн<br>Язык: немецкий";
                        break;
                    case "Япония":
                        info += "<h3>Япония</h3>Столица: Токио<br>Население: ~125 млн<br>Язык: японский";
                        break;
                    case "Франция":
                        info += "<h3>Франция</h3>Столица: Париж<br>Население: ~67 млн<br>Язык: французский";
                        break;
                    default:
                        info += "Пожалуйста, выберите страну из списка";
                }
                info += "</body></html>";
                infoPane.setText(info);
            }
        });

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
