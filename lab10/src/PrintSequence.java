import java.util.Scanner;

public class PrintSequence {
    static void print(int current, int max) {
        System.out.print(current + " ");
        if (current < max) print(current + 1, max);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scan.nextInt();
        System.out.print("Последовательность: ");
        print(1, n);
        scan.close();
    }
}