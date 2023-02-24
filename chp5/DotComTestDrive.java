package chp5;

import java.util.ArrayList;

public class DotComTestDrive {
    public static void main(String[] args) {
        DotCom dot = new DotCom();
        //game setting
        ArrayList<String> locations = new ArrayList<>();
        locations.add("2");
        locations.add("3");
        locations.add("4");
        dot.setLocations(locations);
        //user choice
        String choice = "2";
        //check
        String result = dot.check(choice);
    }
}
