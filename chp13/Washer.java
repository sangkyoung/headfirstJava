package chp13;

public class Washer {
    Laundry laundry = new Laundry();

    public void foo() throws ClothingException {
        laundry.doLaundray();
    }
    public static void main(String[] args) throws ClothingException {
        Washer washer = new Washer();
        washer.foo();
    }
}