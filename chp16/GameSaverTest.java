package chp16;

import java.io.*;

public class GameSaverTest {
    // saving and restoring the game characters

    // main - create three game characters, save them to a file
    public static void main(String[] args) {
        /* 
        // create three game characters
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells","invisibility"});
        
        // save serialized objects to a file
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            objectOutputStream.writeObject(one);
            objectOutputStream.writeObject(two);
            objectOutputStream.writeObject(three);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        // restore serialized objects from the file
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) objectInputStream.readObject();
            GameCharacter twoRestore = (GameCharacter) objectInputStream.readObject();
            GameCharacter threeRestore = (GameCharacter) objectInputStream.readObject();
            
            //print restored objects
            System.out.println(twoRestore.getType()+" : "+oneRestore.getWeapons());
            System.out.println(twoRestore.getType()+" : "+twoRestore.getWeapons());
            System.out.println(threeRestore.getType()+" : "+threeRestore.getWeapons());

            // close the stream
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
