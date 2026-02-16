import java.util.Scanner;

public class MathOperations {

    public void divideNumbers() {
        Scanner reader = new Scanner(System.in);

        System.out.println("=== Простое деление чисел ===");
        System.out.print("Введите делимое: ");
        int dividend = reader.nextInt();
        System.out.print("Введите делитель: ");
        int divisor = reader.nextInt();

        try {
            int quotient = dividend / divisor;
            System.out.printf("Результат: %d / %d = %d%n", dividend, divisor, quotient);

        } catch (ArithmeticException mathError) {
            System.out.println("Математическая ошибка: " + mathError.getMessage());
            System.out.println("Деление на ноль не поддерживается");

        } finally {
            System.out.println("Вычисление завершено");
            reader.close();
        }
    }

    public static void main(String[] args) {
        MathOperations calculator = new MathOperations();
        calculator.divideNumbers();
    }
}