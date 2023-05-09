import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question_3 extends JPanel {

    public int startX = -1, startY = -1, endX = -1, endY = -1;
    public  boolean dragging = false;

    public Drawing draw = new Drawing();

    public static void main(String[] args) {
        new Question_3();
    }

    public Question_3() {
        JFrame frame = new JFrame("Draw Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        draw.addMouseListener(new ClickHandler());
        frame.add(draw);
    }

    public class ClickHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
            endX = -1;
            endY = -1;
            dragging = true;
            draw.repaint();
        }

        public void mouseReleased(MouseEvent e) {
            endX = e.getX();
            endY = e.getY();
            dragging = false;
            draw.repaint();
        }
    }

    public class Drawing extends JComponent {
        public void paint(Graphics g){
            // draws the starting point if it's not -1
            if (startX != -1 && startY != -1){
                g.setColor(Color.GREEN);
                g.fillOval(startX - 5, startY - 5, 10, 10);
            }

            // draws the ending point if it's not -1
            if (endX != -1 && endY != -1){
                g.setColor(Color.RED);
                g.fillOval(endX - 5, endY - 5, 10, 10);
                g.setColor(Color.BLACK);
                g.drawLine(startX, startY, endX, endY);
            }
        }
    }
}