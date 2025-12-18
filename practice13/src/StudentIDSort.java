import java.util.ArrayList;
import java.util.List;

class UniversityStudent {
    private final int studentID;
    private final String fullName;
    private final double averageScore;

    public UniversityStudent(int studentID, String fullName, double averageScore) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.averageScore = averageScore;
    }

    public int getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return String.format("Студент #%d: %s (средний балл: %.1f)",
                studentID, fullName, averageScore);
    }

    // Внутренний компаратор для сравнения по ID
    public static int compareByID(UniversityStudent a, UniversityStudent b) {
        return Integer.compare(a.studentID, b.studentID);
    }
}

public class StudentIDSort {

    public static void sortByInsertion(List<UniversityStudent> students) {
        for (int currentIndex = 1; currentIndex < students.size(); currentIndex++) {
            UniversityStudent currentStudent = students.get(currentIndex);
            int previousIndex = currentIndex - 1;

            while (previousIndex >= 0 &&
                    UniversityStudent.compareByID(students.get(previousIndex), currentStudent) > 0) {
                students.set(previousIndex + 1, students.get(previousIndex));
                previousIndex--;
            }
            students.set(previousIndex + 1, currentStudent);
        }
    }

    public static void main(String[] args) {
        List<UniversityStudent> studentList = new ArrayList<>();

        studentList.add(new UniversityStudent(417, "Кузнецов Алексей", 4.3));
        studentList.add(new UniversityStudent(402, "Морозова Анна", 4.7));
        studentList.add(new UniversityStudent(409, "Волков Дмитрий", 3.9));
        studentList.add(new UniversityStudent(401, "Соколова Мария", 4.5));
        studentList.add(new UniversityStudent(415, "Лебедев Иван", 4.1));
        studentList.add(new UniversityStudent(408, "Зайцева Ольга", 4.2));
        studentList.add(new UniversityStudent(403, "Григорьев Павел", 3.8));

        System.out.println("=== ИСХОДНЫЙ СПИСОК СТУДЕНТОВ ===");
        for (UniversityStudent student : studentList) {
            System.out.println(student);
        }

        sortByInsertion(studentList);

        System.out.println("\n=== СПИСОК ПОСЛЕ СОРТИРОВКИ ВСТАВКАМИ ===");
        System.out.println("(Отсортировано по номеру студенческого билета)");
        for (UniversityStudent student : studentList) {
            System.out.println(student);
        }
    }
}