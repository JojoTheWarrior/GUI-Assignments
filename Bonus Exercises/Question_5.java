import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question_5 implements ActionListener {
    JTextField hours = new JTextField("12", 10);
    JTextField mins = new JTextField("0", 10);
    JButton submit = new JButton("Display");
    Drawing draw = new Drawing();
    int h = -1, m = -1;

    public Question_5(){
        JFrame f = new JFrame("Analog Clock");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(800, 800);
        f.setResizable(false);
        f.setVisible(true);

        // adding the input fields
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        bottom.add(new JLabel("Hours: "));
        bottom.add(hours);
        hours.addActionListener(this);
        bottom.add(new JLabel("Minutes: "));
        bottom.add(mins);
        mins.addActionListener(this);
        bottom.add(submit);
        submit.addActionListener(this);

        f.add(bottom, BorderLayout.SOUTH);

        // drawing the clock
        f.add(draw);
    }

    public static void main(String[] args){
        new Question_5();
    }

    public void actionPerformed(ActionEvent e){
        h = Integer.parseInt(hours.getText());
        m = Integer.parseInt(mins.getText());

        //if (e.getSource() == submit){
            /* assume precondition is satisfied
            if (h < 1 || 12 < h || m < 0 || 59 < m){

                return;
            }
            */
            draw.repaint();
        //}
    }

    public double degToRad(int d){
        d %= 360;
        return 3.14159265 * d / 180.0;
    }

    // center is (400, 400), radius is 250
    public int getXCoord(int deg){
        deg %= 360;
        if (0 <= deg && deg < 90){
            int theta = 90 - deg;
            return 400 + (int) (250 * Math.cos(degToRad(theta)));
        } else if (90 <= deg && deg < 180){
            int theta = deg - 90;
            return 400 + (int) (250 * Math.cos(degToRad(theta)));
        } else if (180 <= deg && deg < 270){
            int theta = 270 - deg;
            return 400 - (int) (250 * Math.cos(degToRad(theta)));
        } else {
            int theta = deg - 270;
            return 400 - (int) (250 * Math.cos(degToRad(theta)));
        }
    }

    public int getYCoord(int deg){
        deg %= 360;
        int relH = (int) Math.sqrt(250 * 250 - Math.pow(Math.abs(400 - getXCoord(deg)), 2));
        if ((0 <= deg && deg < 90) || (270 <= deg && deg < 360)){
            return 400 - relH;
        } else {
            return 400 + relH;
        }
    }

    public class Drawing extends JComponent {
        public void paint(Graphics g){
            // draws the blank clock
            g.setColor(Color.BLACK);
            g.setFont(new Font("Serif", Font.BOLD, 25));
            g.drawOval(150, 150, 500, 500);
            for (int i = 1; i <= 12; i++){
                int x = getXCoord(i * 30);
                int y = getYCoord(i * 30);

                g.setColor(new Color(255 * i / 12, 255 * (12 - i) / 12, 255 * i / 12));
                g.fillOval(x - 5, y - 5, 10, 10);
                g.setColor(Color.BLACK);
                g.drawString("" + i, x - 5, y - 5);
            }

            // draws the lines if they're not blank
            if (h != -1 && m != -1){
                int x1 = getXCoord(h * 30 + (30 * m / 60));
                int y1 = getYCoord(h * 30 + (30 * m / 60));
                int x2 = getXCoord(360 * m / 60);
                int y2 = getYCoord(360 * m / 60);

                g.setColor(Color.BLACK);
                g.drawLine(400, 400, 400 + (x1 - 400) / 2, 400 + (y1 - 400) / 2);
                g.drawLine(400, 400, 400 + (int) ((x2 - 400) / 1.2), 400 + (int) ((y2 - 400) / 1.2));
            }
        }
    }
}
