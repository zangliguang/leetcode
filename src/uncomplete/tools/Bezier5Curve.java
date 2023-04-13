package uncomplete.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bezier5Curve extends JPanel {

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Path2D path = new Path2D.Float();
        path.moveTo(50, 100);
        path.curveTo(100, 125, 125, 50, 150, 75);
        path.curveTo(200, 100, 225, 75, 250, 100);
        g2d.draw(path);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bezier Curve");
        frame.add(new Bezier5Curve());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}