package chp10;
import static java.lang.System.out;
public class TestBox {
    Integer i;
    int j;
    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }
    public void go(){
        j = i; //"this.i" is null
        //i = j; //0 0
        out.println(j);
        out.println(i);
    }
}
