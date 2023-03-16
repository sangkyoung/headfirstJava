package chp14;

import javax.swing.*;

public class SimpleGui1 {
    public static void main(String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }
    public void go() {
        // make a frame
        JFrame frame = new JFrame();
        // make a button
        JButton button = new JButton("click me");
        // set the frame to close when the button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add button to frame
        frame.getContentPane().add(button);
        // make the frame visible
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
