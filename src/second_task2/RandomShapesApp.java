package second_task2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomShapesApp extends JPanel {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public RandomShapesApp() {
        setPreferredSize(new Dimension(800, 600));
        generateShapes();
    }

    private void generateShapes() {
        Random r = new Random();
        int width = 800;
        int height = 600;
        for (int i = 0; i < 20; i++) {
            int w = 30 + r.nextInt(120);
            int h = 30 + r.nextInt(120);
            int x = r.nextInt(Math.max(1, width - w));
            int y = r.nextInt(Math.max(1, height - h));
            Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
            int type = r.nextInt(3);
            if (type == 0) {
                shapes.add(new CircleShape(color, x, y, Math.max(w, h)));
            } else if (type == 1) {
                shapes.add(new RectShape(color, x, y, w, h));
            } else {
                shapes.add(new TriangleShape(color, x, y, w, h));
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Random Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RandomShapesApp panel = new RandomShapesApp();
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

