package com.recursion;

import java.util.HashSet;
import java.util.Objects;

class Student {
    public Integer id;
    public String name;

    public Student() {
    }

    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public int hashCode() {
        if (this.id == null || this.name == null) {
            return 0;
        } else {
            return super.hashCode();
        }
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
        if (this.name == null || student.name == null || this.id == null || student.id == null) {
            return true;
        }
        return this.name.equals(student.name) && this.id == student.id;
    }


    public String toString() {
        return "Student: " +  "@" + hashCode();
    }


}

public class Testing {

    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();

        //studentList.add(null);
        Student st1 = new Student();
        Student st2 = new Student("Rahul", 3);
        Student st3 = new Student("Nimit", 1);
        Student st4 = new Student(null, 4);
        Student st5 = new Student(null, 5);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);

        System.out.println(studentList.size()); // 3

        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList); // 3
    }
}

