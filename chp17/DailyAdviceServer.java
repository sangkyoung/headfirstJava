package chp17;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Random;

public class DailyAdviceServer {

    //main
    public static void main(String[] args) {
        new DailyAdviceServer().go();
    }
    
    // declare advice String list
    final private String[]  adviceList = {
        "Take smaller bites",
        "Go for the tight jeans. No they do NOT make you look fat.",
        "One word: inappropriate",
        "Just for today, be honest. Tell your boss what you *really* think",
        "You might want to rethink that haircut."
    };
    private final Random random = new Random();

    // method go ; make serversocketchannel and bind. accept connection and write an advice message.
    public void go() {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(5000));

            while(serverChannel.isOpen()){
                SocketChannel clientChannel = serverChannel.accept();
                PrintWriter writer = new PrintWriter(Channels.newOutputStream(clientChannel));
                
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // util method for get advice
    private String getAdvice(){
        int nextAdvice = random.nextInt(adviceList.length);
        return adviceList[nextAdvice];
    }
}
