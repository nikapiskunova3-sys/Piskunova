import java.util.LinkedList;
import java.util.List;

class ExaminationResult implements Comparable<ExaminationResult> {
    private final String examinee;
    private final int totalPoints;

    public ExaminationResult(String examinee, int totalPoints) {
        this.examinee = examinee;
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    @Override
    public int compareTo(ExaminationResult other) {
        // Сортировка по количеству баллов (по возрастанию)
        return Integer.compare(this.totalPoints, other.totalPoints);
    }

    @Override
    public String toString() {
        return String.format("%-15s → %3d баллов", examinee, totalPoints);
    }
}

public class StudentListMerger {

    public static List<ExaminationResult> mergeSortResults(List<ExaminationResult> results) {
        if (results.size() <= 1) {
            return new LinkedList<>(results);
        }

        int middle = results.size() / 2;
        List<ExaminationResult> leftPart = new LinkedList<>(results.subList(0, middle));
        List<ExaminationResult> rightPart = new LinkedList<>(results.subList(middle, results.size()));

        leftPart = mergeSortResults(leftPart);
        rightPart = mergeSortResults(rightPart);

        return combineSortedLists(leftPart, rightPart);
    }

    private static List<ExaminationResult> combineSortedLists(
            List<ExaminationResult> left, List<ExaminationResult> right) {

        List<ExaminationResult> combined = new LinkedList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                combined.add(left.get(leftIndex));
                leftIndex++;
            } else {
                combined.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            combined.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            combined.add(right.get(rightIndex));
            rightIndex++;
        }

        return combined;
    }

    public static void main(String[] args) {
        List<ExaminationResult> groupA = List.of(
                new ExaminationResult("Горбачев", 87),
                new ExaminationResult("Ларина", 95),
                new ExaminationResult("Миронов", 79),
                new ExaminationResult("Савельева", 91)
        );

        List<ExaminationResult> groupB = List.of(
                new ExaminationResult("Жуков", 89),
                new ExaminationResult("Мельникова", 94),
                new ExaminationResult("Орлов", 84),
                new ExaminationResult("Романова", 88)
        );

        System.out.println("=== РЕЗУЛЬТАТЫ ЭКЗАМЕНОВ ===");
        System.out.println("\nГруппа A:");
        System.out.println("----------------");
        for (ExaminationResult result : groupA) {
            System.out.println(result);
        }

        System.out.println("\nГруппа B:");
        System.out.println("----------------");
        for (ExaminationResult result : groupB) {
            System.out.println(result);
        }

        // Объединение списков
        List<ExaminationResult> allResults = new LinkedList<>();
        allResults.addAll(groupA);
        allResults.addAll(groupB);

        // Сортировка слиянием
        List<ExaminationResult> sortedResults = mergeSortResults(allResults);

        System.out.println("\nОБЪЕДИНЕННЫЙ И ОТСОРТИРОВАННЫЙ СПИСОК:");
        System.out.println("(по возрастанию баллов)");
        System.out.println("----------------");
        for (ExaminationResult result : sortedResults) {
            System.out.println(result);
        }

        System.out.println("\nИтоговая статистика:");
        System.out.println("Всего студентов: " + sortedResults.size());
        System.out.println("Лучший результат: " + sortedResults.get(sortedResults.size() - 1));
        System.out.println("Худший результат: " + sortedResults.get(0));
    }
}
