package chp8;

import chp7.Dog;
import chp7.Hippo;


public class MyAnimalListTestDrive {
    public static void main(String[] args) {
        MyAnimalList list = new MyAnimalList();
        Dog dog = new Dog();
        Hippo hippo = new Hippo();
        list.add(dog);
        list.add(hippo);
    }
}
