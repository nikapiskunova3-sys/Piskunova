package lab6;

public class MathTest {
    public static void main(String[] args) {
        MathCalculable test1 = new MathFunc();

        MathFunc test2 = new MathFunc();

        System.out.println("2^4 = " + test1.power(2, 4));
        System.out.println("4^3 = " + test1.power(4, 3));

        System.out.println("|2 + 5i| = " + test1.complexModulus(2, 5));
        System.out.println("|3 + 8i| = " + test1.complexModulus(1, 1));

        System.out.println("Длина окружности c радиус = 5: " + test2.circleLength(7));
        System.out.println("Площадь круга c радиусом = 3: " + test2.circleArea(6));
        System.out.println("Число PI из интерфейса: " + MathCalculable.PI);

        System.out.println("\n=== Тест комплексных чисел ===");
        System.out.println("|0 + 0i| = " + test2.complexModulus(0, 0));
        System.out.println("|5 + 12i| = " + test2.complexModulus(5, 12));
    }
}
