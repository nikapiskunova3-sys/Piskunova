package lab5.part6;

public class CelsiusToKelvin implements Convertable {
    @Override
    public double convert(double celsius) {
        return celsius + 273.15;
    }

    @Override
    public String toString() {
        return "Цельсий → Кельвин";
    }
}
