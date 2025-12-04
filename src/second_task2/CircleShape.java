package second_task2;

import java.awt.*;

public class CircleShape extends Shape {
    public CircleShape(Color color, int x, int y, int diameter) {
        super(color, x, y, diameter, diameter);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, w, h);
    }
}

