package Concept.Class.NestedClasses.NonStaticInnerClassInheritance;

public class NonStaticInnerClassInheritance {
    public static void main(String[] args) {
        SomeClass someObj = new SomeClass();
        someObj.display1();
    }
}

class OuterClass {
    class InnerClass {
        public void display() {
            System.out.println("inside innerClass");
        }
    }
}
class SomeClass extends OuterClass.InnerClass {
    SomeClass() {
        new OuterClass().super();
    }

    public void display1() {
        display();
    }
}
