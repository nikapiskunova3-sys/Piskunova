package lab7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        System.out.println("Введите дату (dd/MM/yyyy HH:mm):");
        String text = scanner.nextLine();

        try {
            Date user = df.parse(text);
            Date now = new Date();

            System.out.println("Текущая:   " + df.format(now));
            System.out.println("Введенная: " + df.format(user));

            if (now.equals(user)) {
                System.out.println("Даты одинаковые.");
            } else if (user.before(now)) {
                System.out.println("Введенная дата раньше текущей.");
            } else {
                System.out.println("Введенная дата позже текущей.");
            }

        } catch (Exception e) {
            System.out.println("Ошибка ввода даты.");
        }
    }
}

