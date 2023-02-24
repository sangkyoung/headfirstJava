package chp5;

public class DotComTestDrive {
    public static void main(String[] args) {
        DotCom dot = new DotCom();
        //game setting
        int[] locations = {2,3,4};
        dot.setLocations(locations);
        //user choice
        String choice = "2";
        //check
        String result = dot.check(choice);
    }
}
