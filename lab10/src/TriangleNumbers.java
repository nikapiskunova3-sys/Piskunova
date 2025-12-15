import java.util.Scanner;

public class TriangleNumbers {
    static void triangle(int num, int count, int limit) {
        if (limit < 1) return;
        System.out.print(num + " ");
        if (count < num) {
            triangle(num, count + 1, limit - 1);
        } else {
            triangle(num + 1, 1, limit - 1);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Сколько элементов вывести? ");
        int n = input.nextInt();
        System.out.print("Треугольная последовательность: ");
        triangle(1, 1, n);
        input.close();
    }
}