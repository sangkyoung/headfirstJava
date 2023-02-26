package chp7;

public class Dog extends Canine{
    @Override
    public void makeNoise() {
        System.out.println("Woof! Woof!");
    }
    public void makeNoise(String ownerName){
        System.out.println("Woo~"+ownerName+"~!");
    }
}
