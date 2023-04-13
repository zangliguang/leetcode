package uncomplete.tools;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.QuadCurve2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BezierCurve extends JPanel {

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();
        q.setCurve(50, 50, 100, 100, 150, 50);
        g2d.draw(q);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bezier Curve");
        frame.add(new BezierCurve());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}