import java.util.Arrays;

class AcademicRecord {
    private final String studentName;
    private final double gradePoint;

    public AcademicRecord(String studentName, double gradePoint) {
        this.studentName = studentName;
        this.gradePoint = gradePoint;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    @Override
    public String toString() {
        return String.format("%-20s | GPA: %.2f", studentName, gradePoint);
    }
}

class GradeComparator implements java.util.Comparator<AcademicRecord> {
    @Override
    public int compare(AcademicRecord record1, AcademicRecord record2) {
        // Сортировка по убыванию среднего балла
        return Double.compare(record2.getGradePoint(), record1.getGradePoint());
    }
}

public class GradePointSorter {

    public static void quickSortByGrade(AcademicRecord[] records, int start, int end) {
        if (start < end) {
            int partitionIndex = partitionRecords(records, start, end);
            quickSortByGrade(records, start, partitionIndex - 1);
            quickSortByGrade(records, partitionIndex + 1, end);
        }
    }

    private static int partitionRecords(AcademicRecord[] records, int start, int end) {
        AcademicRecord pivot = records[end];
        int smallerElementIndex = start - 1;

        for (int j = start; j < end; j++) {
            if (records[j].getGradePoint() >= pivot.getGradePoint()) {
                smallerElementIndex++;
                swapElements(records, smallerElementIndex, j);
            }
        }

        swapElements(records, smallerElementIndex + 1, end);
        return smallerElementIndex + 1;
    }

    private static void swapElements(AcademicRecord[] array, int index1, int index2) {
        AcademicRecord temporary = array[index1];
        array[index1] = array[index2];
        array[index2] = temporary;
    }

    public static void main(String[] args) {
        AcademicRecord[] academicRecords = {
                new AcademicRecord("Беляев Максим", 4.8),
                new AcademicRecord("Ковалева Екатерина", 4.1),
                new AcademicRecord("Федоров Артем", 4.9),
                new AcademicRecord("Дмитриева София", 4.3),
                new AcademicRecord("Новиков Кирилл", 3.7),
                new AcademicRecord("Андреева Виктория", 4.6),
                new AcademicRecord("Тихонов Александр", 4.4),
                new AcademicRecord("Семенова Анастасия", 4.0)
        };

        System.out.println("=== СПИСОК УСПЕВАЕМОСТИ СТУДЕНТОВ ===");
        System.out.println("До сортировки:");
        System.out.println("----------------------------------------");
        for (AcademicRecord record : academicRecords) {
            System.out.println(record);
        }

        quickSortByGrade(academicRecords, 0, academicRecords.length - 1);

        System.out.println("\nПосле сортировки (по убыванию GPA):");
        System.out.println("----------------------------------------");
        for (AcademicRecord record : academicRecords) {
            System.out.println(record);
        }

        // Альтернативная сортировка с использованием компаратора
        System.out.println("\n=== ВАРИАНТ С ИСПОЛЬЗОВАНИЕМ COMPARATOR ===");
        AcademicRecord[] recordsCopy = Arrays.copyOf(academicRecords, academicRecords.length);
        Arrays.sort(recordsCopy, new GradeComparator());

        for (AcademicRecord record : recordsCopy) {
            System.out.println(record);
        }
    }
}