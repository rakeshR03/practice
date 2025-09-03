package Concept.collectionFrameworkTest.MethodLoading;

public class MethodLoadingTest {
    public static void main(String[] args) {
        Apple ab = new Apple();
        System.out.println(("int sum : "+ab.add(10l, 15l)));
        System.out.println(("double sum : "+ab.add(10.5f, 12.0f)));
        System.out.println("end");
    }

}
class Apple {

    int add(int a, int b) {
        System.out.println("int method");
        return a+b;
    }
//    double add(float a, float b) {
//        System.out.println("float method");
//        return a+b;
//    }
    double add(double a, double b) {
        System.out.println("double method");
        return a+b;
    }
}
