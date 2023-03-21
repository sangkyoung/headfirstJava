package chp16;

import java.io.*;
import java.util.Arrays;

public class GameCharacter implements Serializable {
    private static final long serialVersionUID = -712502983536419941L;
    // add pet
    private final String pet;

    // power, type, and weapons
    private final int power;
    private final String type;
    private final String[] weapons;

    // constructor
    public GameCharacter(int power, String type, String[] weapons, String pet) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
        this.pet = pet;
    }

    // getters
    public int getPower() {
        return power;
    }
    public String getType() {
        return type;
    }
    public String getWeapons() {
        // weapons is an array, so we need to convert it to a string
        return Arrays.toString(weapons);
    }
    public String getPet() {
        return pet;
    }
}
