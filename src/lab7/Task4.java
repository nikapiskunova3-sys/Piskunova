package lab7;

import java.util.Calendar;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Год: ");
        int y = input.nextInt();

        System.out.print("Месяц (1-12): ");
        int m = input.nextInt();

        System.out.print("День: ");
        int d = input.nextInt();

        System.out.print("Часы: ");
        int h = input.nextInt();

        System.out.print("Минуты: ");
        int min = input.nextInt();

        Calendar c = Calendar.getInstance();
        c.set(y, m - 1, d, h, min);

        System.out.println("Calendar: " + c.getTime());
        System.out.println("Date:     " + c.getTime());
    }
}

