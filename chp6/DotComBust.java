package chp6;
import java.util.ArrayList;

import chp5.DotCom;
import chp5.GameHelper;

public class DotComBust {
    //변수 선언
    private GameHelper heler = new GameHelper();
    private ArrayList<DotCom> dotcoms = new ArrayList<>();
    private int numOfGuess = 0;

    //메소드 선언
    private void setUpGame(){
        DotCom aCom = new DotCom();
        aCom.setName("aPet.com");
        dotcoms.add(aCom);
        DotCom bCom = new DotCom();
        bCom.setName("Goodjob.com");
        dotcoms.add(bCom);
        DotCom cCom = new DotCom();
        cCom.setName("Money.com");
        dotcoms.add(cCom);

        for(DotCom com : dotcoms){
            com.setLocations(heler.createLocations(3));
        }

    }
    private void startPlaying(){
        while(!dotcoms.isEmpty()){
            String guess = heler.getUserInput("put your Guess");
            checkUserGuess(guess);
        }
        finishGame();
    }
    private void checkUserGuess(String userGuess){
        numOfGuess++;
        String result = "miss";
        for(DotCom com : dotcoms){
            result = com.check(userGuess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotcoms.remove(com);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("--Game end--");
        if(numOfGuess>18){
            System.out.println("You did Not Good, "+numOfGuess);
        }else{
            System.out.println("You did Good, "+numOfGuess);
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
