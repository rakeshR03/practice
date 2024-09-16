package design_pattern.AbstractFactory;

public class IOSList implements List{

    @Override
    public void createList() {
        System.out.println("calling IOS list");
    }
}
