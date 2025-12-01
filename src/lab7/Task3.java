package lab7;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task3 {

    public static void main(String[] args) {

        try {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            Date birth = f.parse("20-01-2005");

            Student s = new Student("Пискунова Вероника", birth);

            System.out.println(s);
            System.out.println("Коротко:  " + s.birthToString("dd.MM.yy"));
            System.out.println("Средне:   " + s.birthToString("dd MMM yyyy"));
            System.out.println("Полностью:" + s.birthToString("dd MMMM yyyy"));

        } catch (Exception ex) {
            System.out.println("Ошибка обработки даты.");
        }
    }
}

