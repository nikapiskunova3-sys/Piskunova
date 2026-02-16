import java.util.Scanner;

class DataFormatException extends Exception {
    public DataFormatException(String errorMessage) {
        super(errorMessage);
    }
}

public class ErrorHandler {

    private void validateInput(String data) throws DataFormatException {
        if (data == null || data.trim().length() == 0) {
            throw new DataFormatException("Пустые данные не допустимы");
        }

        if (data.length() > 20) {
            throw new DataFormatException("Слишком длинная строка (макс. 20 символов)");
        }

        if (!data.matches("[a-zA-Z0-9]+")) {
            throw new DataFormatException("Допускаются только буквы и цифры");
        }
    }

    public void execute() {
        Scanner scanTool = new Scanner(System.in);

        System.out.println("=== Валидатор данных ===");
        System.out.print("Введите текст для проверки: ");
        String userText = scanTool.nextLine();

        try {
            validateInput(userText);
            System.out.println("✓ Данные корректны: " + userText);

        } catch (DataFormatException formatError) {
            System.out.println("✗ Ошибка формата: " + formatError.getMessage());

        } catch (Exception unexpectedError) {
            System.out.println("✗ Непредвиденная ошибка");
            System.out.println("Детали: " + unexpectedError.toString());

        } finally {
            System.out.println("Проверка завершена");
            scanTool.close();
        }
    }

    public static void main(String[] args) {
        ErrorHandler handler = new ErrorHandler();
        handler.execute();
    }
}
