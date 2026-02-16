package lab5.part6;

public class FahrenheitToCelsius implements Convertable {
    @Override
    public double convert(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    @Override
    public String toString() {
        return "Фаренгейт → Цельсий";
    }
}
