import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question_6 implements ActionListener {
    int circles = 0;
    JTextField num = new JTextField(5);
    Drawing draw = new Drawing();

    public Question_6(){
        JFrame f = new JFrame("Filling Circles");
        f.setSize(800, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());

        // text field at the bottom and its label
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());

        bottom.add(new JLabel("number of circles (more than 2 and less than 100 inclusive):"));
        bottom.add(num);
        f.add(bottom, BorderLayout.SOUTH);

        num.addActionListener(this);

        // draws the dots in the center
        f.add(draw, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        new Question_6();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == num){
            circles = Integer.parseInt(num.getText().trim());
            draw.repaint();
        }
    }

    public class Drawing extends JComponent {
        public void paint(Graphics g){
            if(circles>=2 && circles<=100) {
                for (int i = 0; i < circles; i++) {
                    g.setColor(new Color(r(), r(), r()));
                    g.fillOval((int) (getWidth() * Math.random()), (int) (getHeight() * Math.random()), 8, 8);
                }
            }
        }

        public int r(){
            return (int) (255 * Math.random());
        }
    }
}