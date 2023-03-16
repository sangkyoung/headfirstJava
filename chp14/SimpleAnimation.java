package chp14;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimation {
    JFrame frame;
    MyDrawPanel panel;
    int x = 70;
    int y = 70;
    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyDrawPanel();
        frame.getContentPane().add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            panel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class MyDrawPanel extends JPanel {
        @Override
        protected void paintChildren(Graphics g) {
            // draw background 
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            // draw circle
            g.setColor(Color.orange);
            g.fillOval(x, y, 100, 100);
        }
    }
}
