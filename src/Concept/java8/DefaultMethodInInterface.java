package Concept.java8;

public class DefaultMethodInInterface {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}
interface Parent {
    default void display(){
        System.out.println("Hello");
    }
}

class Child implements Parent {
    @Override
    public void display(){
        System.out.println("Child Hello");
    }
}
