package lab5.part6;

public class FahrenheitToKelvin implements Convertable {
    @Override
    public double convert(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    @Override
    public String toString() {
        return "Фаренгейт → Кельвин";
    }
}