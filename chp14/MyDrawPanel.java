package chp14;

import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g) {
        // paint the background
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // set the color
        g.setColor(Color.orange);
        g.fillOval(70, 70, 100, 100);

        // draw the image
        Image image = new ImageIcon("D:\\young\\study\\java\\Java_programming_language_logo.svg.png").getImage();
        g.drawImage(image, 3, 4, this);

        // set the gradient color
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 350, Color.blue, 200, 370, Color.yellow);
        g2d.setPaint(gradient);
        g2d.fillRect(2, 350, 200, 20);
    }
    
    public static void main(String[] args) {
        MyDrawPanel gui = new MyDrawPanel();
        gui.go();
    }
    public void go() {
        // make a frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setSize(300, 420);
        frame.setVisible(true);
    }
}
