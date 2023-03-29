package chp17;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.awt.*;
import java.util.concurrent.*;
import javax.swing.*;

public class SimpleChatClient {
    //declare variables
    private JTextArea incoming;
    private JTextField outgoing;
    private BufferedReader reader;
    private PrintWriter writer;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }
    //gui setting
    public void go() {
        setUpNetworking();

        //make panel, textfield and button
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        //add actionlistener to button
        sendButton.addActionListener(event -> sendMessage());
        //make scrollpane(textarea)
        JScrollPane scroller = createScrollableTextArea();
        //add scrollpane, textfield and button to panel
        mainPanel.add(scroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);

        //make frame and add panel to frame
        JFrame frame = new JFrame("Simple Chat Client");
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        //frame setting
        frame.setSize(400,350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //network setting
    private void setUpNetworking() {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
        try {
            SocketChannel socketChannel = SocketChannel.open(address);
            //write
            writer = new PrintWriter(Channels.newWriter(socketChannel, "UTF-8"));
            //read
            reader = new BufferedReader(Channels.newReader(socketChannel, "UTF-8"));
            System.out.println("[Networking established] " + socketChannel.getRemoteAddress());
            //read thread
            ExecutorService threadPool = Executors.newSingleThreadExecutor();
            threadPool.execute(new IncomingReader());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //make scrollpane(textarea)
    private JScrollPane createScrollableTextArea() {
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane scroller = new JScrollPane(incoming);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
    }

    //send message to server
    private void sendMessage() {
        String message = outgoing.getText();
        writer.println(message);
        writer.flush();
        outgoing.setText("");
        outgoing.requestFocus();
    }

    // ReadThread class
    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {  
                while((message = reader.readLine()) != null) {
                    System.out.println("[read] " + message);
                    incoming.append(message + "\n");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
