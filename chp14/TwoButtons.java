package chp14;

import javax.swing.*;
import java.awt.*;

public class TwoButtons {
    JFrame frame;
    JLabel label;
    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }
    public void go() {
        frame = new JFrame();
        // make button
        JButton button = new JButton("change color");
        MyCirclePanel circle = new MyCirclePanel();
        // make button2
        JButton button2 = new JButton("change label");
        label = new JLabel("I'm a label");
        // set the frame to close when the button is clicked
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add button to frame
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.getContentPane().add(BorderLayout.CENTER,circle);
        //button.addActionListener(new ColorListener());
        button.addActionListener(event -> circle.repaint());

        // add button2 to frame
        frame.getContentPane().add(BorderLayout.EAST,button2);
        frame.getContentPane().add(BorderLayout.WEST,label);
        //button2.addActionListener(new LabelListener());
        button2.addActionListener(event -> label.setText("Ouch!"));

        // make the frame visible
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    /**class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            frame.repaint();
        }
    }
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("Ouch!");
        }
    }*/
}
