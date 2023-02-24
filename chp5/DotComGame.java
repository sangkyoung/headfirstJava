package chp5;

import java.util.ArrayList;

public class DotComGame {
    public static void main(String[] args) {
        int numOfGuess = 0;
        GameHelper helper = new GameHelper();

        DotCom dotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);

        ArrayList<String> locations = new ArrayList<>();
        locations.add(""+randomNum);
        locations.add(""+(randomNum+1));
        locations.add(""+(randomNum+2));
        dotCom.setLocations(locations);
        boolean isAlive = true;

        while(isAlive==true){
            String guess = helper.getUserInput("enter a number");
            String result = dotCom.check(guess);
            numOfGuess++;
            if(result.equals("kill")){
                isAlive = false;
                System.out.println(numOfGuess+" guesses");
            }
        }

    }
}
