package Concept.collectionFrameworkTest.listInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()) {
            int nextVal = listIterator.next();
            System.out.println("val: "+nextVal+", nextIndex : "+listIterator.nextIndex()
                    +", previousIndex: "+listIterator.previousIndex());
            if (nextVal == 2) {
                listIterator.add(100);
            }
        }
        list.forEach(val -> System.out.println(val));

        System.out.println("backward traversal");

        ListIterator<Integer> listIterator1 = list.listIterator(list.size());
        while(listIterator1.hasPrevious()) {
            int previousVal = listIterator1.previous();
            System.out.println("val: "+previousVal+", nextIndex : "+listIterator1.nextIndex()
                    +", previousIndex: "+listIterator1.previousIndex());
            if (previousVal == 2) {
                listIterator1.set(600);
            }
        }
        list.forEach(val -> System.out.println(val));
    }
}
