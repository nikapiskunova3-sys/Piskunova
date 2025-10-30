package lab5.part6;

public class KelvinToCelsius implements Convertable {
    @Override
    public double convert(double kelvin) {
        return kelvin - 273.15;
    }

    @Override
    public String toString() {
        return "Кельвин → Цельсий";
    }
}
