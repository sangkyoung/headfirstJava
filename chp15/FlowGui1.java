package chp15;

import java.awt.*;
import javax.swing.*;

public class FlowGui1 {
    public static void main(String[] args) {
        FlowGui1 gui = new FlowGui1();
        gui.go();
    }
    public void go() {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBackground(Color.GREEN);

        //BoxLayout: change panel's layout manager
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.getContentPane().add(BorderLayout.EAST, panel);
        // create button and add to panel
        JButton button = new JButton("Click me!");
        panel.add(button);
        JButton button2 = new JButton("shock me");
        panel.add(button2);
        JButton button3 = new JButton("bliss");
        panel.add(button3);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
