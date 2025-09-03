package Concept.Class.NestedClasses.PrivateStaticNestedClass;



public class PrivateStaticNestedClass {
    public static void main(String[] args) {
        // static nested class object
        OuterClass outerObj = new OuterClass();
        outerObj.display();
    }
}

class OuterClass {
    int instanceVariable = 10;
    static int classVariable = 20;

    public void display() {
        NestedClass nestedObj = new NestedClass();
        nestedObj.print();
    }

    private static class NestedClass {
        public void print() {
            System.out.println("class variable : "+classVariable );
        }

    }
}

