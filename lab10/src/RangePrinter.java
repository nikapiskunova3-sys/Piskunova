import java.util.Scanner;

public class RangePrinter {
    static void range(int from, int to) {
        System.out.print(from + " ");
        if (from == to) return;
        if (from < to) range(from + 1, to);
        else range(from - 1, to);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите A: ");
        int a = reader.nextInt();
        System.out.print("Введите B: ");
        int b = reader.nextInt();
        System.out.print("Диапазон: ");
        range(a, b);
        reader.close();
    }
}
