package Concept.Class;

public class SubclassTest {
    public static void main(String[] args) {
        SubclassTest obj = new SubclassTest();
        Object obj1 = new Audi(5);

        Audi audi = new Audi(10);
        try {
            Object obj2 = (Object) audi.clone();
            System.out.println("obj2 : "+obj2);
        } catch (CloneNotSupportedException ex) {
            System.out.println("ex: "+ex);
        }
        System.out.println("class of audi : " +obj1.getClass());
        System.out.println("instance of audi : " +(obj1 instanceof Audi));
    }
}
class Audi implements Cloneable{
    int mileage;
    Audi(int mileage) {
        this.mileage = mileage;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
