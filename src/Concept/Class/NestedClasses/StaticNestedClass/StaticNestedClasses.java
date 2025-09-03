package Concept.Class.NestedClasses.StaticNestedClass;

public class StaticNestedClasses {
    public static void main(String[] args) {
        // static nested class object
        OuterClass.NestedClass nestedObj = new OuterClass.NestedClass();
        nestedObj.print();
        OuterClass.NestedClass.display();
        // outer class object
        OuterClass outerObj = new OuterClass(10);
        System.out.println("instance variable : " + outerObj.instanceVariable);
        outerObj.showA();
    }
}

class OuterClass {
    int instanceVariable;
    static int classVariable = 20;

    OuterClass(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    void showA() {
        NestedClass nestedObj = new NestedClass();
        System.out.println("a : "+nestedObj.a);
        NestedClass.display();
    }

    static class NestedClass {

        int a = 10;
        public void print() {
            System.out.println("class variable : "+classVariable );
        }

        public static void display() {
            System.out.println("hello");
        }
    }
}
