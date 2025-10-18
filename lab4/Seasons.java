package lab4;

public enum Seasons {
    SUMMER(25.0, "Лето"),
    WINTER(-20.0, "Зима"),
    SPRING(15, "Весна"),
    AUTUMN(10, "Осень");

    private final double averageTemp;
    private final String russianName;

    Seasons(double averageTemp, String russianName) {
        this.averageTemp = averageTemp;
        this.russianName = russianName;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public String getRussianName() {
        return russianName;
    }

    public String getDescription() {
        if (this == SUMMER) {
            return "Теплое время года";
        }
        else {
            return "Не теплое время года";
        }
    }

    public static void printFavorite(Seasons season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму!");
                break;
            case SPRING:
                System.out.println("Я люблю весну!");
                break;
            case SUMMER:
                System.out.println("Я люблю лето!");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень!");
                break;
            default:
                System.out.println("Такого времени года нет");
        }
    }
}

