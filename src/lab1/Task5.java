package lab1;

import java.util.Scanner;

public class Task5 {
    Scanner scanner = new Scanner(System.in);

    public void task5() {
        System.out.println("Введите число, факториал которого вы хотите найти");
        int userNumber = scanner.nextInt();
        int factorial = 1;

        if (userNumber < 0) {
            System.out.println("Число должно быть больше 1!");
        } else {

            for (int i = 1; i <= userNumber; i ++) {
                factorial *= i;
            }
        }
        System.out.println("Факториал числа : " + userNumber + " = " + factorial);
    }
}
