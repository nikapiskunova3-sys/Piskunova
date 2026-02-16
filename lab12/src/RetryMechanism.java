import java.util.Random;
import java.util.Scanner;

class NetworkException extends Exception {
    public NetworkException(String message) {
        super("Сетевая ошибка: " + message);
    }
}

class DatabaseException extends Exception {
    public DatabaseException(String message) {
        super("Ошибка базы данных: " + message);
    }
}

public class RetryMechanism {

    private Random randomGenerator = new Random();

    private void simulateNetworkOperation() throws NetworkException {
        int chance = randomGenerator.nextInt(100);

        if (chance < 30) {
            throw new NetworkException("Таймаут соединения");
        } else if (chance < 50) {
            throw new NetworkException("Сервер недоступен");
        }

        System.out.println("✓ Сетевая операция выполнена успешно");
    }

    private void simulateDatabaseOperation() throws DatabaseException {
        int chance = randomGenerator.nextInt(100);

        if (chance < 20) {
            throw new DatabaseException("Блокировка таблицы");
        } else if (chance < 40) {
            throw new DatabaseException("Ошибка уникальности");
        }

        System.out.println("✓ Операция с базой данных выполнена");
    }

    public void performOperationsWithRetry() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("=== Система с повторными попытками ===");
        System.out.print("Введите максимальное количество попыток (2-10): ");

        int maxAttempts = userInput.nextInt();
        int attemptCount = 0;
        boolean networkSuccess = false;
        boolean databaseSuccess = false;

        // Попытки для сетевой операции
        System.out.println("\n[1] Выполнение сетевой операции:");
        while (attemptCount < maxAttempts && !networkSuccess) {
            attemptCount++;
            System.out.print("  Попытка " + attemptCount + "... ");

            try {
                simulateNetworkOperation();
                networkSuccess = true;
            } catch (NetworkException netError) {
                System.out.println("Ошибка: " + netError.getMessage());

                if (attemptCount < maxAttempts) {
                    System.out.println("  Повтор через 1 секунду...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        System.out.println("  Прервано ожидание");
                    }
                }
            }
        }

        // Сброс счетчика для следующей операции
        attemptCount = 0;

        // Попытки для операции с БД
        System.out.println("\n[2] Выполнение операции с базой данных:");
        while (attemptCount < maxAttempts && !databaseSuccess) {
            attemptCount++;
            System.out.print("  Попытка " + attemptCount + "... ");

            try {
                simulateDatabaseOperation();
                databaseSuccess = true;
            } catch (DatabaseException dbError) {
                System.out.println("Ошибка: " + dbError.getMessage());

                if (attemptCount < maxAttempts) {
                    System.out.println("  Повтор через 2 секунды...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        System.out.println("  Прервано ожидание");
                    }
                }
            }
        }

        // Итоговый отчет
        System.out.println("\n=== ИТОГ ===");
        System.out.println("Сетевая операция: " + (networkSuccess ? "УСПЕХ" : "НЕУДАЧА"));
        System.out.println("Операция с БД: " + (databaseSuccess ? "УСПЕХ" : "НЕУДАЧА"));

        if (networkSuccess && databaseSuccess) {
            System.out.println("✓ Все операции выполнены успешно!");
        } else {
            System.out.println("✗ Некоторые операции завершились ошибкой");
        }

        userInput.close();
    }

    public static void main(String[] args) {
        RetryMechanism system = new RetryMechanism();
        system.performOperationsWithRetry();
    }
}
