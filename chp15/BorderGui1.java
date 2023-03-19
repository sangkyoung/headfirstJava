package chp15;

import java.awt.*;
import javax.swing.*;

public class BorderGui1 {
    public static void main(String[] args) {
        BorderGui1 gui = new BorderGui1();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me!");
        JButton button2 = new JButton("Click me too!");
        JButton button3 = new JButton("Click me three!");
        JButton button4 = new JButton("Click me four!");
        JButton button5 = new JButton("Click me five!");
        // up font size
        Font font = new Font("serif", Font.BOLD, 28);
        button.setFont(font);

        frame.getContentPane().add(BorderLayout.CENTER, button5);
        frame.getContentPane().add(BorderLayout.WEST, button4);
        frame.getContentPane().add(BorderLayout.EAST, button3);
        frame.getContentPane().add(BorderLayout.NORTH, button);
        frame.getContentPane().add(BorderLayout.SOUTH, button2);

        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
