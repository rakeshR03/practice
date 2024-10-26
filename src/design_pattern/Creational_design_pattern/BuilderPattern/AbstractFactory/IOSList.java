package design_pattern.Creational_design_pattern.BuilderPattern.AbstractFactory;

public class IOSList implements List{

    @Override
    public void createList() {
        System.out.println("calling IOS list");
    }
}
