package chp16;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

public class QuizCardBuilder {
    //declare frame for dialog making method
    JFrame frame;
    //declare textarea
    private JTextArea question;
    private JTextArea answer;
    //declare list of cards
    private ArrayList<QuizCard> cardList = new ArrayList<QuizCard>();

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }
    
    public void go() {
        //build and display gui
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        //create text area for question and answer
        question = createTextArea(bigFont);
        JScrollPane qScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane aScroller = createScroller(answer);
        
        //add widgets to main panel
        mainPanel.add(new JLabel("Question:"));
        mainPanel.add(qScroller);
        mainPanel.add(new JLabel("Answer:"));
        mainPanel.add(aScroller);

        //create button for next card
        JButton nextButton = new JButton("Next Card");
        mainPanel.add(nextButton);
        //add listener to button
        nextButton.addActionListener(e -> nextCard());

        //create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        //add menu item to menu
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        newMenuItem.addActionListener(e -> clearAll());
        saveMenuItem.addActionListener(e -> saveCard());
        //add menu to menu bar
        menuBar.add(fileMenu);
        //add menu bar to frame
        frame.setJMenuBar(menuBar);

        //set frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
        
        //close when exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //util for create JTextArea
    private JTextArea createTextArea(Font font) {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
        return textArea;
    }
    //util for add scroll to JTextArea
    private JScrollPane createScroller(JTextArea textArea) {
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    private void nextCard() {
        //add the current card to the list and clear the text areas
        QuizCard card = new QuizCard(question.getText(), answer.getText());
        cardList.add(card);
        System.out.println("made a card: "+card.getQuestion()+" = "+card.getAnswer());
        clearCard();
    }

    private void saveCard() {
        //bring up a file dialog box
        //let the user name and save the set
        if(!question.getText().equals("") && !answer.getText().equals("")){
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(frame);
        saveFile(fileChooser.getSelectedFile());
    }

    private void clearCard() {
        //clear out the text areas
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    private void clearAll() {
        //clear out the list of cards
        cardList.clear();
        clearCard();
    }

    private void saveFile(File file) {
        //iterate through the list of cards and write each one out to a text file
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for(QuizCard quizCard : cardList){
                bufferedWriter.write(quizCard.getQuestion() + "/");
                bufferedWriter.write(quizCard.getAnswer() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("couldn't write the cardList out");
            ex.printStackTrace();
        }
    }
}
