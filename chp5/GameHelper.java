package chp5;
import java.io.*;
import java.util.ArrayList;
public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLen = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

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
        return inputLine.toLowerCase();
    }
    public ArrayList<String> createLocations(int comSize){
        ArrayList<String> alphaCells = new ArrayList<>();
        String temp = null;
        int [] coords = new int[gridSize];//
        int attempts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr = 1;
        if((comCount % 2)==1){
            incr = gridLen;
        }

        while( !success & attempts++ < 30){
            location = (int) (Math.random() * gridSize); //위치
            int x = 0;
            success = true;
            while(success && x<comSize){
                if(grid[location]==0){
                    coords[x++] = location;
                    location += incr; // 다음 위치
                    if(location >= gridSize){
                        success = false;
                    }
                    if(x>0 & (location % gridLen == 0)){
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }
        int x = 0;
        int row = 0;
        int column = 0;
        while (x<comSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLen);
            column = coords[x] % gridLen;
            temp = String.valueOf(alphabet.charAt(column));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println("coord "+x+" = "+alphaCells.get(x-1));
        }
        return alphaCells;
    }
}
