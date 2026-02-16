package lab5.part6;

public class KelvinToFahrenheit implements Convertable {
    @Override
    public double convert(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }

    @Override
    public String toString() {
        return "Кельвин → Фаренгейт";
    }
}