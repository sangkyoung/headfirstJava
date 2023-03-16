package chp14;

import javax.swing.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener{
    JButton button;
    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }
    public void go() {
        // make a frame
        JFrame frame = new JFrame();
        button = new JButton("click me");

        // set the button listener
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // set the button to say "I've been clicked"
        button.setText("I've been clicked!");
    }
}
