package design_pattern.Creational_design_pattern.BuilderPattern.Singleton;

public class Singleton {
    final static Singleton object = new Singleton();
    private Singleton(){}

    public static Singleton getInstance() {
        return object;
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);
    }
}
