package lab5.part6;

import java.util.Scanner;

public class TemperatureConverterApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== КОНВЕРТЕР ТЕМПЕРАТУР ===");

        while (true) {
            printMainMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> convertFromCelsius();
                case 2 -> convertFromKelvin();
                case 3 -> convertFromFahrenheit();
                case 4 -> customConversion();
                case 5 -> showAllConversions();
                case 6 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
        System.out.println("1. Конвертировать из Цельсия");
        System.out.println("2. Конвертировать из Кельвина");
        System.out.println("3. Конвертировать из Фаренгейта");
        System.out.println("4. Произвольная конвертация");
        System.out.println("5. Показать все типы конвертации");
        System.out.println("6. Выход");
    }

    private static void convertFromCelsius() {
        System.out.println("\n=== КОНВЕРТАЦИЯ ИЗ ЦЕЛЬСИЯ ===");
        double celsius = getDoubleInput("Введите температуру в Цельсиях: ");

        Convertable[] converters = {
                new CelsiusToKelvin(),
                new CelsiusToFahrenheit()
        };

        System.out.println("\nРезультаты конвертации:");
        for (Convertable converter : converters) {
            TemperatureConverter.convertAndPrint(celsius, converter, "C");
        }
    }

    private static void convertFromKelvin() {
        System.out.println("\n=== КОНВЕРТАЦИЯ ИЗ КЕЛЬВИНА ===");
        double kelvin = getDoubleInput("Введите температуру в Кельвинах: ");

        Convertable[] converters = {
                new KelvinToCelsius(),
                new KelvinToFahrenheit()
        };

        System.out.println("\nРезультаты конвертации:");
        for (Convertable converter : converters) {
            TemperatureConverter.convertAndPrint(kelvin, converter, "K");
        }
    }

    private static void convertFromFahrenheit() {
        System.out.println("\n=== КОНВЕРТАЦИЯ ИЗ ФАРЕНГЕЙТА ===");
        double fahrenheit = getDoubleInput("Введите температуру в Фаренгейтах: ");

        Convertable[] converters = {
                new FahrenheitToCelsius(),
                new FahrenheitToKelvin()
        };

        System.out.println("\nРезультаты конвертации:");
        for (Convertable converter : converters) {
            TemperatureConverter.convertAndPrint(fahrenheit, converter, "F");
        }
    }

    private static void customConversion() {
        System.out.println("\n=== ПРОИЗВОЛЬНАЯ КОНВЕРТАЦИЯ ===");

        Convertable[] allConverters = TemperatureConverter.getAllConverters();

        System.out.println("Доступные типы конвертации:");
        for (int i = 0; i < allConverters.length; i++) {
            System.out.println((i + 1) + ". " + allConverters[i]);
        }

        int converterChoice = getIntInput("Выберите тип конвертации (1-" + allConverters.length + "): ") - 1;

        if (converterChoice < 0 || converterChoice >= allConverters.length) {
            System.out.println("Неверный выбор!");
            return;
        }

        Convertable selectedConverter = allConverters[converterChoice];
        String fromUnit = selectedConverter.toString().split("→")[0].trim();
        String fromSymbol = TemperatureConverter.getUnitSymbol(fromUnit);

        double temperature = getDoubleInput("Введите температуру в " + fromUnit + ": ");

        System.out.println("\nРезультат конвертации:");
        TemperatureConverter.convertAndPrint(temperature, selectedConverter, fromSymbol);
    }

    private static void showAllConversions() {
        System.out.println("\n=== ВСЕ ТИПЫ КОНВЕРТАЦИИ ===");

        double[] testTemperatures = {0, 100, -40, 25.5};

        Convertable[] allConverters = TemperatureConverter.getAllConverters();

        for (double temp : testTemperatures) {
            System.out.printf("\n--- Тестовая температура: %.1f°C ---%n", temp);

            for (Convertable converter : allConverters) {
                String fromUnit = converter.toString().split("→")[0].trim();
                String fromSymbol = TemperatureConverter.getUnitSymbol(fromUnit);

                // Для демонстрации используем соответствующие исходные температуры
                double inputTemp = getInputTemperatureForConverter(temp, converter);
                TemperatureConverter.convertAndPrint(inputTemp, converter, fromSymbol);
            }
        }
    }

    private static double getInputTemperatureForConverter(double celsius, Convertable converter) {
        return switch (converter.toString()) {
            case "Цельсий → Кельвин", "Цельсий → Фаренгейт" -> celsius;
            case "Кельвин → Цельсий", "Кельвин → Фаренгейт" -> celsius + 273.15;
            case "Фаренгейт → Цельсий", "Фаренгейт → Кельвин" -> (celsius * 9/5) + 32;
            default -> celsius;
        };
    }

    // Вспомогательные методы для ввода данных
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }
}
