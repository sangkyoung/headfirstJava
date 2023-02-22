package chp4;

public class PoorDogTestDrive {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[3];

        dogs[0] = new Dog();
        dogs[0].setName("Beauty");
        dogs[1] = new Dog();
        System.out.println("Dog "+dogs[0].getName()+"'s size is "+dogs[0].getSize());
        System.out.println("Second Dog's name is "+dogs[1].getName());
    }
}
