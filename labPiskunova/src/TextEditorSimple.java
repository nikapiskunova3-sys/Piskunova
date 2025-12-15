import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEditorSimple {
    public static void main(String[] args) {
        JFrame mainWindow = new JFrame("Текстовый редактор");
        mainWindow.setSize(600, 450);
        mainWindow.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        JMenuItem saveItem = new JMenuItem("Сохранить");
        JMenuItem exitItem = new JMenuItem("Выход");
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Правка");
        JMenuItem copyItem = new JMenuItem("Копировать");
        JMenuItem cutItem = new JMenuItem("Вырезать");
        JMenuItem pasteItem = new JMenuItem("Вставить");
        editMenu.add(copyItem);
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        JMenu helpMenu = new JMenu("Справка");
        JMenuItem aboutItem = new JMenuItem("О программе");
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        mainWindow.setJMenuBar(menuBar);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea(15, 40);
        textArea.setText("Эта область предназначена для ввода текста.\nВы можете редактировать его здесь.");
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        JButton clearBtn = new JButton("Очистить текст");
        JButton addTextBtn = new JButton("Добавить текст");
        buttonPanel.add(clearBtn);
        buttonPanel.add(addTextBtn);

        centerPanel.add(scrollPane);
        centerPanel.add(buttonPanel);

        mainWindow.add(centerPanel, BorderLayout.CENTER);

        clearBtn.addActionListener(e -> textArea.setText(""));
        addTextBtn.addActionListener(e -> textArea.append("\n[Новый текст добавлен]"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(mainWindow, "Функция сохранения пока не реализована"));
        exitItem.addActionListener(e -> System.exit(0));
        copyItem.addActionListener(e -> textArea.copy());
        cutItem.addActionListener(e -> textArea.cut());
        pasteItem.addActionListener(e -> textArea.paste());
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(mainWindow, "Простой текстовый редактор v1.0"));

        mainWindow.setVisible(true);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
