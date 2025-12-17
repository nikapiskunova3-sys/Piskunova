import java.util.Scanner;
import java.util.InputMismatchException;

class BusinessRuleException extends Exception {
    public BusinessRuleException(String rule, String details) {
        super("Нарушение правила '" + rule + "': " + details);
    }
}

public class ExceptionSystem {

    private Scanner systemScanner = new Scanner(System.in);

    private void optionOne() {
        System.out.println("\n--- Опция 1: Арифметические операции ---");

        try {
            System.out.print("Введите первое число: ");
            int num1 = systemScanner.nextInt();

            System.out.print("Введите второе число: ");
            int num2 = systemScanner.nextInt();

            System.out.print("Выберите операцию (+, -, *, /): ");
            char operation = systemScanner.next().charAt(0);

            int result;
            switch (operation) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестная операция: " + operation);
            }

            System.out.printf("Результат: %d %c %d = %d%n", num1, operation, num2, result);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: ожидалось число");
            systemScanner.nextLine(); // Очистка буфера

        } catch (ArithmeticException e) {
            System.out.println("Математическая ошибка: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка операции: " + e.getMessage());

        } finally {
            System.out.println("Арифметическая операция завершена");
        }
    }

    private void optionTwo() throws BusinessRuleException {
        System.out.println("\n--- Опция 2: Проверка бизнес-правил ---");

        System.out.print("Введите сумму транзакции (1-10000): ");
        int amount = systemScanner.nextInt();

        System.out.print("Введите код валюты (RUB, USD, EUR): ");
        String currency = systemScanner.next().toUpperCase();

        // Проверка бизнес-правил
        if (amount < 1) {
            throw new BusinessRuleException("Минимальная сумма", "Сумма должна быть не менее 1");
        }

        if (amount > 10000) {
            throw new BusinessRuleException("Максимальная сумма", "Сумма не должна превышать 10000");
        }

        if (!currency.equals("RUB") && !currency.equals("USD") && !currency.equals("EUR")) {
            throw new BusinessRuleException("Поддерживаемая валюта", "Допустимы только RUB, USD, EUR");
        }

        System.out.printf("✓ Транзакция на %d %s одобрена%n", amount, currency);
    }

    private void optionThree() {
        System.out.println("\n--- Опция 3: Работа с массивами ---");

        try {
            System.out.print("Введите размер массива: ");
            int size = systemScanner.nextInt();

            if (size <= 0) {
                throw new NegativeArraySizeException("Размер массива должен быть положительным");
            }

            int[] array = new int[size];

            System.out.print("Введите индекс для записи (0-" + (size-1) + "): ");
            int index = systemScanner.nextInt();

            System.out.print("Введите значение для записи: ");
            int value = systemScanner.nextInt();

            array[index] = value;
            System.out.println("✓ Значение " + value + " записано в ячейку " + index);

        } catch (NegativeArraySizeException e) {
            System.out.println("Ошибка создания массива: " + e.getMessage());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса: выход за границы массива");

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода: ожидалось число");
            systemScanner.nextLine();
        }
    }

    public void runSystem() {
        boolean running = true;

        System.out.println("=== Комплексная система обработки исключений ===");

        while (running) {
            System.out.println("\nМЕНЮ:");
            System.out.println("1. Арифметические операции");
            System.out.println("2. Проверка бизнес-правил");
            System.out.println("3. Работа с массивами");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            try {
                int choice = systemScanner.nextInt();

                switch (choice) {
                    case 1:
                        optionOne();
                        break;

                    case 2:
                        try {
                            optionTwo();
                        } catch (BusinessRuleException e) {
                            System.out.println("Бизнес-ошибка: " + e.getMessage());
                        }
                        break;

                    case 3:
                        optionThree();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Завершение работы системы...");
                        break;

                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число от 0 до 3");
                systemScanner.nextLine(); // Очистка буфера
            }
        }

        systemScanner.close();
        System.out.println("Система завершила работу");
    }

    public static void main(String[] args) {
        ExceptionSystem system = new ExceptionSystem();
        system.runSystem();
    }
}
