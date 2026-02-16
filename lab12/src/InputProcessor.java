import java.util.Scanner;
import java.util.InputMismatchException;

public class InputProcessor {

    public void processUserInput() {
        Scanner inputDevice = new Scanner(System.in);

        System.out.println("=== Обработчик пользовательского ввода ===");

        try {
            System.out.print("Введите целое число (не ноль): ");
            int userNumber = inputDevice.nextInt();

            if (userNumber == 0) {
                System.out.println("Предупреждение: введен ноль, результат может быть некорректным");
            }

            double calculation = 50.0 / userNumber;
            System.out.println("50.0 / " + userNumber + " = " + calculation);

        } catch (InputMismatchException formatError) {
            System.out.println("Ошибка формата! Ожидалось целое число");
            System.out.println("Введены некорректные символы");

        } catch (ArithmeticException calculationError) {
            System.out.println("Вычислительная ошибка: " + calculationError.getMessage());

        } catch (Exception generalError) {
            System.out.println("Неизвестная ошибка типа: " + generalError.getClass().getName());

        } finally {
            System.out.println("--- Конец обработки ---");
            inputDevice.close();
        }
    }

    public static void main(String[] args) {
        InputProcessor processor = new InputProcessor();
        processor.processUserInput();
    }
}
