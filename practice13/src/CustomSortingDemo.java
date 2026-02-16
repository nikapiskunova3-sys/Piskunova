import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Класс с пользовательской логикой сравнения
class SoftwareProduct implements Comparable<SoftwareProduct> {
    private final String productName;
    private final String developer;
    private final int releaseYear;
    private final double userRating;

    public SoftwareProduct(String productName, String developer,
                           int releaseYear, double userRating) {
        this.productName = productName;
        this.developer = developer;
        this.releaseYear = releaseYear;
        this.userRating = userRating;
    }

    // Сортировка по разработчику (A-Z), затем по рейтингу (по убыванию)
    @Override
    public int compareTo(SoftwareProduct other) {
        int developerComparison = this.developer.compareTo(other.developer);
        if (developerComparison != 0) {
            return developerComparison;
        }
        // Обратный порядок для рейтинга (высокий рейтинг сначала)
        return Double.compare(other.userRating, this.userRating);
    }

    @Override
    public String toString() {
        return String.format("%-25s | Разработчик: %-12s | Год: %d | ★ %.1f/5.0",
                productName, developer, releaseYear, userRating);
    }
}

// Еще один класс с альтернативной логикой
class ProjectTask implements Comparable<ProjectTask> {
    private final String taskName;
    private final String project;
    private final int priority;       // 1-высокий, 2-средний, 3-низкий
    private final int estimatedHours;

    public ProjectTask(String taskName, String project,
                       int priority, int estimatedHours) {
        this.taskName = taskName;
        this.project = project;
        this.priority = priority;
        this.estimatedHours = estimatedHours;
    }

    // Сортировка по приоритету, затем по оценке времени
    @Override
    public int compareTo(ProjectTask other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return Integer.compare(this.estimatedHours, other.estimatedHours);
    }

    private String getPriorityText() {
        return switch (priority) {
            case 1 -> "ВЫСОКИЙ";
            case 2 -> "СРЕДНИЙ";
            case 3 -> "НИЗКИЙ";
            default -> "НЕИЗВЕСТНО";
        };
    }

    @Override
    public String toString() {
        return String.format("[%s] %-30s | Проект: %-10s | Часы: %3d",
                getPriorityText(), taskName, project, estimatedHours);
    }
}

public class CustomSortingDemo {

    // Универсальный метод сортировки пузырьком
    public static <T extends Comparable<T>> void bubbleSortImplementation(T[] items) {
        boolean swapped;
        int n = items.length;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (items[i].compareTo(items[i + 1]) > 0) {
                    T temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static void main(String[] args) {
        System.out.println("=== ПРИМЕР 1: СОРТИРОВКА ПРОГРАММНЫХ ПРОДУКТОВ ===\n");

        SoftwareProduct[] software = {
                new SoftwareProduct("IntelliJ IDEA", "JetBrains", 2023, 4.8),
                new SoftwareProduct("Visual Studio Code", "Microsoft", 2023, 4.7),
                new SoftwareProduct("PyCharm", "JetBrains", 2023, 4.6),
                new SoftwareProduct("Android Studio", "Google", 2023, 4.5),
                new SoftwareProduct("Windows 11", "Microsoft", 2021, 4.3),
                new SoftwareProduct("Chrome", "Google", 2023, 4.4)
        };

        System.out.println("До сортировки:");
        System.out.println("=".repeat(80));
        for (SoftwareProduct product : software) {
            System.out.println(product);
        }

        Arrays.sort(software);

        System.out.println("\nПосле сортировки (по разработчику, затем по рейтингу ↓):");
        System.out.println("=".repeat(80));
        for (SoftwareProduct product : software) {
            System.out.println(product);
        }

        System.out.println("\n\n=== ПРИМЕР 2: СОРТИРОВКА ЗАДАЧ ПРОЕКТА ===\n");

        ProjectTask[] tasks = {
                new ProjectTask("Исправить критический баг", "WebApp", 1, 8),
                new ProjectTask("Добавить новую фичу", "MobileApp", 2, 24),
                new ProjectTask("Оптимизировать запросы БД", "Backend", 1, 16),
                new ProjectTask("Обновить документацию", "WebApp", 3, 12),
                new ProjectTask("Протестировать релиз", "MobileApp", 2, 20),
                new ProjectTask("Настроить CI/CD", "DevOps", 1, 32),
                new ProjectTask("Рефакторинг кода", "Backend", 3, 40)
        };

        System.out.println("До сортировки:");
        System.out.println("-".repeat(70));
        for (ProjectTask task : tasks) {
            System.out.println(task);
        }

        bubbleSortImplementation(tasks);

        System.out.println("\nПосле сортировки (по приоритету ↑, затем по времени ↑):");
        System.out.println("-".repeat(70));
        for (ProjectTask task : tasks) {
            System.out.println(task);
        }

        System.out.println("\n=== ДОПОЛНИТЕЛЬНО: СОРТИРОВКА В ОБРАТНОМ ПОРЯДКЕ ===\n");
        List<SoftwareProduct> productList = Arrays.asList(software);
        Collections.reverse(productList);

        for (SoftwareProduct product : productList) {
            System.out.println(product);
        }
    }
}
