package chp18;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

public class ConcurrentReaders {
    public static void main(String[] args) {
        //create a list of chats
        List<Chat> chats = new ArrayList<>();
        //create a executor service of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // execute adding, reading for 5 times
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> chats.add(new Chat("Hello World!")));
            executor.execute(() -> System.out.println(chats));
            executor.execute(() -> System.out.println(chats));
        }
        //shutdown the executor service
        executor.shutdown();

    }
}
final class Chat {
    private final String message;
    private final LocalDateTime timestamp;
    //constructor
    public Chat(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
    //toString
    @Override
    public String toString() {
        String time = timestamp.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return time + " " + message;
    }
}