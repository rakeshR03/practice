package Concept.ComparatorTesting;

import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {
        Comparator<Student> comparator = new Comparator<>(){
            @Override
            public int compare(Student st1, Student st2) {
                if (st1.id > st2.id) {
                    return 1;
                } else if (st1.id < st2.id) {
                    return -1;
                } else {
                    return st1.name.compareTo(st2.name);
                }
            }
        };
        Student st1 = new Student(15, "Alpha");
        Student st2 = new Student(13, "Beta");
        Student st3 = new Student(2, "Charlie");
        Student st4 = new Student(1, "Dick");
        Student st5 = new Student(10, "Eggie");
        Student st6 = new Student(1, "Alice");

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);

        System.out.println(students);

        Collections.sort(students, comparator);
        System.out.println("After sorting :");
        System.out.println(students);

    }
}
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return this.id +" "+this.name;
    }
}
