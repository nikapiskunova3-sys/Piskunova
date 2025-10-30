package lab5.part6;

public class TemperatureConverter {
    private TemperatureConverter() {
    }

    public static void convertAndPrint(double temperature, Convertable converter, String fromUnit) {
        double result = converter.convert(temperature);
        String toUnit = converter.toString().split("→")[1].trim();

        System.out.printf("%.2f°%s = %.2f°%s%n",
                temperature, fromUnit, result, toUnit);
    }

    public static Convertable[] getAllConverters() {
        return new Convertable[] {
                new CelsiusToKelvin(),
                new CelsiusToFahrenheit(),
                new KelvinToCelsius(),
                new FahrenheitToCelsius(),
                new KelvinToFahrenheit(),
                new FahrenheitToKelvin()
        };
    }

    public static String getUnitSymbol(String unitName) {
        return switch (unitName.toLowerCase()) {
            case "цельсий", "celsius", "c" -> "C";
            case "фаренгейт", "fahrenheit", "f" -> "F";
            case "кельвин", "kelvin", "k" -> "K";
            default -> "";
        };
    }
}
