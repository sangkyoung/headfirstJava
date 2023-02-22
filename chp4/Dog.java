package chp4;

public class Dog {
    private int size;
    private String name;

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        if(size>0){
            this.size = size;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void bark(){
        if(size>60){
            System.out.println("Woof! Wooof!");
        }else if(size>14){
            System.out.println("Ruff! Ruff!");
        }else{
            System.out.println("Yip! Yip!");
        }
    }
}
class DogTestDrive{
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setSize(70);
        Dog dog2 = new Dog();
        dog2.setSize(8);
        System.out.println("Dog1 size : "+dog1.getSize());
        dog1.bark();
        System.out.println("Dog2 size : "+dog2.getSize());
        dog2.bark();
    }
}