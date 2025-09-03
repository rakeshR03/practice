package Concept.exceptions;

public class UnCheckedExceptionTest {
    public static void main(String[] args) {
        System.out.println("main start");
        method1();
        System.out.println("main end");
    }

    public static void method1() {
        throw new ArithmeticException();
    }
}
