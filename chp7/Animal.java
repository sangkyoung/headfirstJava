package chp7;

public class Animal {
    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    
    public void makeNoise(){
        System.out.println("Arrrrgh");
    }
    public void roam(){
        //
    }

    //constructors
    public Animal(String name){
        this.name = name;
    }
    public Animal(){
        //
    }
}
