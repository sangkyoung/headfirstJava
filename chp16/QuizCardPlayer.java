package chp16;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class QuizCardPlayer {
    //declare frame and textarea and button
    private JFrame frame;
    private JTextArea textArea;
    private JButton button;
    //declare QuizCard ArrayList and currentCardIndex
    private ArrayList<QuizCard> cardlist;
    private int currentCardIndex;
    private QuizCard currentCard;
    private boolean isShowAnswer;

    public static void main(String[] args) {
        new QuizCardPlayer().go();
    }

    //build and display gui
    public void go() {
        //create window, panel, textArea, button
        frame = new JFrame("Quiz Card Player");
        JPanel panel = new JPanel();
        textArea = new JTextArea(10, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("sanserif", Font.BOLD, 24));
        button = new JButton("Show Answer");
        //create scrollpane
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //add listener to button
        button.addActionListener(e -> nextCard());

        //add menubar and menu (menuitem load)
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(e -> open());
        menu.add(loadMenuItem);
        menuBar.add(menu);

        //add to panel, frame
        panel.add(scroller);
        panel.add(button);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setJMenuBar(menuBar);

        //set frame
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void nextCard() {
    //if this is a question, show the answer, otherwise show next question set a flag
    // for whether we’re viewing a question or answer
    if(isShowAnswer){
        //show answer
        textArea.setText(currentCard.getAnswer());
        button.setText("Next Card");
        isShowAnswer = false;
    }else{
        //show next card question
        if(currentCardIndex != cardlist.size()){
            showNextCard();
        }else{
            //there are no more cards!
            textArea.setText("That was last card");
            button.setEnabled(false);
        }
    }
    }
    public void open() {
        //bring up a file dialog box
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(frame);
        loadFile(fileChooser.getSelectedFile());
    }
    public void loadFile(File file) {
        // must build an ArrayList of cards, by reading them from a text file
        // called from the OpenMenuListener event handler
        cardlist = new ArrayList<>();
        currentCardIndex = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = bufferedReader.readLine()) != null){
                makeCard(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showNextCard();
    }
    public void makeCard(String lineToParse) {
        //parse into question and answer. and creates a new QuizCard and
        // adds it to the ArrayList
        String[] result = lineToParse.split("/");
        QuizCard quizCard = new QuizCard(result[0], result[1]);
        cardlist.add(quizCard);
        System.out.println("made a card");
    }
    public void showNextCard() {
        // get a QuizCard from cardlist and change textarea and button text
        currentCard = cardlist.get(currentCardIndex);
        currentCardIndex++;
        textArea.setText(currentCard.getQuestion());
        button.setText("Show Answer");
        isShowAnswer = true;
    
    }
}
