import java.util.Scanner;

public class NumberCounter {
    static int find(int k, int s, int pos, int sum) {
        if (pos == k) return sum == s ? 1 : 0;
        int total = 0;
        int start = (pos == 0) ? 1 : 0;
        for (int digit = start; digit <= 9; digit++) {
            if (sum + digit <= s) {
                total += find(k, s, pos + 1, sum + digit);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество цифр (k): ");
        int k = sc.nextInt();
        System.out.print("Сумма цифр (s): ");
        int s = sc.nextInt();
        System.out.println("Количество чисел: " + find(k, s, 0, 0));
        sc.close();
    }
}
