package chp15;

import javax.swing.*;
import java.awt.*;

public class MyDogReport {
    public static void main(String[] args) {
        MyDogReport myDogReport = new MyDogReport();
        myDogReport.gui();
    }

    public void gui() {
        // create frame
        JFrame frame = new JFrame("My Dog Report");

        // north: create panel (Dog Name)
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Dog Name:"));
        JTextField dog_name = new JTextField(15);
        dog_name.requestFocus();
        northPanel.add(dog_name);

        // west: create panel (Dog Breed and vaccinated)
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        JCheckBox vaccinated = new JCheckBox("Vaccinated");
        vaccinated.addItemListener(e -> {
            if (e.getStateChange() == 1) {
                System.out.println("Vaccinated");
            } else {
                System.out.println("Not Vaccinated");
            }
        });
        westPanel.add(vaccinated);
        String breeds[] = {"Poodle", "Lab", "Husky", "Pit Bull", "Pug", "Beagle", "Dachshund", "Chihuahua", "Pomeranian", "Shih Tzu", "Yorkshire Terrier", "Golden Retriever", "German Shepherd", "Bulldog", "Rottweiler", "Siberian Husky", "Doberman Pinscher", "Maltese", "French Bulldog", "Great Dane", "Shiba Inu", "Pomeranian", "Chow Chow", "Bernese Mountain Dog", "Miniature Schnauzer", "Pembroke Welsh Corgi", "Australian Shepherd", "Cavalier King Charles Spaniel", "English Bulldog", "Border Collie", "English Springer Spaniel", "Boxer", "American Staffordshire Terrier", "Cocker Spaniel", "Siberian Husky", "Beagle", "Pug", "Shih Tzu", "German Shepherd", "Golden Retriever", "Rottweiler", "Bulldog", "Doberman Pinscher", "Yorkshire Terrier", "Maltese", "French Bulldog", "Great Dane", "Shiba Inu", "Pomeranian", "Chow Chow", "Bernese Mountain Dog", "Miniature Schnauzer", "Pembroke Welsh Corgi", "Australian Shepherd", "Cavalier King Charles Spaniel", "English Bulldog", "Border Collie", "English Springer Spaniel", "Boxer", "American Staffordshire Terrier", "Cocker Spaniel", "Siberian Husky", "Beagle", "Pug", "Shih Tzu", "German Shepherd", "Golden Retriever", "Rottweiler", "Bulldog", "Doberman Pinscher", "Yorkshire Terrier", "Maltese", "French Bulldog", "Great Dane", "Shiba Inu", "Pomeranian", "Chow Chow", "Bernese Mountain Dog", "Miniature Schnauzer", "Pembroke Welsh Corgi", "Australian Shepherd", "Cavalier King Charles Spaniel", "English Bulldog", "Border Collie", "English Springer Spaniel", "Boxer", "American Staffordshire Terrier", "Cocker Spaniel", "Siberian Husky", "Beagle", "Pug", "Shih Tzu", "German Shepherd"};
        JList<String> dog_breed = new JList<String>(breeds);
        dog_breed.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                System.out.println("Breed: " + dog_breed.getSelectedValue());
            }
        });
        dog_breed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dog_breed.setVisibleRowCount(5);
        // wrap in scroll pane
        JScrollPane scrollPane = new JScrollPane(dog_breed);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        westPanel.add(scrollPane);

        // east: create panel (about dog)
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.add(new JLabel("About me:"));
        JTextArea about_me = new JTextArea(10, 15);
        about_me.setLineWrap(true);
        // wrap in scroll pane
        JScrollPane scrollPane2 = new JScrollPane(about_me);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        eastPanel.add(scrollPane2);
        Button sugar = new Button("Some Sugar");
        String paw = "🐾";
        sugar.addActionListener(e -> {
            about_me.append(paw);
        });
        eastPanel.add(sugar);

        // add panels to frame and set frame visible
        frame.getContentPane().add(BorderLayout.NORTH, northPanel);
        frame.getContentPane().add(BorderLayout.WEST, westPanel);
        frame.getContentPane().add(BorderLayout.EAST, eastPanel);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
