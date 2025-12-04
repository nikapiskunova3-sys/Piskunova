package second_task2;

import java.awt.*;

public class TriangleShape extends Shape {
    public TriangleShape(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int[] xs = {x, x + w / 2, x + w};
        int[] ys = {y + h, y, y + h};
        g.fillPolygon(xs, ys, 3);
    }
}

