package chp14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui3C implements ActionListener{
    JFrame frame;
    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add a panel
        frame.getContentPane().add(BorderLayout.CENTER,new MyCirclePanel());

        //add a button
        Button button = new Button("click me");
        button.addActionListener(this);
        frame.getContentPane().add(BorderLayout.SOUTH,button);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
