package Concept.collectionFrameworkTest;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            System.out.println(val);
        }

        System.out.println("after sublist creation");
        List<Integer> subList = list.subList(1, 3);
        subList.add(6);
        list.forEach(val -> System.out.println(val));
    }
}
