import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question_3 extends JPanel {

    public int startX = -1, startY = -1, endX = -1, endY = -1, soFar = 0;
    public boolean dragging = false;

    public Drawing draw = new Drawing();

    public static void main(String[] args) {
        new Question_3();
    }

    public Question_3() {
        JFrame frame = new JFrame("Draw Rectangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        draw.addMouseListener(new ClickHandler());
        frame.add(draw);
    }

    private class ClickHandler extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            if (soFar == 0){
                startX = e.getX();
                startY = e.getY();
                endX = -1;
                endY = -1;
                soFar = 1;
            } else if (soFar == 1){
                endX = e.getX();
                endY = e.getY();
                soFar = 0;
            }

            draw.repaint();
        }
    }

    public class Drawing extends JComponent {
        public void paint(Graphics g) {
            // draw the starting point if possible
            if (startX != -1 && startY != -1){
                g.setColor(Color.RED);
                g.fillOval(startX - 5, startY - 5, 10, 10);
            }
            
            // draw the ending point if possible
            if (endX != -1 && endY != -1){
                g.setColor(Color.GREEN);
                g.fillOval(endX - 5, endY - 5, 10, 10);

                int w = Math.abs(startX - endX);
                int h = Math.abs(startY - endY);

                g.setColor(Color.BLACK);
                g.drawRect(Math.min(startX, endX), Math.min(startY, endY), w, h);
            }
        }
    }
}