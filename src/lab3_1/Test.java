package lab3_1;

public class Test {
    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        System.out.println(point);
        point.moveUp();
        point.moveRight();
        System.out.println("After +1 up and +1 right:" + point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 3, 10);
        System.out.println(circle);
        circle.moveDown();
        circle.moveLeft();
        System.out.println("After -1 down and 1 left: " + circle);
    }
}
