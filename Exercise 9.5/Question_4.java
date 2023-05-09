import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question_4 {

    public int centerX = -1, centerY = -1, radius = -1;
    public boolean clickedOnce = false;
    Drawing draw = new Drawing();

    public Question_4() {
        JFrame frame = new JFrame("Draw Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.addMouseListener(new ClickHandler());
        frame.add(draw);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public class ClickHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (!clickedOnce) {
                centerX = e.getX();
                centerY = e.getY();
                radius = -1;
                clickedOnce = true;
                draw.repaint();
            } else {
                int xDiff = e.getX() - centerX;
                int yDiff = e.getY() - centerY;
                radius = (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
                clickedOnce = false;
                draw.repaint();
            }
        }
    }

    class Drawing extends JComponent {
        public void paint(Graphics g){
            // draws the first dot, if it exists
            if (centerX != -1 && centerY != -1){
                g.setColor(Color.RED);
                g.fillOval(centerX - 5, centerY - 5, 10, 10);
            }

            // draws the circle, if the radius is not -1
            if (radius != -1){
                g.setColor(Color.BLUE);
                g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
            }
        }
    }

    public static void main(String[] args) {
        new Question_4();
    }
}