package lab3.test;

import lab3.Circle;
import lab3.Rectangle;
import lab3.Shape;
import lab3.Square;

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(7.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //System.out.println(s1.getRadius()); вызов этого метода выдаст ошибку, в связи с тем что у класса Shape нет такого метода

        //Shape s2 = new Shape(); мы не можем создать объект абстрактного класса

        Circle c1 = (Circle) s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());

        Rectangle r1 = new Rectangle(7, 12, "WHITE", false);
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getColor());
        System.out.println(r1.isFilled());

        Square sq1 = new Square(12, "RED", false);
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getPerimeter());
        System.out.println(sq1.getColor());
        System.out.println(sq1.isFilled());


    }
}
