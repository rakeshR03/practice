package Concept;

import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(1, "One");
        treeMap1.put(10, "Ten");
        treeMap1.put(20, "Twenty");
        treeMap1.put(30, "Thirty");
        treeMap1.put(40, "Forty");
        treeMap1.put(50, "Fifty");

        System.out.println("ceiling: " + treeMap1.ceilingEntry(25));
        System.out.println("floor: " + treeMap1.floorEntry(25));

        TreeMap<Integer, Integer> treemap = new TreeMap<>();

        // populating tree map
        treemap.put(2, 2);
        treemap.put(1, 1);
        treemap.put(3, 3);
        treemap.put(6, 6);
        treemap.put(5, 5);

        System.out.println("Ceiling entry for 4: "+ treemap.ceilingEntry(4));
        System.out.println("Ceiling entry for 5: "+ treemap.floorEntry(5));



    }
}
