package chp5;
import java.io.*;
public class GameHelper {
    public String getUserInput(String message){
        String inputLine = null;
        System.out.print(message+" ");
        try{
            BufferedReader is = new BufferedReader(
                new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0) return null;
        }catch(IOException exception){
            System.out.println("ioexception : "+exception);
        }
        return inputLine;
    }
}
