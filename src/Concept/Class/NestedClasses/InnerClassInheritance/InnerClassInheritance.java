package Concept.Class.NestedClasses.InnerClassInheritance;

public class InnerClassInheritance {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass();
        OuterClass.InnerClass2 inner2Obj = outerObj.new InnerClass2();
        inner2Obj.display();
    }
}

class OuterClass {
    int instanceVar = 1;
    static int classVar = 2;

    class InnerClass1 {
        int inner1Var = 5;
    }

    class InnerClass2 extends InnerClass1 {
        int inner2Var = 6;

        void display() {
            System.out.println("sum : " +(instanceVar+classVar+inner1Var+inner2Var));
        }
    }
}