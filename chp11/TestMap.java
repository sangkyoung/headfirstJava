package chp11;

import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new java.util.HashMap<>();

        map.put("Kathy", 42);
        map.put("Bert", 20);
        map.put("Skyler", 103);

        System.out.println(map);
        System.out.println(map.get("Kathy"));
    }
}
