import java.awt.*;
import javax.swing.*;

public class DDALine extends JPanel {
    private int x1, y1, x2, y2;

    public DDALine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLineDDA(g, x1, y1, x2, y2);
    }

    public void drawLineDDA(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.drawRect(Math.round(x), Math.round(y), 1, 1); // Dibuja un pixel
            x += xIncrement;
            y += yIncrement;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DDA Line Drawing");
        DDALine panel = new DDALine(50, 50, 200, 150);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
