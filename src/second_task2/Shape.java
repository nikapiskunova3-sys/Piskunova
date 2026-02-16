package second_task2;

import java.awt.*;

public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;
    protected int w;
    protected int h;

    public Shape(Color color, int x, int y, int w, int h) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public abstract void draw(Graphics g);
}

