package chp3;
public class DogListTestDrive {
    public static void main(String[] args) {
        Dog[] pets = new Dog[3];
        for(int i=0;i<pets.length;i++){
            pets[i] = new Dog();
            pets[i].name = "Sindy"+i;
            pets[i].size = 13;
            pets[i].bark();
        }
    }
}
