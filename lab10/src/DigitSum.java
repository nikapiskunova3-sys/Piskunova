import java.util.Scanner;

public class DigitSum {
    static int sum(int n) {
        return n == 0 ? 0 : n % 10 + sum(n / 10);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();
        System.out.println("Сумма цифр: " + sum(num));
        in.close();
    }
}