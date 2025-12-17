import java.util.Scanner;

class ProcessingException extends Exception {
    public ProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class ExceptionChain {

    private String fetchData(int id) throws ProcessingException {
        if (id <= 0) {
            throw new IllegalArgumentException("ID должен быть положительным");
        }

        if (id > 1000) {
            throw new RuntimeException("ID превышает допустимый лимит");
        }

        if (id == 404) {
            throw new NullPointerException("Данные для ID " + id + " не найдены");
        }

        return "Данные для ID #" + id;
    }

    private void processRequest(int requestId) throws ProcessingException, IllegalArgumentException, RuntimeException {
        String result = fetchData(requestId);
        System.out.println("Успешно: " + result);

    }

    public void handleUserRequest() {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("=== Система обработки запросов ===");
        System.out.print("Введите ID запроса (1-1500): ");

        try {
            int userRequestId = inputScanner.nextInt();
            processRequest(userRequestId);

        } catch (ProcessingException chainError) {
            System.out.println("\nОсновная ошибка: " + chainError.getMessage());

            if (chainError.getCause() != null) {
                System.out.println("Причина: " + chainError.getCause().getClass().getSimpleName());
                System.out.println("Детали причины: " + chainError.getCause().getMessage());
            }

        } catch (Exception inputError) {
            System.out.println("Ошибка ввода: " + inputError.getMessage());

        } finally {
            System.out.println("\nОбработка запроса завершена");
            inputScanner.close();
        }
    }

    public static void main(String[] args) {
        ExceptionChain handler = new ExceptionChain();
        handler.handleUserRequest();
    }
}