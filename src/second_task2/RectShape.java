package second_task2;

import java.awt.*;

public class RectShape extends Shape {
    public RectShape(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }
}

