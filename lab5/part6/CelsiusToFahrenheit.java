package lab5.part6;

public class CelsiusToFahrenheit implements Convertable {
    @Override
    public double convert(double celsius) {
        return (celsius * 9/5) + 32;
    }

    @Override
    public String toString() {
        return "Цельсий → Фаренгейт";
    }
}