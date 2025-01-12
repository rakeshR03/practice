package Concept;
import java.util.*;

public class CheckHashCode {
    public static void main(String[] args) {
        Student student = new Student("Anu", 1);
        Student student1 = new Student("Anu", 1);

        Map<Student, String> map = new HashMap<>();
        map.put(student, "CSE");
        map.put(student1, "IT");

        for(Student stud : map.keySet()) {
            System.out.println("key : " + stud);
            System.out.println("value : " + map.get(stud));
        }


    }
}

class Student {
    String name;
    int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Student : " + this.name + " @ " + Integer.toHexString(this.hashCode());
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Student student = (Student) obj;
        return this.name.equals(student.name) && this.id == student.id;
    }
}
