package chp9;

import chp7.Animal;

public class Duck extends Animal {
    int size;

    //constructors
    public Duck(String name){
        super(name);
        size = 10;
    }
    public Duck(int size){
        super();
        this.size = size;
    }
    public Duck(){
        this(10);
    }
}
