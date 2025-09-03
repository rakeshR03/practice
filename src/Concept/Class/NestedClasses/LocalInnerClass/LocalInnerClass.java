package Concept.Class.NestedClasses.LocalInnerClass;

public class LocalInnerClass {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass(5);
        outerObj.display();
    }
}

class OuterClass {
    int instanceVar;
    static int classVar = 10;

    OuterClass(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    public void display() {
        int methodLocalVariable = 5;
        class LocalInnerClass {
            int localInnerVar = 4;

            public void print() {
                System.out.println("class var : " + classVar + ", instance var : "
                        + instanceVar + ", localInnerVar : " + localInnerVar);
            }
        }
        LocalInnerClass localObj = new LocalInnerClass();
        localObj.print();
    }
}
