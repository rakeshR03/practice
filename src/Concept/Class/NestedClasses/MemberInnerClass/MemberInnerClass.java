package Concept.Class.NestedClasses.MemberInnerClass;

public class MemberInnerClass {
    public static void main(String[] args) {
        OuterClass outerObj = new OuterClass(10);
        OuterClass.InnerClass innerObj = outerObj.new InnerClass();
        innerObj.display();
        // inner class static method
        OuterClass.InnerClass.show();
        outerObj.showInnerVar();
    }
}

class OuterClass {
    int instanceVar;
    static int classVar = 10;

    OuterClass(int instanceVar) {
        this.instanceVar = instanceVar;
    }

    class InnerClass {

        int innerVar = 5;
        public void display() {
            System.out.println("class var : " + classVar + ", instance var : " + instanceVar);
        }

        public static void show() {
            System.out.println("hello");
        }
    }

    public void showInnerVar() {
        InnerClass inner = new InnerClass();
        System.out.println("inner var :"+ inner.innerVar);
        inner.display();
        InnerClass.show();
    }

}
