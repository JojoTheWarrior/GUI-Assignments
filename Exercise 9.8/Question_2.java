import java.awt.*;
import javax.swing.*;

public class Question_2 extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Names and Shapes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        Question_2 panel = new Question_2();
        frame.add(panel);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillOval(30, 30, 70, 70);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospace",Font.PLAIN,15));
        g.drawString("Kayla", 45, 70);

        g.setColor(Color.RED);
        g.drawRect(50, 290, 70, 70);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif",Font.PLAIN,15));
        g.drawString("Orwell", 62, 330);

        g.setColor(Color.MAGENTA);
        g.fillRect(380, 40, 80, 55);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Sans Serif",Font.PLAIN,15));
        g.drawString("John", 400, 75);

        g.setColor(Color.CYAN);
        g.drawOval(380, 290, 80, 80);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.ITALIC,15));
        g.drawString("Thomas", 395, 335);

        g.setColor(Color.YELLOW);
        Polygon triangle = new Polygon();
        triangle.addPoint(220, 230);
        triangle.addPoint(320, 230);
        triangle.addPoint(270, 160);
        g.fillPolygon(triangle);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,15));
        g.drawString("Vaughan", 245, 215);
    }
}