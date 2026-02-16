package lab7;

import java.util.Date;

public class Task1 {

    public static void main(String[] args) {

        String fio = "Пискунова";
        String givenAt = "Задание выдано: 01.12.2025 17:00";

        Date finishTime = new Date(); // текущая дата

        System.out.println("Студент: " + fio);
        System.out.println(givenAt);
        System.out.println("Сдано: " + finishTime.toString());
    }
}
