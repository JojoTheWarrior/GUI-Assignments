import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question_4 {
    int x1 = -1, y1 = -1, x2 = -1, y2 = -1, x3 = -1, y3 = -1, soFar = 0;

    public Drawing draw = new Drawing();

    public Question_4(){
        JFrame f = new JFrame("Circumscribed Triangle");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 1000);
        f.setResizable(false);
        f.setVisible(true);
        draw.addMouseListener(new ClickHandler());
        f.add(draw);
    }

    public class ClickHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            if (soFar == 0){
                x1 = e.getX();
                y1 = e.getY();
                x2 = -1;
                y2 = -1;
                x3 = -1;
                y3 = -1;
                soFar = 1;
            } else if (soFar == 1){
                x2 = e.getX();
                y2 = e.getY();
                soFar = 2;
            } else if (soFar == 2){
                x3 = e.getX();
                y3 = e.getY();
                soFar = 0;
            }

            draw.repaint();
        }
    }

    public static void main(String[] args){
        new Question_4();
    }

    public class Drawing extends JComponent {
        public void paint(Graphics g){
            // draws the third point and the circle, if it's available and they are not collinear
            if (x3 != -1 && y3 != -1){
                // checks if they are collinear
                if ((x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1)){
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Serif", Font.BOLD, 30));
                    g.drawString("These three points are collinear!", 260, 350);
                    return;
                }
                
                // draws the third point
                g.setColor(Color.BLUE);
                g.fillOval(x3 - 5, y3 - 5, 10, 10);

                // calculates the two perpendicular bisectors
                // equation of the PB of p1 and p2
                double m1 = -(x2 - x1) / ((double) y2 - y1);
                double xx1 = (x1 + x2) / 2.0;
                double yy1 = (y1 + y2) / 2.0;

                // equation of the PB of p2 and p3
                double m2 = -(x3 - x2) / ((double) y3 - y2);
                double xx2 = (x2 + x3) / 2.0;
                double yy2 = (y2 + y3) / 2.0;

                // solve for the x-coordinate of the origin
                double xo = (yy2 - m2 * xx2 - yy1 + m1 * xx1) / (m1 - m2);

                // substitute the x-coordinate back into the first equation to find the y-coordinate
                double yo = m1 * (xo - xx1) + yy1;

                // calculates the radius
                int r = (int) Math.sqrt((xo - x1) * (xo - x1) + (yo - y1) * (yo - y1));

                // draws the circle
                g.drawOval((int) xo - r, (int) yo - r, 2 * r, 2 * r);
            }

            // draws the first point, if it's available
            if (x1 != -1 && y1 != -1){
                g.setColor(Color.RED);
                g.fillOval(x1 - 5, y1 - 5, 10, 10);
            }

            // draws the second point, if it's available
            if (x2 != -1 && y2 != -1){
                g.setColor(Color.GREEN);
                g.fillOval(x2 - 5, y2 - 5, 10, 10);
            }
        }
    }
}