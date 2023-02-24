package chp5;

import java.util.ArrayList;

public class DotCom {
    //instance variables : locations 
    private ArrayList<String> locations;
    private String name;

    //method : check setLocations
    public String check(String userGuess){
        String result = "miss";
        //
        int idx = locations.indexOf(userGuess);
        if(idx >= 0){
            locations.remove(idx);
            if(locations.isEmpty()){
                result = "kill";
            }else{
                result = "hit";
            }
            //System.out.println(result);
        }
        return result;
    }
    public void setLocations(ArrayList<String> locations){
        this.locations = locations;
    }
    public void setName(String name){
        this.name = name;
    }
}