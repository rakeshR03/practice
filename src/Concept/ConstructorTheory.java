package Concept;

class Parent {
    Parent() {
        System.out.println("Parent : No arg constructor");
    }

    Parent(String str) {
        System.out.println("Parent : one arg constructor " + str);
    }

}
public class ConstructorTheory extends Parent {

    ConstructorTheory() {
        this("subclass");
        System.out.println("ConstructorTheory : no arg constructor");
    }

    ConstructorTheory(String str) {
        System.out.println("ConstructorTheory : one arg constructor " + str);
    }

    public static void main(String[] args) {

        ConstructorTheory constructorTheory = new ConstructorTheory();

    }
}

