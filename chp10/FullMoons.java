package chp10;

import java.util.*;
import static java.lang.System.out;

public class FullMoons {
    //full moons routine is about 29.52 days
    //2004.01.07 is full moon day.
    public static final int ONE_DAY = 1000*60*60*24;
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);
        //get other full moon days
        Long day1 = c.getTimeInMillis();
        Double fm = (ONE_DAY * 29.52);
        for(int x=0;x<5;x++){
            day1 += fm.longValue() * 48;
            c.setTimeInMillis(day1);
            out.println(String.format("full moon %tc",c));
        }
    }
}
