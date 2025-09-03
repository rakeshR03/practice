package Concept.singletonTest.billPughSolution;

public class BillPughSingletonTest {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        System.out.println("object : "+obj);
        Singleton obj1 = Singleton.getInstance();
        System.out.println("object : "+obj1);
    }
}

class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        private static final Singleton SINGLETON_OBJECT = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.SINGLETON_OBJECT;
    }
}
