package chp5;

public class DotCom {
    //instance variables : locations numOfHits
    int[] locations;
    int numOfHits=0;
    //method : check setLocations
    public String check(String userGuess){
        String result = "miss";
        int guess = Integer.parseInt(userGuess);
        for(int cell : locations){
            if(cell == guess){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if(numOfHits==locations.length){
            result = "kill";
        }
        System.out.println(result);
        return result;
    }
    public void setLocations(int[] locations){
        this.locations = locations;
    }
}