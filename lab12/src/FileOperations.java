import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public void manageFiles() {
        Scanner consoleReader = new Scanner(System.in);

        System.out.println("=== Работа с файлами ===");
        System.out.print("Введите имя файла для чтения: ");
        String fileName = consoleReader.nextLine();

        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            System.out.println("\nСодержимое файла:");
            System.out.println("=================");

            String fileLine;
            int lineCount = 0;

            while ((fileLine = fileReader.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + fileLine);
            }

            System.out.println("\nВсего строк: " + lineCount);

        } catch (FileNotFoundException missingFile) {
            System.out.println("Ошибка: Файл '" + fileName + "' не найден");
            System.out.println("Убедитесь, что файл существует в текущей директории");

        } catch (IOException ioProblem) {
            System.out.println("Ошибка ввода/вывода: " + ioProblem.getMessage());

        } catch (SecurityException securityIssue) {
            System.out.println("Проблема безопасности: нет доступа к файлу");

        } catch (Exception generalIssue) {
            System.out.println("Общая ошибка: " + generalIssue.getClass().getName());

        } finally {
            System.out.println("\nЗавершение работы с файлами...");

            try {
                if (fileReader != null) {
                    fileReader.close();
                    System.out.println("Файл успешно закрыт");
                }
            } catch (IOException closeError) {
                System.out.println("Ошибка при закрытии файла: " + closeError.getMessage());
            }

            consoleReader.close();
        }
    }

    public static void main(String[] args) {
        FileOperations fileManager = new FileOperations();
        fileManager.manageFiles();
    }
}
