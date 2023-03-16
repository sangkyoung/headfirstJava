package chp14;

import javax.swing.*;
import java.awt.*;

public class MyCirclePanel extends JPanel{

    public void paintComponent(Graphics g) {
        // paint the background
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // set the color
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color color = new Color(red, green, blue);

        // set the gradient color
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(0, 0, color, 200, 200, Color.white);
        g2d.setPaint(gradient);
        g2d.fillOval(10, 10, 180, 180);
    }
    
}
