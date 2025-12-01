package lab7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String fullName;
    private Date birthday;

    public Student(String fullName, Date birthday) {
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public String birthToString(String style) {
        DateFormat f = new SimpleDateFormat(style);
        return f.format(birthday);
    }

    @Override
    public String toString() {
        return "Имя: " + fullName + ", родился: " + birthToString("dd.MM.yyyy");
    }
}

