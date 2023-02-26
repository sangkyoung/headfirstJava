package chp7;

public class PetOwner {
    public static void main(String[] args) {
        Animal[] myAnimals = new Animal[2];
        Dog myDog = new Dog();
        Hippo myHippo = new Hippo();
        myAnimals[0] = myDog;
        myAnimals[1] = myHippo;
        Vet v = new Vet();
        for(Animal pet : myAnimals){
            v.giveShot(pet);
        }
    }
}
