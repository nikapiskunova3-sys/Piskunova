package lab4;

public class Main {
    public static void main(String[] args) {
        Seasons favorite = Seasons.SUMMER;
        System.out.println("Мое любиое время года:");
        System.out.println("Название: " + favorite);
        System.out.println("Русское название: " + favorite.getRussianName());
        System.out.println("Средняя температура: " + favorite.getAverageTemp());
        System.out.println("Описание: " + favorite.getDescription());
        System.out.println("=======================================");

        Seasons.printFavorite(favorite);
        Seasons.printFavorite(Seasons.AUTUMN);
        Seasons.printFavorite(Seasons.WINTER);
        Seasons.printFavorite(Seasons.SPRING);
        System.out.println("=======================================");

        System.out.println("Все времена года: ");
        for (Seasons season : Seasons.values()) {
            System.out.println(season.getRussianName() + ". Средняя температура в это время года: " +  season.getAverageTemp() + ". Описание: " +  season.getDescription());
        }
    }
}
