import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ПРОГРАММА ДЛЯ ЗАМЕНЫ СОДЕРЖИМОГО ФАЙЛА ===");

        while (true) {
            System.out.println("\nВыберите режим работы:");
            System.out.println("1. Полная замена содержимого файла");
            System.out.println("2. Замена определенных строк");
            System.out.println("3. Замена конкретного текста");
            System.out.println("4. Создание резервной копии перед заменой");
            System.out.println("0. Выход");

            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (choice == 0) {
                System.out.println("Выход из программы...");
                break;
            }

            System.out.print("Введите путь к файлу: ");
            String filePath = scanner.nextLine();
            File file = new File(filePath);

            if (!file.exists()) {
                System.out.println("Файл не существует. Создать новый? (да/нет)");
                String createNew = scanner.nextLine();

                if (!createNew.equalsIgnoreCase("да")) {
                    continue;
                }
            }

            switch (choice) {
                case 1 -> replaceEntireFile(file, scanner);
                case 2 -> replaceSpecificLines(file, scanner);
                case 3 -> replaceText(file, scanner);
                case 4 -> createBackupAndReplace(file, scanner);
                default -> System.out.println("Неверный выбор!");
            }
        }

        scanner.close();
    }

    private static void replaceEntireFile(File file, Scanner scanner) {
        System.out.println("\n=== ПОЛНАЯ ЗАМЕНА СОДЕРЖИМОГО ===");
        System.out.println("Введите новый текст (введите 'END' на отдельной строке для завершения):");

        List<String> newContent = new ArrayList<>();
        String line;

        while (true) {
            line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            newContent.add(line);
        }

        try {
            // Запись нового содержимого
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (int i = 0; i < newContent.size(); i++) {
                    writer.write(newContent.get(i));
                    if (i < newContent.size() - 1) {
                        writer.newLine();
                    }
                }
            }

            System.out.println("Файл успешно перезаписан!");
            System.out.println("Записано строк: " + newContent.size());

            // Показать содержимое
            System.out.print("\nПоказать содержимое файла? (да/нет): ");
            if (scanner.nextLine().equalsIgnoreCase("да")) {
                System.out.println("\nТекущее содержимое файла:");
                System.out.println("-".repeat(40));
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String fileLine;
                    while ((fileLine = reader.readLine()) != null) {
                        System.out.println(fileLine);
                    }
                }
                System.out.println("-".repeat(40));
            }

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    private static void replaceSpecificLines(File file, Scanner scanner) {
        System.out.println("\n=== ЗАМЕНА ОПРЕДЕЛЕННЫХ СТРОК ===");

        try {
            // Чтение текущего содержимого
            List<String> lines = Files.readAllLines(file.toPath());

            System.out.println("Текущее количество строк в файле: " + lines.size());

            System.out.print("Введите номер строки для замены (1-" + lines.size() + "): ");
            int lineNumber = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (lineNumber < 1 || lineNumber > lines.size()) {
                System.out.println("Неверный номер строки!");
                return;
            }

            System.out.println("Текущее содержимое строки " + lineNumber + ":");
            System.out.println("> " + lines.get(lineNumber - 1));
            System.out.print("Введите новое содержимое: ");
            String newLine = scanner.nextLine();

            // Замена строки
            lines.set(lineNumber - 1, newLine);

            // Запись обратно в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                for (int i = 0; i < lines.size(); i++) {
                    writer.write(lines.get(i));
                    if (i < lines.size() - 1) {
                        writer.newLine();
                    }
                }
            }

            System.out.println("Строка успешно заменена!");

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void replaceText(File file, Scanner scanner) {
        System.out.println("\n=== ЗАМЕНА КОНКРЕТНОГО ТЕКСТА ===");

        System.out.print("Введите текст для поиска: ");
        String searchText = scanner.nextLine();
        System.out.print("Введите текст для замены: ");
        String replaceText = scanner.nextLine();

        try {
            // Чтение файла
            String content = new String(Files.readAllBytes(file.toPath()));

            // Подсчет вхождений
            int count = 0;
            int index = 0;
            while ((index = content.indexOf(searchText, index)) != -1) {
                count++;
                index += searchText.length();
            }

            System.out.println("Найдено вхождений: " + count);

            if (count == 0) {
                System.out.println("Текст для замены не найден!");
                return;
            }

            System.out.print("Выполнить замену? (да/нет): ");
            String confirm = scanner.nextLine();

            if (!confirm.equalsIgnoreCase("да")) {
                return;
            }

            // Выполнение замены
            String newContent = content.replace(searchText, replaceText);

            // Запись обратно
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
                writer.write(newContent);
            }

            System.out.println("Замена выполнена успешно!");
            System.out.println("Заменено вхождений: " + count);

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }

    private static void createBackupAndReplace(File file, Scanner scanner) {
        System.out.println("\n=== СОЗДАНИЕ РЕЗЕРВНОЙ КОПИИ И ЗАМЕНА ===");

        try {
            // Создание имени для резервной копии
            String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File backupFile = new File(file.getParent(),
                    file.getName() + ".backup_" + timestamp);

            // Копирование файла
            Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Резервная копия создана: " + backupFile.getName());

            // Теперь выполняем замену
            System.out.println("\nТеперь выполним замену содержимого:");
            replaceEntireFile(file, scanner);

            System.out.println("\nРезервная копия сохранена в: " + backupFile.getAbsolutePath());
            System.out.println("При необходимости вы можете восстановить оригинальный файл из резервной копии.");

        } catch (IOException e) {
            System.out.println("Ошибка при создании резервной копии: " + e.getMessage());
        }
    }
}