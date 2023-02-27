package chp8;

import chp7.Animal;

public class MyAnimalList {
    private Animal [] animals = new Animal[5];
    private int index = 0;

    public boolean add(Animal a){
        if(index<animals.length){
            animals[index] = a;
            System.out.println("Animal added at "+index);
            index++;
            return true;
        }
        return false;
    }
}

